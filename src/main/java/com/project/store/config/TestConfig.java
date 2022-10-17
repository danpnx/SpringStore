package com.project.store.config;

import com.project.store.entities.*;
import com.project.store.entities.enums.OrderStatus;
import com.project.store.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product prod1 = new Product(
                null,
                "The Lord of the Rings",
                "Lorem ipsum dolor sit amet, consectetur.",
                new BigDecimal(90.5), ""
        );
        Product prod2 = new Product(
                null, "Smart TV",
                "Nulla eu imperdiet purus. Maecenas ante.",
                new BigDecimal(2190.0), ""
        );
        Product prod3 = new Product(
                null, "Macbook Pro",
                "Nam eleifend maximus tortor, at mollis.",
                new BigDecimal(1250.0), ""
        );
        Product prod4 = new Product(
                null, "PC Gamer",
                "Donec aliquet odio ac rhoncus cursus.",
                new BigDecimal(1200.0), ""
        );
        Product prod5 = new Product(
                null, "Rails for Dummies",
                "Cras fringilla convallis sem vel faucibus.",
                new BigDecimal(100.99), ""
        );

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(prod1, prod2, prod3,prod4, prod5));

        prod1.getCategories().add(cat2);
        prod2.getCategories().add(cat1);
        prod2.getCategories().add(cat3);
        prod3.getCategories().add(cat3);
        prod4.getCategories().add(cat3);
        prod5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(prod1, prod2, prod3,prod4, prod5));

        User user1 = new User(
                null, "Maria Elizabete", "maria@email.com", "94321-1234", "12345@"
        );
        User user2 = new User(
                null, "Alex Santana", "alex@email.com", "91234-4321", "54321@"
        );

        Order order1 = new Order(
                null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED ,user1
        );
        Order order2 = new Order(
                null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID ,user2
        );
        Order order3 = new Order(
                null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT ,user1
        );

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        OrderItem oi1 = new OrderItem(order1, prod1, 2, prod1.getPrice());
        OrderItem oi2 = new OrderItem(order1, prod3, 1, prod3.getPrice());
        OrderItem oi3 = new OrderItem(order2, prod3, 2, prod3.getPrice());
        OrderItem oi4 = new OrderItem(order3, prod5, 2, prod5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);
        Payment pay2 = new Payment(null, Instant.parse("2019-07-01T10:30:21Z"), order2);
        order1.setPayment(pay1);
        order2.setPayment(pay2);
        orderRepository.saveAll(Arrays.asList(order1, order2));
    }
}
