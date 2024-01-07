package org.example.studyspringdatajpa.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private String name;
    private String email;

    public UserResponse(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
