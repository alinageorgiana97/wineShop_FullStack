package com.ag.WineShop.service;

import com.ag.WineShop.dto.CommentDTO;

import java.util.List;

public interface CommentService {


    Integer save(CommentDTO commentDTO);

    List<CommentDTO> findAll();

}
