package ru.gb.sklyarov;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICartRepository {
    boolean addProduct(Product product);

    boolean deleteProduct(Long id);

    List<Product> getCartContent();
}
