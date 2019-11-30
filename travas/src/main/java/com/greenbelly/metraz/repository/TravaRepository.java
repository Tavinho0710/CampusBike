package com.greenbelly.metraz.repository;

import com.greenbelly.metraz.model.Trava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TravaRepository extends JpaRepository<Trava, Long>, QuerydslPredicateExecutor{
}
