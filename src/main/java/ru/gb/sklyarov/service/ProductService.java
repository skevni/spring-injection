package ru.gb.sklyarov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.sklyarov.dao.ProductDao;

@Service
public class ProductService {
    private ProductDao productRepository;

    @Autowired
    public ProductService(ProductDao productRepository) {
        this.productRepository = productRepository;
    }

}
