package com.paneladev.demo.service;

import com.paneladev.demo.entity.Cliente;
import com.paneladev.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(final ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente save(@RequestBody Cliente cliente) {
        if(Objects.isNull(cliente.getNome())) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        return repository.save(cliente);
    }

}
