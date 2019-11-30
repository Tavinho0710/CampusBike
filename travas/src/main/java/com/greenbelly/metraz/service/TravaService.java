package com.greenbelly.metraz.service;

import com.greenbelly.metraz.model.Trava;
import com.greenbelly.metraz.repository.LocacaoRepository;
import com.greenbelly.metraz.repository.TravaRepository;
import com.greenbelly.metraz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravaService {

    @Autowired
    private TravaRepository travaService;

    @Autowired
    private UserRepository userService;

    @Autowired
    private LocacaoRepository locacaoService;

    @Autowired
    private TravaRepository travaRepository;

    public Trava insert(Trava trava) {
        return travaRepository.save(trava);
    }

    public Trava update(Trava trava) {
        return travaRepository.save(trava);
    }

    public List<Trava> findAll() {
        return travaRepository.findAll();
    }

    public Trava findOne(Long id) {
        return travaRepository.findById(id).get();
    }

    public void delete(Long id) {
        travaRepository.deleteById(id);
    }



}
