package br.ucsal.ucsalnews.service.impl;

import br.ucsal.ucsalnews.dto.request.UserDTORequest;
import br.ucsal.ucsalnews.dto.response.UserDTOResponse;
import br.ucsal.ucsalnews.entity.User;
import br.ucsal.ucsalnews.exception.BusinessRuleException;
import br.ucsal.ucsalnews.exception.ObjectNotFoundException;
import br.ucsal.ucsalnews.repository.UserRepository;
import br.ucsal.ucsalnews.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTOResponse insert(UserDTORequest dto) {
        dto.setId(null);
        validarEmail(dto.getEmail());
        User obj = new User();
        dtoToObj(obj, dto);
        repository.save(obj);
        return new UserDTOResponse(obj);
    }

    @Override
    public UserDTOResponse update(Long id, UserDTORequest dto) {
        findById(id);
        User newObj = updateData(id, dto);
        repository.save(newObj);
        return new UserDTOResponse(newObj);
    }

    @Override
    public void deleteById(long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public User findById(long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado! id: " + id));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if(existe){
            throw new BusinessRuleException("Email já cadastrado, tente outro!");
        }
    }

    private void dtoToObj(User obj, UserDTORequest dto) {
        obj.setName(dto.getName());
        obj.setEmail(dto.getEmail());
        obj.setPassword(dto.getPassword());
        obj.setUsername(dto.getUserName());
    }

    public User updateData(Long id, UserDTORequest dto) {
        User obj = repository.getById(id);
        obj.setName(dto.getName());
        obj.setEmail(dto.getEmail());
        obj.setPassword(dto.getPassword());
        obj.setUsername(dto.getUserName());
        return obj;
    }
}
