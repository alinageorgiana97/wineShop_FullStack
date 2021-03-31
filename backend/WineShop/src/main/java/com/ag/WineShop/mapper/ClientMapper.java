package com.ag.WineShop.mapper;

import com.ag.WineShop.dto.ClientDTO;
import com.ag.WineShop.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class ClientMapper {

    public abstract Client toEntity(ClientDTO clientDTO);
    public abstract void toEntityUpdate(@MappingTarget Client client, ClientDTO clientDTO);
    public abstract ClientDTO toDTO(Client client);
}
