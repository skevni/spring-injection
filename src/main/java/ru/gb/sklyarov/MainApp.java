package ru.gb.sklyarov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cartService = context.getBean(CartService.class);
        ProductService productService = context.getBean(ProductService.class);

//        cartService.addProduct(productService.getProductById(2L));
//        cartService.addProduct(productService.getProductById(5L));
//

        Scanner scanner = new Scanner(System.in);


        boolean isBuying = true;

        while (isBuying) {
            System.out.println("Выберите действие: 1 - добавить в корзину, 2 - удалить из корзины, 3 - содержимое корзины, 4 - завершить заказ");
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Выберите товар для добавления в корзину из списка (введите id)");
                        printProductsList(productService);
                        cartService.addProduct(productService.getProductById(scanner.nextLong()));
                        break;
                    case 2:
                        if (cartService.getCartContent().size() > 0) {
                            System.out.println("Выберите товар для удаления из корзины (введите id)");
                            printCartContent(cartService);
                            cartService.deleteProduct(scanner.nextLong());
                        } else {
                            System.out.println("Корзина пуста!");
                        }
                        break;
                    case 3:
                        printCartContent(cartService);
                        break;
                    default:
                        isBuying = false;
                        break;
                }
            }
        }
        System.out.println("Ваш заказ:");
        printCartContent(cartService);
        scanner.close();
//        System.out.println(cartService.getCartContent());
    }

    public static void printProductsList(ProductService productService) {
        System.out.println(productService.getAllProducts());
    }

    public static void printCartContent(CartService cartService) {
        System.out.println(cartService.getCartContent());
    }
}
