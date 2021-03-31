package com.ag.WineShop.mapper;

import com.ag.WineShop.dto.CommentDTO;
import com.ag.WineShop.entity.Comment;
import com.ag.WineShop.service.ClientService;
import com.ag.WineShop.service.WineService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring", uses = {WineService.class, ClientService.class})
public  abstract class CommentMapper {
    @Mapping(source = "wineId", target = "wine")
    @Mapping(source = "clientId", target = "client")
    public abstract Comment toEntity(CommentDTO commentDTO);

    public abstract void toEntityUpdate(@MappingTarget Comment comment, CommentDTO commentDTO);

    @Mapping(source = "wine.id", target = "wineId")
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "client.firstName", target = "clientName")
    public abstract CommentDTO toDTO(Comment comment);
}
