package com.example.demo.trab.persistence;

import com.example.demo.trab.model.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long>{
    List<Conserto> findAllByAtivoTrue();
}
