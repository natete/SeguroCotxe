package jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 *
 * @author natete
 * @since 02/08/17.
 */
@Entity
@Table(name="model")
public class ModelJPA implements Serializable {

    private static final long serialVersionUID = -5158154275011096213L;

    @Id
    private int id;

    @Column
    private String name;

    @ManyToOne
	@JoinColumn(name="brand")
    private BrandJPA brand;

    public ModelJPA() {
    }

    public ModelJPA(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrandJPA getBrand() {
        return brand;
    }

    public void setBrand(BrandJPA brand) {
        this.brand = brand;
    }
}
