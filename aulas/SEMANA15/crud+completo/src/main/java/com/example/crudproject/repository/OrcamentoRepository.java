package com.example.crudproject.repository;

import com.example.crudproject.model.Orcamento;
import com.example.crudproject.model.StatusOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {

    List<Orcamento> findByStatus(StatusOrcamento status);

}