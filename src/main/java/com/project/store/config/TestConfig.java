package com.project.store.config;

import com.project.store.entities.Category;
import com.project.store.entities.Order;
import com.project.store.entities.User;
import com.project.store.entities.enums.OrderStatus;
import com.project.store.repositories.CategoryRepository;
import com.project.store.repositories.OrderRepository;
import com.project.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

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

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
