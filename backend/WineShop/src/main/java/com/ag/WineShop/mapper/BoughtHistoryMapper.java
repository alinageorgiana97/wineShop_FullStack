package com.ag.WineShop.mapper;

import com.ag.WineShop.dto.BoughtHistoryDTO;
import com.ag.WineShop.entity.BoughtHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class BoughtHistoryMapper {

    public abstract BoughtHistory toEntity(BoughtHistoryDTO boughtHistoryDTO);
    public abstract void toEntityUpdate(@MappingTarget BoughtHistory boughtHistory, BoughtHistoryDTO boughtHistoryDTO);
    public abstract BoughtHistoryDTO toDTO(BoughtHistory boughtHistory);
}
