package ru.gb.sklyarov.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.sklyarov.SessionFactoryMy;

@Component
public class ProductDao {
    private SessionFactory factory;

    @Autowired
    public ProductDao(SessionFactoryMy factory) {
        this.factory = factory.getSessionFactory();
    }

}
