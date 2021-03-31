package com.ag.WineShop.service.impl;

import com.ag.WineShop.dto.WineDTO;
import com.ag.WineShop.entity.Wine;
import com.ag.WineShop.mapper.WineMapper;
import com.ag.WineShop.repository.WineRepository;
import com.ag.WineShop.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WineServiceImpl implements WineService {

    private final WineMapper wineMapper;
    private final WineRepository wineRepository;

    @Autowired
    public WineServiceImpl(WineMapper wineMapper,
                                 WineRepository wineRepository) {
         this.wineMapper = wineMapper;
         this.wineRepository = wineRepository;
    }


    @Override
    public Integer save(WineDTO wineDTO) {

        Wine wine = wineMapper.toEntity(wineDTO);
        return wineMapper.toDTO(wineRepository.save(wine)).getId();

    }

    @Override
    public Integer update(WineDTO wineDTO) {
        if (wineDTO.getId() != null) {
            if (!wineRepository.findById(wineDTO.getId()).isPresent())
                throw new ResourceNotFoundException("Wine not found");
            final Wine wine = wineMapper.toEntity(wineDTO);
            return wineMapper.toDTO(wineRepository.save(wine)).getId();
        }
        throw new ResourceNotFoundException("Wine not found");

    }

    @Override
    public void delete(Integer id) {
        if (!wineRepository.findById(id).isPresent())
            throw new ResourceNotFoundException(" Wine not found");
        wineRepository.delete(wineRepository.findById(id).get());
    }

    @Override
    public List<WineDTO> findAll() {
        return wineRepository.findAll()
                .stream()
                .map(wineMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public WineDTO findById(Integer id) {
        return wineMapper.toDTO(wineRepository.findById(id).get());
    }

    @Override
    public Wine findEntityById(Integer id) {
        Optional<Wine> wine = wineRepository.findById(id);
        if (!wine.isPresent()) {
            throw new ResourceNotFoundException("Wine not found");
        }
        return wine.get();

    }
}
