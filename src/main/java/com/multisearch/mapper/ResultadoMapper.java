package com.multisearch.mapper;

import com.multisearch.dto.ItemResultadoDto;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResultadoMapper {

    public ItemResultadoDto dePedidoVenda(Map<String, Object> pedido) {
        return new ItemResultadoDto(
                String.valueOf(pedido.get("SalesOrderID")),
                String.valueOf(pedido.get("MaterialName")),
                paraInteiro(pedido.get("Quantity"))
        );
    }

    public ItemResultadoDto dePedidoCompra(Map<String, Object> pedido) {
        return new ItemResultadoDto(
                String.valueOf(pedido.get("PurchaseOrderID")),
                String.valueOf(pedido.get("MaterialName")),
                paraInteiro(pedido.get("Quantity"))
        );
    }

    public ItemResultadoDto deProduto(Map<String, Object> produto) {
        return new ItemResultadoDto(
                String.valueOf(produto.get("MaterialID")),
                String.valueOf(produto.get("MaterialName")),
                null
        );
    }

    public ItemResultadoDto deEquipamento(Map<String, Object> equipamento) {
        return new ItemResultadoDto(
                String.valueOf(equipamento.get("EquipmentID")),
                String.valueOf(equipamento.get("EquipmentName")),
                null
        );
    }

    public ItemResultadoDto deMaoDeObra(Map<String, Object> pessoa) {
        return new ItemResultadoDto(
                String.valueOf(pessoa.get("WorkforceID")),
                pessoa.get("Name") + " - " + pessoa.get("Shift"),
                null
        );
    }

    private Integer paraInteiro(Object valor) {
        if (valor == null) {
            return null;
        }

        if (valor instanceof Number numero) {
            return numero.intValue();
        }

        return Integer.valueOf(String.valueOf(valor));
    }
}
