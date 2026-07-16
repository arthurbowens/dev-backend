package com.multisearch.controller;

import com.multisearch.dto.ResultadoBuscaDto;
import com.multisearch.service.BuscaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/busca")
public class BuscaController {

    private final BuscaService buscaService;

    public BuscaController(BuscaService buscaService) {
        this.buscaService = buscaService;
    }

    @GetMapping
    public ResultadoBuscaDto buscar(@RequestParam String texto) {
        return buscaService.buscar(texto);
    }
}
