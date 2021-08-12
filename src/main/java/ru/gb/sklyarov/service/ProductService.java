package ru.gb.sklyarov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.sklyarov.dao.ProductDao;
import ru.gb.sklyarov.model.Product;

@Service
public class ProductService {
    private final ProductDao productRepository;

    @Autowired
    public ProductService(ProductDao productRepository) {
        this.productRepository = productRepository;
    }

    public void changeCost(Product product, Double delta) {
        productRepository.changeCost(product, delta);
    }

    public Product getById(Long id) {
        return productRepository.getById(id);
    }

}
