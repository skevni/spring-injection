package ru.gb.sklyarov.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.sklyarov.SessionFactoryMy;
import ru.gb.sklyarov.model.Customer;
import ru.gb.sklyarov.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDao {
    private SessionFactory factory;

    @Autowired
    public OrderDao(SessionFactoryMy factory) {
        this.factory = factory.getSessionFactory();
    }

    public List<Product> getProductsByCustomer(Customer customer) {
        List<Product> productList;

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            productList = session.createQuery("select Product from Order where customer_id=:customer_id", Product.class)
                    .setParameter("customer_id", customer.getId())
                    .getResultList();
            session.getTransaction().commit();
        }

        return productList;
    }

    public List<Product> getProductsByCustomer(Long id) {
        List<Product> productList;

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            productList = session.createQuery("select o.product from Order o where customer_id=:customer_id", Product.class)
                    .setParameter("customer_id", id)
                    .getResultList();
            session.getTransaction().commit();
        }

        return productList;
    }

    public List<Customer> getCustomersByProduct(Product product) {
        List<Customer> customerList;

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            customerList = session.createQuery("select Customer from Order where product_id=:product_id", Customer.class)
                    .setParameter("product_id", product.getId())
                    .getResultList();
            session.getTransaction().commit();
        }

        return customerList;
    }

    public List<Customer> getCustomersByProduct(Long id) {
        List<Customer> customerList;

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            customerList = session.createQuery("select o.customer from Order o where product_id=:product_id", Customer.class)
                    .setParameter("product_id", id)
                    .getResultList();
            session.getTransaction().commit();
        }

        return customerList;
    }
}
