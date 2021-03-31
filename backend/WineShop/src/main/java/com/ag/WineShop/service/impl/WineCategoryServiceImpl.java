package com.ag.WineShop.service.impl;

import com.ag.WineShop.dto.WineCategoryDTO;
import com.ag.WineShop.entity.Wine;
import com.ag.WineShop.entity.WineCategory;
import com.ag.WineShop.mapper.WineCategoryMapper;
import com.ag.WineShop.repository.WineCategoryRepository;
import com.ag.WineShop.service.WineCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WineCategoryServiceImpl  implements WineCategoryService {
    private final WineCategoryMapper wineCategoryMapper;
    private final WineCategoryRepository wineCategoryRepository;

    @Autowired
    public WineCategoryServiceImpl(WineCategoryMapper wineCategoryMapper,
                           WineCategoryRepository wineCategoryRepository) {
        this.wineCategoryMapper = wineCategoryMapper;
        this.wineCategoryRepository = wineCategoryRepository;
    }


    @Override
    public Integer save(WineCategoryDTO wineCategoryDTO) {

        WineCategory wineCategory = wineCategoryMapper.toEntity(wineCategoryDTO);
        return wineCategoryMapper.toDTO(wineCategoryRepository.save(wineCategory)).getId();

    }

    @Override
    public Integer update(WineCategoryDTO wineCategoryDTO) {
        if (wineCategoryDTO.getId() != null) {
            if (!wineCategoryRepository.findById(wineCategoryDTO.getId()).isPresent())
                throw new ResourceNotFoundException("WineCategory not found");
            final WineCategory wineCategory = wineCategoryMapper.toEntity(wineCategoryDTO);
            return wineCategoryMapper.toDTO(wineCategoryRepository.save(wineCategory)).getId();
        }
        throw new ResourceNotFoundException("WineCategory not found");

    }

    @Override
    public void delete(Integer id) {
        if (!wineCategoryRepository.findById(id).isPresent())
            throw new ResourceNotFoundException(" WineCategory not found");
        wineCategoryRepository.delete(wineCategoryRepository.findById(id).get());
    }

    @Override
    public List<WineCategoryDTO> findAll() {
        return wineCategoryRepository.findAll()
                .stream()
                .map(wineCategoryMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public WineCategoryDTO findById(Integer id) {
        return wineCategoryMapper.toDTO(wineCategoryRepository.findById(id).get());
    }

    @Override
    public WineCategory findEntityById(Integer id) {
        Optional<WineCategory> wineCategory = wineCategoryRepository.findById(id);
        if (!wineCategory.isPresent()) {
            throw new ResourceNotFoundException("Wine not found");
        }
        return wineCategory.get();

    }


}
