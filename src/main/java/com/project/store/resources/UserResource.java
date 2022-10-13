package com.project.store.resources;

import com.project.store.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> getUser() {
        User u = new User(1L, "Dante", "dante@email.com", "3211-4433", "12345");
        return ResponseEntity.ok(u);
    }
}
