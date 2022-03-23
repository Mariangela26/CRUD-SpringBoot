package com.sventas.sventas.controller;

import com.sventas.sventas.model.Cliente;
import com.sventas.sventas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente> >findAll(){
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    public Cliente update(@RequestBody Cliente cliente){
        return clienteService.update(cliente);
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Integer idCiente){
        return clienteService.findById(idCiente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idCliente){
        clienteService.delete(idCliente);
    }

}
