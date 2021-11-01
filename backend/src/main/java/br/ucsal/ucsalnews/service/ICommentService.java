package br.ucsal.ucsalnews.service;


import br.ucsal.ucsalnews.dto.request.CommentDTORequest;
import br.ucsal.ucsalnews.entity.Comment;

import java.util.List;


public interface ICommentService {

    CommentDTORequest insert(CommentDTORequest dto);

    CommentDTORequest update(Long id, CommentDTORequest dto);

    void delete(Long id);

    List<Comment> findAll();

    Comment findById(Long id);

}
