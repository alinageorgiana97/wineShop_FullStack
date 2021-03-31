package com.ag.WineShop.dto;

import com.ag.WineShop.entity.WineCategory;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WineDTO {

    private Integer id;
    private Integer categoryId;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private int unitsInStock;

}