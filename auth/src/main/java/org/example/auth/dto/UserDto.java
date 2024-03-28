package org.example.auth.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private int id;
    private String name;
    private String password;
    private Boolean status;
    private String surname;
    private String username;
    private String email;
}
