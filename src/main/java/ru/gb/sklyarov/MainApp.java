package ru.gb.sklyarov;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.gb.sklyarov.service.OrderService;

public class MainApp {
    private static SessionFactory sessionFactory;
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = applicationContext.getBean(OrderService.class);
//        sessionFactory = new SessionFactoryMy().getSessionFactory();

//        Product product = sessionFactory.
        Long productCount = 5L;
        while(productCount>0) {
            System.out.println("Buyers of product # " + productCount);
            System.out.println(orderService.getCustomersByProduct(productCount));
            productCount--;
        }
        System.out.println("");
        System.out.println("======================================================");
        System.out.println("");
        Long customerCount = 5L;
        while(customerCount>0) {
            System.out.println("Products of buyer # " + customerCount);
            System.out.println(orderService.getProductsByCustomer(customerCount));
            customerCount--;
        }

    }
}
