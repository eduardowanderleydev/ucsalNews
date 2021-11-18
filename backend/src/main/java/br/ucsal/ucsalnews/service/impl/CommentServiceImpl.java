package br.ucsal.ucsalnews.service.impl;

import br.ucsal.ucsalnews.dto.request.CommentDTORequest;
import br.ucsal.ucsalnews.entity.Comment;
import br.ucsal.ucsalnews.exception.ObjectNotFoundException;
import br.ucsal.ucsalnews.repository.CommentRepository;
import br.ucsal.ucsalnews.service.ICommentService;
import br.ucsal.ucsalnews.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private INewService newService;


    @Override
    @Transactional
    public CommentDTORequest insert(CommentDTORequest dto) {
        dto.setId(null);
        Comment obj = new Comment();
        dtoToObj(obj, dto);
        commentRepository.save(obj);
        return new CommentDTORequest(obj);
    }

    @Override
    @Transactional
    public CommentDTORequest update(Long id, CommentDTORequest dto) {
        findById(id);
        Comment newObj = updateData(id, dto);
        commentRepository.save(newObj);
        return new CommentDTORequest(newObj);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        findById(id);
        commentRepository.deleteById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Comment findById(Long id) {
        Optional<Comment> obj = commentRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }


    public Comment dtoToObj(Comment obj, CommentDTORequest dto) {
        obj.setId(dto.getId());
        obj.setDate(dto.getDate());
        obj.setContent(dto.getContent());
        obj.setNews(newService.findById(dto.getNew_id()));
        return obj;
    }

    public Comment updateData(Long id, CommentDTORequest dto) {
        Comment comment = commentRepository.getById(id);
        comment.setContent(dto.getContent());
        comment.setDate(LocalDateTime.now());
        return comment;
    }

}
