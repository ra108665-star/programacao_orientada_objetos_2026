package com.example.crudproject.controller;

import com.example.crudproject.model.Cliente;
import com.example.crudproject.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/email/{email}")
    public Cliente getByEmail(@PathVariable String email) {
        return clienteService.findByEmail(email);
    }
}