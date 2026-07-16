package com.multisearch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ItemResultadoDto(
        String id,
        String descricao,
        Integer quantidade
) {
}
