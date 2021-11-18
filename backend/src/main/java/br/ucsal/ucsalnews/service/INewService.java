package br.ucsal.ucsalnews.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.ucsal.ucsalnews.dto.request.NewDTORequest;
import br.ucsal.ucsalnews.dto.response.NewDTOResponse;
import br.ucsal.ucsalnews.entity.New;

public interface INewService {

    NewDTOResponse insert(NewDTORequest noticia);

    NewDTOResponse update(Long id, NewDTORequest dto);

    Long deleteById(long id);

    New findById(long id);

    List<New> findAll();
    
    Page<New> findPage(Pageable pageable);
}
