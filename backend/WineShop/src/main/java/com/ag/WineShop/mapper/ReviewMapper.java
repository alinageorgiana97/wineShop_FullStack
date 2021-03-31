package com.ag.WineShop.mapper;
import com.ag.WineShop.dto.ReviewDTO;
import com.ag.WineShop.entity.Review;
import com.ag.WineShop.service.ClientService;
import com.ag.WineShop.service.WineService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring", uses = {WineService.class, ClientService.class})
public abstract class ReviewMapper {
    @Mapping(source = "wineId", target = "wine")
    @Mapping(source = "clientId", target = "client")
    public abstract Review toEntity(ReviewDTO reviewDTO);

    public abstract void toEntityUpdate(@MappingTarget Review review, ReviewDTO reviewDTO);

    @Mapping(source = "wine.id", target = "wineId")
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "client.firstName", target = "clientName")
    public abstract ReviewDTO toDTO(Review review);
}
