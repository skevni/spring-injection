package ru.gb.sklyarov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.sklyarov.dao.OrderDao;
import ru.gb.sklyarov.model.Customer;
import ru.gb.sklyarov.model.Order;
import ru.gb.sklyarov.model.Product;

import java.util.List;

@Service
public class OrderService {
    private final OrderDao orderRepository;

    @Autowired
    public OrderService(OrderDao orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Customer> getCustomersByProduct(Product product) {
        return orderRepository.getCustomersByProduct(product);
    }

    public List<Customer> getCustomersByProduct(Long id) {
        return orderRepository.getCustomersByProduct(id);
    }

    public List<Product> getProductsByCustomer(Customer customer) {
        return orderRepository.getProductsByCustomer(customer);
    }

    public List<Product> getProductsByCustomer(Long id) {
        return orderRepository.getProductsByCustomer(id);
    }

    public List<Order> getOrderByCustomer(Long customer_id) {
        return orderRepository.getOrderByCustomer(customer_id);
    }

    public List<Order> getOrderByProduct(Long product_id) {
        return orderRepository.getOrderByProduct(product_id);
    }
}
