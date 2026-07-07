package com.example.crudproject.service;

import com.example.crudproject.exception.ValidacaoException;
import com.example.crudproject.model.Cliente;
import com.example.crudproject.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente save(Cliente cliente) {

        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new ValidacaoException(
                    "O nome do cliente não pode ser vazio."
            );
        }

        if (cliente.getEmail() == null || cliente.getEmail().isBlank()) {
            throw new ValidacaoException(
                    "O email do cliente não pode ser vazio."
            );
        }

        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente cliente) {

        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);

        if (clienteExistente == null)
            return null;

        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new ValidacaoException(
                    "O nome do cliente não pode ser vazio."
            );
        }

        if (cliente.getEmail() == null || cliente.getEmail().isBlank()) {
            throw new ValidacaoException(
                    "O email do cliente não pode ser vazio."
            );
        }

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelefone(cliente.getTelefone());

        return clienteRepository.save(clienteExistente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente findByEmail(String email) {

        return clienteRepository.findByEmail(email)
                .orElse(null);
    }
}
