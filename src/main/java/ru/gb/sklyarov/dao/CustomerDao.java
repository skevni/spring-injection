package ru.gb.sklyarov.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.sklyarov.SessionFactoryMy;

@Component
public class CustomerDao {
    private SessionFactory factory;

    @Autowired
    public CustomerDao(SessionFactoryMy factory) {
        this.factory = factory.getSessionFactory();
    }
}
