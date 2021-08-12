package ru.gb.sklyarov.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.sklyarov.SessionFactoryMy;
import ru.gb.sklyarov.model.Product;

@Component
public class ProductDao {
    private final SessionFactory factory;

    @Autowired
    public ProductDao(SessionFactoryMy factory) {
        this.factory = factory.getSessionFactory();
    }

    public void changeCost(Product product, Double delta) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery("update products set cost = cost + :delta where id = :id")
                    .setParameter("id", product.getId())
                    .setParameter("delta", Math.ceil(delta * 100) / 100)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Product getById(Long id) {
        Product product;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = session.find(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }
}
