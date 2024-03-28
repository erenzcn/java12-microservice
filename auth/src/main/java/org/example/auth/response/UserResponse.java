package org.example.auth.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private int id;
    private String name;
    private String password;
    private String surname;
    private String username;
    private String email;
}
