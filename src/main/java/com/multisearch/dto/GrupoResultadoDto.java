package com.multisearch.dto;

import java.util.List;

public record GrupoResultadoDto(
        String categoria,
        List<ItemResultadoDto> itens
) {
}
