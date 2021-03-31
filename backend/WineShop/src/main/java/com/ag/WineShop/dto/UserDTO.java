package com.ag.WineShop.dto;

import com.ag.WineShop.enumeration.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String email;
    private String password;
    private Role userRole;
}
