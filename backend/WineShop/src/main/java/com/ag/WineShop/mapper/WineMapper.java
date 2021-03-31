package com.ag.WineShop.mapper;

import com.ag.WineShop.dto.WineDTO;
import com.ag.WineShop.entity.Wine;
import com.ag.WineShop.entity.WineCategory;
import com.ag.WineShop.service.WineCategoryService;
import com.ag.WineShop.service.WineService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring",uses =WineCategoryService.class)
public abstract class WineMapper {

    @Mapping(source = "categoryId", target = "category")
    public abstract Wine toEntity(WineDTO wineDTO);
    public abstract void toEntityUpdate(@MappingTarget Wine wine, WineDTO wineDTO);

    @Mapping(source = "category.id", target = "categoryId")
    public abstract WineDTO toDTO(Wine wine);
}
