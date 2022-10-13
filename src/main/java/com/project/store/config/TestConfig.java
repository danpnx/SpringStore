package com.project.store.config;

import com.project.store.entities.User;
import com.project.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(
                null, "Maria Elizabete", "maria@email.com", "94321-1234", "12345@"
        );
        User user2 = new User(
                null, "Alex Santana", "alex@email.com", "91234-4321", "54321@"
        );

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
