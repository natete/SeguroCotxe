package managedbean;

import ejb.BrandFacadeRemote;
import jpa.BrandJPA;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "listBrands")
@ViewScoped
public class ListBrandsMB implements Serializable {
    private static final long serialVersionUID = 5929923575319834382L;

    private BrandFacadeRemote brandFacadeRemote;

    private List<BrandJPA> brands;
    private String brandName;

    @EJB
    public void setBrandFacadeRemote(BrandFacadeRemote brandFacadeRemote) {
        this.brandFacadeRemote = brandFacadeRemote;
    }

    @PostConstruct
    private void init() {
        brands = brandFacadeRemote.listBrands();
    }

    public void createBrand(String name) {
        BrandJPA brand = brandFacadeRemote.addBrand(name);
        brands.add(brand);
    }

    public List<BrandJPA> getBrands() {
        return brands;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
