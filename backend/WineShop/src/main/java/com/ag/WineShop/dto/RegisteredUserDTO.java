package com.ag.WineShop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredUserDTO {
    String firstName;
    String lastName;
    String email;
    String password;
}
