package br.ucsal.ucsalnews.service;

import br.ucsal.ucsalnews.entity.New;

import java.util.List;

public interface INewService {

    void save(New noticia);
    long deleteById(long id);
    New findById(long id);
    List<New> findAll();
}
