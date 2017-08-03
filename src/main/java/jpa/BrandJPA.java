package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 *
 * @author Jordi Boada
 * @since 02/08/17.
 */
@Entity
@Table(name = "brand")
public class BrandJPA implements Serializable {

    private static final long serialVersionUID = 121499957027713813L;

    @Id
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "brand")
    private Collection<ModelJPA> models;

    public BrandJPA() {
    }

    public BrandJPA(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<ModelJPA> getModels() {
        return models;
    }

    public void setModels(Collection<ModelJPA> models) {
        this.models = models;
    }
}
