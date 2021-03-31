package com.ag.WineShop.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Integer id;
    private String review;
    private Boolean approved;
    private Integer rating;
    private Integer wineId;
    private Integer clientId;
    private String clientName;
}
