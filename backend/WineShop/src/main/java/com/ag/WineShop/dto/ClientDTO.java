package com.ag.WineShop.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Integer id;
    private UserDTO user;
    private String firstName;
    private String lastName;
}
