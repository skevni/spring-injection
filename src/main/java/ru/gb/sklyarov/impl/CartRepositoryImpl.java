package ru.gb.sklyarov.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.sklyarov.ICartRepository;
import ru.gb.sklyarov.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class CartRepositoryImpl implements ICartRepository {
    List<Product> productCart;

    @PostConstruct
    public void init(){
        this.productCart = new ArrayList<>();
    }
    @Override
    public boolean addProduct(Product product) {
        return productCart.add(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        productCart.stream().filter(i -> i.getId().equals(id)).findFirst().map(product -> {
            productCart.remove(product);
            return true;
        });
        return false;
    }

    @Override
    public List<Product> getCartContent() {
        return productCart;
    }
}
