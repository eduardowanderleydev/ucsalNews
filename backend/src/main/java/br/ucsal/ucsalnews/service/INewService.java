package br.ucsal.ucsalnews.service;

import br.ucsal.ucsalnews.dto.request.NewDTORequest;
import br.ucsal.ucsalnews.dto.response.NewDTOResponse;
import br.ucsal.ucsalnews.entity.New;

import java.util.List;

public interface INewService {

    NewDTOResponse insert(NewDTORequest noticia);

    NewDTOResponse update(Long id, NewDTORequest dto);

    Long deleteById(long id);

    New findById(long id);

    List<New> findAll();
}
