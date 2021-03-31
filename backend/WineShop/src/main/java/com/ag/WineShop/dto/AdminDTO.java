package com.ag.WineShop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    private Integer id;
    private UserDTO user;
    private String firstName;
    private String lastName;
}
