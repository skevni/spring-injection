package ru.gb.sklyarov.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.gb.sklyarov.IProductRepository;
import ru.gb.sklyarov.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InMemoryProductRepositoryImpl implements IProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init(){
        this.products = new ArrayList<>(Arrays.asList(
           new Product(1L, "Product #1", 200.80f),
           new Product(2L, "Product #2", 133.54f),
           new Product(3L, "Product #3", 456.33f),
           new Product(4L, "Product #4", 78.88f),
           new Product(5L, "Product #5", 322.32f)

        ));
    }
    @Override
    public Product getProductBytId(Long id) {
        return products.stream().filter(i -> i.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}
