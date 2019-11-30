package com.greenbelly.metraz.resource;

import com.greenbelly.metraz.model.User;
import com.greenbelly.metraz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UserResource {

    @Autowired
    private UserService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User insert(@RequestBody User User) {
        return service.insert(User);
    }



    @PutMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User User) {
        if (!id.equals(User.getId()))
            return ResponseEntity
                    .badRequest().build();

        return ResponseEntity.ok(service.update(User));
    }

    @GetMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping(path = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha) {
        return service.verifyLogin(usuario, senha);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAll() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
