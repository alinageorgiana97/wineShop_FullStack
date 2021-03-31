package com.ag.WineShop.service;

import com.ag.WineShop.dto.WineCategoryDTO;
import com.ag.WineShop.entity.Wine;
import com.ag.WineShop.entity.WineCategory;

import java.util.List;

public interface WineCategoryService {

    Integer save(WineCategoryDTO wineCategoryDTO);

    Integer update(WineCategoryDTO wineCategoryDTO);

    void delete(Integer id);

    List<WineCategoryDTO> findAll();

    WineCategoryDTO findById(Integer id);

    public WineCategory findEntityById(Integer id);
}
