package ru.gb.sklyarov;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProductRepository {

    Product getProductBytId(Long id);
    List<Product> getAllProducts();
}
