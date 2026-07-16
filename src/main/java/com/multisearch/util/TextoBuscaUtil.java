package com.multisearch.util;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TextoBuscaUtil {

    public boolean contemTexto(Map<String, Object> objeto, String textoBusca) {
        if (textoBusca == null || textoBusca.isBlank() || objeto == null) {
            return false;
        }

        String textoNormalizado = textoBusca.toLowerCase().trim();

        return objeto.values().stream()
                .anyMatch(valor -> valor != null
                        && String.valueOf(valor).toLowerCase().contains(textoNormalizado));
    }
}
