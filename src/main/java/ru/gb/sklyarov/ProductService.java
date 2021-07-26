package ru.gb.sklyarov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    IProductRepository productRepository;

    @Autowired
    public void setProductRepository(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.getProductBytId(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }
}
