package ru.gb.sklyarov;

public class Product {
    private Long id;
    private String title;
    private float price;

    public Product(Long id, String title, float price) {
        this.id = id;
        this.title = title;
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price + '\n';
    }
}
