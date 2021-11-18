package br.ucsal.ucsalnews.service.impl;

import br.ucsal.ucsalnews.dto.request.NewDTORequest;
import br.ucsal.ucsalnews.dto.response.NewDTOResponse;
import br.ucsal.ucsalnews.entity.Category;
import br.ucsal.ucsalnews.entity.New;
import br.ucsal.ucsalnews.entity.User;
import br.ucsal.ucsalnews.exception.ItemNotFoundException;
import br.ucsal.ucsalnews.repository.NewRepository;
import br.ucsal.ucsalnews.repository.UserRepository;
import br.ucsal.ucsalnews.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewServiceImpl implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public NewDTOResponse insert(NewDTORequest dto) {
        dto.setId(null);
        New obj = dtoToObj(dto);
        newRepository.save(obj);
        return new NewDTOResponse(obj);
    }

    @Override
    @Transactional
    public NewDTOResponse update(Long id, NewDTORequest dto) {
        findById(id);
        New obj = updateData(id, dto);
        newRepository.save(obj);
        return new NewDTOResponse(obj);
    }

    @Override
    @Transactional
    public Long deleteById(long id) {
        findById(id);
        newRepository.deleteById(id);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public New findById(long id) {
        Optional<New> optional = newRepository.findById(id);
        return optional.orElseThrow(() -> new ItemNotFoundException(
                "New cannot be found matching to id " + id + "."
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<New> findAll() {
        return newRepository.findAll();
    }

    public New dtoToObj(NewDTORequest dto) {
        New newToReturn = new New();
        newToReturn.setCategories(dto.getCategories().stream().map(obj -> new Category(obj)).collect(Collectors.toList()));
        newToReturn.setContent(dto.getContent());
        newToReturn.setAuthor(findAuthorById(dto.getAuthor_id(), dto));
        newToReturn.setTitle(dto.getTitle());
        newToReturn.setImage(dto.getImage());
        return newToReturn;
    }

    private New updateData(Long id, NewDTORequest dto) {
        New newToReturn = newRepository.findById(id).get();
        newToReturn.setCategories(dto.getCategories().stream().map(obj -> new Category(obj)).collect(Collectors.toList()));
        newToReturn.setContent(dto.getContent());
        newToReturn.setAuthor(findAuthorById(dto.getAuthor_id(), dto));
        newToReturn.setTitle(dto.getTitle());
        newToReturn.setDate(LocalDateTime.now());
        newToReturn.setImage(dto.getImage());
        return newToReturn;
    }

    private User findAuthorById(Long id, NewDTORequest dto) {
        Optional<User> optional = userRepository.findById(dto.getAuthor_id());
        return optional.orElseThrow(() -> new ItemNotFoundException(
                "New cannot be found matching to id " + id + "."
        ));
    }

    @Override
    public Page<New> findPage(Pageable pageable) {
        return newRepository.findAll(pageable);
    }


}
