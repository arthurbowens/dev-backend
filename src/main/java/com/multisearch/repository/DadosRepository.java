package com.multisearch.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Repository
public class DadosRepository {

    private final ObjectMapper objectMapper;

    public DadosRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Map<String, Object>> buscarPedidosVenda() {
        return lerArquivo("data/sales_orders.json");
    }

    public List<Map<String, Object>> buscarPedidosCompra() {
        return lerArquivo("data/purchase_orders.json");
    }

    public List<Map<String, Object>> buscarProdutos() {
        return lerArquivo("data/materials.json");
    }

    public List<Map<String, Object>> buscarEquipamentos() {
        return lerArquivo("data/equipments.json");
    }

    public List<Map<String, Object>> buscarMaoDeObra() {
        return lerArquivo("data/workforce.json");
    }

    private List<Map<String, Object>> lerArquivo(String caminho) {
        try (InputStream inputStream = new ClassPathResource(caminho).getInputStream()) {
            return objectMapper.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Erro ao ler o arquivo: " + caminho + " (" + e.getMessage() + ")",
                    e
            );
        }
    }
}
