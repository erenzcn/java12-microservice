package org.example.auth.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String name;
    private String password;
    private String surname;
    private String username;
    private String email;
}
