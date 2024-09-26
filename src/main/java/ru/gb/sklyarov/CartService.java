package ru.gb.sklyarov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartService {

    private ICartRepository cartRepository;

    @Autowired
    public void setCartRepository(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public boolean addProduct(Product product) {
        return cartRepository.addProduct(product);
    }

    public boolean deleteProduct(Long id) {
        return cartRepository.deleteProduct(id);
    }

    public List<Product> getCartContent() {
        return cartRepository.getCartContent();
    }
}
