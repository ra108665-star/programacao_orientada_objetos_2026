package com.example.crudproject.service;

import com.example.crudproject.model.Orcamento;
import com.example.crudproject.model.StatusOrcamento;
import com.example.crudproject.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    public Orcamento insertOrcamento(Orcamento orcamento){
        return orcamentoRepository.save(orcamento);
    }

    public List<Orcamento> selectAllOrcamento(){
        return orcamentoRepository.findAll();
    }

    public Orcamento selectOrcamentoById(int id){
        Optional<Orcamento> oc = orcamentoRepository.findById((int) id);

        if (oc.isPresent()) {
            return oc.get();
        } else {
            throw new RuntimeException("Orcamento nao encontrado.");
        }
    }

    // status PENDENTE -> APROVADO
    public Orcamento aprovarOrcamento(int id){

        Orcamento oc = selectOrcamentoById(id);
        oc.aprovar();
        return orcamentoRepository.save(oc);
    }

    public void deletarOrcamento(int id){
        orcamentoRepository.deleteById((int) id);
    }

    public Orcamento rejeitarOrcamento(int id){

        Orcamento oc = selectOrcamentoById(id);
        oc.rejeitar();
        return orcamentoRepository.save(oc);
    }

    public List<Orcamento> buscarPorStatus(StatusOrcamento status) {
        return orcamentoRepository.findByStatus(status);
    }
}