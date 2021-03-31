package com.ag.WineShop.service.impl;

import com.ag.WineShop.dto.ReviewDTO;
import com.ag.WineShop.entity.Review;
import com.ag.WineShop.mapper.ReviewMapper;
import com.ag.WineShop.repository.ReviewRepository;
import com.ag.WineShop.repository.WineRepository;
import com.ag.WineShop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;
    private final ReviewRepository reviewRepository;


    @Autowired
    public ReviewServiceImpl(ReviewMapper reviewMapper, ReviewRepository reviewRepository) {
        this.reviewMapper = reviewMapper;
        this.reviewRepository = reviewRepository;

    }


    @Override
    public Integer save(ReviewDTO reviewDTO) {

        Review review = reviewMapper.toEntity(reviewDTO);
        return reviewMapper.toDTO(reviewRepository.save(review)).getId();
    }

    @Override
    public List<ReviewDTO> findAll()  {
        return reviewRepository.findAll()
                .stream()
                .map(reviewMapper::toDTO)
                .collect(Collectors.toList());

    }

}
