package com.greenbelly.metraz.resource;

import com.greenbelly.metraz.model.*;
import com.greenbelly.metraz.service.LocacaoService;
import com.greenbelly.metraz.service.TravaService;
import com.greenbelly.metraz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trava")
public class TravaResource {

    @Autowired
    private TravaService travaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Trava insert(@RequestBody Trava Trava) {
        return travaService.insert(Trava);
    }


    @PutMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trava> update(@PathVariable("id") Long id, @RequestBody Trava Trava) {
        if (!id.equals(Trava.getId()))
            return ResponseEntity
                    .badRequest().build();

        return ResponseEntity.ok(travaService.update(Trava));
    }

    @GetMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Trava findOne(@PathVariable("id") Long id) {
        return travaService.findOne(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Trava> findAll() {
        return travaService.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        travaService.delete(id);
    }
}
