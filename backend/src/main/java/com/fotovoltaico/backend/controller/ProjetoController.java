package com.fotovoltaico.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fotovoltaico.backend.dto.ProjetoDTO;
import com.fotovoltaico.backend.model.Projeto;
import com.fotovoltaico.backend.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
@CrossOrigin
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Projeto> salvar(@RequestBody ProjetoDTO dto) {
        Projeto projeto = projetoService.salvarProjeto(dto);
        return ResponseEntity.ok(projeto);
    }
}