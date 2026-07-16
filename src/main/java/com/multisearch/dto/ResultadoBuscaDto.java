package com.multisearch.dto;

import java.util.List;

public record ResultadoBuscaDto(
        int total,
        List<GrupoResultadoDto> grupos
) {
}
