package com.ag.WineShop.service.impl;

import com.ag.WineShop.dto.CommentDTO;
import com.ag.WineShop.entity.Comment;
import com.ag.WineShop.mapper.CommentMapper;
import com.ag.WineShop.repository.CommentRepository;
import com.ag.WineShop.repository.WineRepository;
import com.ag.WineShop.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final WineRepository wineRepository;

    public CommentServiceImpl(CommentMapper commentMapper, CommentRepository commentRepository, WineRepository wineRepository) {
        this.commentMapper = commentMapper;
        this.commentRepository = commentRepository;
        this.wineRepository = wineRepository;
    }


    @Override
    public Integer save(CommentDTO commentDTO) {

        Comment comment = commentMapper.toEntity(commentDTO);
        return commentMapper.toDTO(commentRepository.save(comment)).getId();
    }

    @Override
    public List<CommentDTO> findAll()  {
        return commentRepository.findAll()
                    .stream()
                    .map(commentMapper::toDTO)
                    .collect(Collectors.toList());

    }

}
