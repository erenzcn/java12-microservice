package org.example.basket.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse extends BaseResponse{
    private int id;
    private String name;
    private String password;
    private String surname;
    private String username;
    private String email;
}
