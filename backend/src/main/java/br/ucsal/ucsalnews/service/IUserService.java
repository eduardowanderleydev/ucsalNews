package br.ucsal.ucsalnews.service;

import br.ucsal.ucsalnews.dto.request.UserDTORequest;
import br.ucsal.ucsalnews.dto.response.UserDTOResponse;
import br.ucsal.ucsalnews.entity.User;

import java.util.List;

public interface IUserService {

    UserDTOResponse insert(UserDTORequest dto);

    UserDTOResponse update(Long id, UserDTORequest dto);

    void deleteById(long id);

    User findById(long id);

    List<User> findAll();

    void validarEmail(String email);

    UserDTOResponse autenticar(String email, String senha);


}
