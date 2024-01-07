package org.example.studyspringdatajpa.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserRepositoryOnlyWithHibernate userRepositoryOnlyWithHibernate;

    @PostMapping
    void createUser(
        @RequestParam String name,
        @RequestParam String email
    ) {
        userRepositoryOnlyWithHibernate.createUser(name, email);
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResponse> findUser(
        @PathVariable Long id
    ) {
        User user = userRepositoryOnlyWithHibernate.findUser(id).orElseThrow();
        return ResponseEntity.ok(new UserResponse(user));
    }
}
