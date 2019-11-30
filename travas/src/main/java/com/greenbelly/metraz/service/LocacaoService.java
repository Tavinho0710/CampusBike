package com.greenbelly.metraz.service;

import com.greenbelly.metraz.model.*;
import com.greenbelly.metraz.repository.LocacaoRepository;
import com.greenbelly.metraz.utils.Arduino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    private TravaService travaService;

    @Autowired
    private UserService userService;

    @Autowired
    private LocacaoRepository locacaoRepository;

    private Arduino conn = new Arduino();

    public Locacao insert(Locacao produto) {
        return locacaoRepository.save(produto);
    }

    public Locacao update(Locacao produto) {
        return locacaoRepository.save(produto);
    }

    public List<Locacao> findAll() {
        return locacaoRepository.findAll();
    }

    public List<Locacao> findEmAberto() {
        return locacaoRepository.findAllEmAberto();
    }

    public List<Locacao> findFechado() {
        return locacaoRepository.findAllFechado();
    }

    public Locacao findOne(Long id) {
        return locacaoRepository.findById(id).get();
    }

    public Locacao findByBike(Bike bike) {
        return locacaoRepository.findByBike(bike);
    }

    public Locacao findByUsuario(User usuario) {
        return locacaoRepository.findByUsuario(usuario.getId());
    }

    public void delete(Long id) {
        locacaoRepository.deleteById(id);
    }

    public Message locarBike(Long travaId, Long usuarioId) {

        Trava trava = travaService.findOne(travaId);
        Bike bike = trava.getBike();
        User user = userService.findOne(usuarioId);

        Message mesage;

        if (trava.getBike() != null && trava.getTravaFechada() == true) {

            if (this.findByUsuario(user) != null) {
                mesage = new Message("Seu usuario já possui uma bicicleta emprestada", "alert");
            } else {
                trava.setBike(null);
                trava.setTravaFechada(false);

                Locacao locacao = new Locacao(null, user, bike, trava, null, new Date(), null , true);
                locacao = this.insert(locacao);
                trava = travaService.update(trava);

                conn.comunicacaoArduino("E|"+trava.getNumeroTrava());

                mesage = new Message("Locação efetuada com sucesso", "succes");
            }
        } else {

            Locacao locacao = this.findByUsuario(user);
            if (locacao != null) {

                trava.setBike(locacao.getBike());
                trava.setTravaFechada(true);
                travaService.insert(trava);

                locacao.setEmAberto(false);
                locacao.setDataDevolucao(new Date());
                locacao.setTravaDevolucao(trava);

                this.update(locacao);

                conn.comunicacaoArduino("D|"+trava.getNumeroTrava());

                mesage = new Message("Bicicleta devolvida com sucesso", "succes");
            } else {
                mesage = new Message("Não há bicicleta com seu usuario para devolução", "alert");
            }
        }



        return mesage;
    }

    public Locacao verificarUser(Long usuarioId) {

        Locacao locacao = locacaoRepository.findByUsuario(usuarioId);

        if(locacao == null){
            locacao = new Locacao();
        }

        return locacao;
    }
}

