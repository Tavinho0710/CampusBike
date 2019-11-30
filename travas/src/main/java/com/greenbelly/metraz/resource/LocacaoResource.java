package com.greenbelly.metraz.resource;

import com.greenbelly.metraz.model.Locacao;
import com.greenbelly.metraz.model.Message;
import com.greenbelly.metraz.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("locacao")
public class LocacaoResource {

    @Autowired
    private LocacaoService service;

    @GetMapping(path = "/locar",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Message locar(@RequestParam("userId") Long userId, @RequestParam("travaId") Long travaId) {
        return service.locarBike(travaId, userId);
    }

    @GetMapping(path = "/verificar-user",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Locacao locar(@RequestParam("userId") Long userId) {
        return service.verificarUser(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Locacao insert(@RequestBody Locacao Locacao) {
        return service.insert(Locacao);
    }


    @PutMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Locacao> update(@PathVariable("id") Long id, @RequestBody Locacao Locacao) {
        if (!id.equals(Locacao.getId()))
            return ResponseEntity
                    .badRequest().build();

        return ResponseEntity.ok(service.update(Locacao));
    }

    @GetMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Locacao findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Locacao> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/aberto",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Locacao> findAllAberto() {
        return service.findEmAberto();
    }

    @GetMapping(path = "/fechado",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Locacao> findAllFechado() {
        return service.findFechado();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
