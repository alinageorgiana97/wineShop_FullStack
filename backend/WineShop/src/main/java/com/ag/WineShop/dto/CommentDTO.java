package com.ag.WineShop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private Integer id;
    private String comment;
    private Boolean approved;
    private Integer wineId;
    private Integer clientId;
    private String clientName;

}
