package ru.gb.sklyarov;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.sklyarov.service.OrderService;
import ru.gb.sklyarov.service.ProductService;

public class MainApp {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = applicationContext.getBean(OrderService.class);
        ProductService productService = applicationContext.getBean(ProductService.class);


        long productCount = 5L;
        while (productCount > 0) {
            System.out.println("Buyers of product # " + productCount);
            System.out.println(orderService.getCustomersByProduct(productCount));
            productCount--;
        }
        System.out.println();
        System.out.println("======================================================");
        System.out.println();


        long customerCount = 5L;
        while (customerCount > 0) {
            System.out.println("Products of buyer # " + customerCount);
            System.out.println(orderService.getProductsByCustomer(customerCount));
            customerCount--;
        }
        System.out.println("======================================================");


        /* 4**
            Изменим стоимость товара №1 и убедимся ,что в заказе, цена не изменилась
            purchase costs - стоимость товара в заказе (на момент покупки)
            product cost - стоимость товара
        * */
        productService.changeCost(productService.getById(1L), 5.15);
        System.out.println(orderService.getOrderByCustomer(1L));
        System.out.println("======================================================");
        System.out.println(orderService.getOrderByProduct(1L));
    }
}
