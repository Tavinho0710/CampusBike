package com.greenbelly.metraz.repository;

import com.greenbelly.metraz.model.Locacao;
import com.greenbelly.metraz.model.Trava;
import com.greenbelly.metraz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor{

    @Query("select l from User l where l.usuario = ?1 and l.senha = ?2")
    User verifyLogin(String usuario, String senha);
}
