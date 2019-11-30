package com.greenbelly.metraz.repository;

import com.greenbelly.metraz.model.Bike;
import com.greenbelly.metraz.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>, QuerydslPredicateExecutor {

    Locacao findByBike(Bike bike);

    @Query("select l from Locacao l where l.usuario.id = ?1 and l.emAberto = true")
    Locacao findByUsuario(Long id);

    @Query("select l from Locacao l where l.emAberto = true")
    List<Locacao> findAllEmAberto();

    @Query("select l from Locacao l where l.emAberto = false")
    List<Locacao> findAllFechado();

}
