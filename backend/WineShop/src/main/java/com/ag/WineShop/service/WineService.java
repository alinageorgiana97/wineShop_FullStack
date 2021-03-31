package com.ag.WineShop.service;

import com.ag.WineShop.dto.WineDTO;
import com.ag.WineShop.entity.Wine;


import java.util.List;

public interface WineService {

    Integer save(WineDTO wineDTO);

    Integer update(WineDTO wineDTO);

    void delete(Integer id);

    List<WineDTO> findAll();

    WineDTO findById(Integer id);

    public Wine findEntityById(Integer id);


}
