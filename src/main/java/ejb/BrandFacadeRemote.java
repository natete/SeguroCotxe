package ejb;

import jpa.BrandJPA;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface BrandFacadeRemote {

    List<BrandJPA> listBrands();

    BrandJPA addBrand(String name);
}
