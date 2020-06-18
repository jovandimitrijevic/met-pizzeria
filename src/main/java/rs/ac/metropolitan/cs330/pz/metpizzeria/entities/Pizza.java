package rs.ac.metropolitan.cs330.pz.metpizzeria.entities;

import javax.persistence.*;

@Entity
@Table(name = "pizza")
public class Pizza {
    @Id
    @Column(name = "pizza_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pizza_id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    public void setPizza_id(Long pizza_id) {
        this.pizza_id = pizza_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getPizza_id() {
        return pizza_id;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizza_id=" + pizza_id +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
