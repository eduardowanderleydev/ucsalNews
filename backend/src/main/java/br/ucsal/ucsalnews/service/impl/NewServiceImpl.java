package br.ucsal.ucsalnews.service.impl;

import br.ucsal.ucsalnews.entity.New;
import br.ucsal.ucsalnews.repository.NewRepository;
import br.ucsal.ucsalnews.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewServiceImpl implements INewService {

    @Autowired
    private NewRepository repository;

    @Override
    public void save(New obj) {
        repository.save(obj);
    }

    @Override
    public long deleteById(long id) {
        repository.deleteById(id);
        return id;
    }

    @Override
    public New findById(long id) {
        Optional<New> optional = repository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public List<New> findAll() {
        return repository.findAll();
    }
}
