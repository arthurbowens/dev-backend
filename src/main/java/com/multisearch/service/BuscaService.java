package com.multisearch.service;

import com.multisearch.dto.GrupoResultadoDto;
import com.multisearch.dto.ItemResultadoDto;
import com.multisearch.dto.ResultadoBuscaDto;
import com.multisearch.mapper.ResultadoMapper;
import com.multisearch.repository.DadosRepository;
import com.multisearch.util.TextoBuscaUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class BuscaService {

    private final DadosRepository dadosRepository;
    private final ResultadoMapper resultadoMapper;
    private final TextoBuscaUtil textoBuscaUtil;

    public BuscaService(
            DadosRepository dadosRepository,
            ResultadoMapper resultadoMapper,
            TextoBuscaUtil textoBuscaUtil
    ) {
        this.dadosRepository = dadosRepository;
        this.resultadoMapper = resultadoMapper;
        this.textoBuscaUtil = textoBuscaUtil;
    }

    public ResultadoBuscaDto buscar(String textoBusca) {
        String texto = textoBusca == null ? "" : textoBusca.trim();

        List<GrupoResultadoDto> grupos = List.of(
                montarGrupo("Pedidos de Venda", dadosRepository.buscarPedidosVenda(), texto, resultadoMapper::dePedidoVenda),
                montarGrupo("Pedidos de Compra", dadosRepository.buscarPedidosCompra(), texto, resultadoMapper::dePedidoCompra),
                montarGrupo("Produtos", dadosRepository.buscarProdutos(), texto, resultadoMapper::deProduto),
                montarGrupo("Equipamentos", dadosRepository.buscarEquipamentos(), texto, resultadoMapper::deEquipamento),
                montarGrupo("Mão de obra", dadosRepository.buscarMaoDeObra(), texto, resultadoMapper::deMaoDeObra)
        );

        int total = grupos.stream()
                .mapToInt(grupo -> grupo.itens().size())
                .sum();

        return new ResultadoBuscaDto(total, grupos);
    }

    private GrupoResultadoDto montarGrupo(
            String categoria,
            List<Map<String, Object>> registros,
            String textoBusca,
            Function<Map<String, Object>, ItemResultadoDto> normalizar
    ) {
        List<ItemResultadoDto> itens = registros.stream()
                .filter(registro -> textoBuscaUtil.contemTexto(registro, textoBusca))
                .map(normalizar)
                .toList();

        return new GrupoResultadoDto(categoria, itens);
    }
}
