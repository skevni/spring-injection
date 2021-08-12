package ru.gb.sklyarov.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Double cost;

    @OneToMany(mappedBy = "product")
    List<Order> orders;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = Math.ceil(cost * 100) / 100;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", product cost=" + String.format("%.2f", cost) +
                '}';
    }
}
