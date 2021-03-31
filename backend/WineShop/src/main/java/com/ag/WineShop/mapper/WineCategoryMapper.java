package com.ag.WineShop.mapper;

import com.ag.WineShop.dto.WineCategoryDTO;
import com.ag.WineShop.entity.WineCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class WineCategoryMapper {

    public abstract WineCategory toEntity(WineCategoryDTO wineCategoryDTO);
    public abstract void toEntityUpdate(@MappingTarget WineCategory wineCategory, WineCategoryDTO wineCategoryDTO);
    public abstract WineCategoryDTO toDTO(WineCategory wineCategory);

}
