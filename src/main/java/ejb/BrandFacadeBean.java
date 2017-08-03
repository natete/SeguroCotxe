package ejb;

import jpa.BrandJPA;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BrandFacadeBean implements BrandFacadeRemote {

    private static final String LIST_BRANDS = "BrandJPA.listAll";
    @PersistenceContext(unitName = "SeguroCotxePU")
    private EntityManager entman;

    @Override
    public List<BrandJPA> listBrands() {
        return entman.createNamedQuery(LIST_BRANDS).getResultList();
    }

    @Override
    public BrandJPA addBrand(String name) {
        BrandJPA brand = new BrandJPA(name);

        entman.persist(brand);

        return brand;
    }
}
