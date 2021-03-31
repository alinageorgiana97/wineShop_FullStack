package com.ag.WineShop.mapper;

import com.ag.WineShop.dto.AdminDTO;
import com.ag.WineShop.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class AdminMapper {

    public abstract Admin toEntity(AdminDTO adminDTO);
    public abstract void toEntityUpdate(@MappingTarget Admin admin, AdminDTO adminDTO);
    public abstract AdminDTO toDTO(Admin admin);
}
