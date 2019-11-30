package com.greenbelly.metraz.service;

import com.greenbelly.metraz.model.User;
import com.greenbelly.metraz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User insert(User user) {
        return repository.save(user);
    }

    public User update(User user) {
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findOne(Long id) {
        return repository.findById(id).get();
    }

    public User verifyLogin(String usuario, String senha) {
        User user = repository.verifyLogin(usuario, senha);
        return user != null ? user: null ;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
