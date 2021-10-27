package br.ucsal.ucsalnews.service;


import br.ucsal.ucsalnews.dto.CommentDTO;
import br.ucsal.ucsalnews.entity.Comment;

import java.util.List;
import java.util.Optional;


public interface CommentService {

    CommentDTO insert(CommentDTO dto);

    CommentDTO update(Long id,CommentDTO dto);

    void delete(Long id);

    List<Comment> findAll();

    Comment findById(Long id);

}
