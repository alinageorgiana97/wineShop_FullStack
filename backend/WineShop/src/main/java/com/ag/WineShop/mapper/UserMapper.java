package com.ag.WineShop.mapper;

import com.ag.WineShop.dto.UserDTO;
import com.ag.WineShop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class UserMapper {

    public abstract User toEntity(UserDTO userDTO);
    public abstract void toEntityUpdate(@MappingTarget User user, UserDTO userDTO);
    public abstract UserDTO toDTO(User user);
}
