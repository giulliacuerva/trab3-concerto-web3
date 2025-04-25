package com.example.demo.trab.model.conserto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long>{
    List<Conserto> findAllByAtivoTrue();
}
