package com.br.desafiobtg.service;

import com.br.desafiobtg.domain.Pedido;
import com.br.desafiobtg.entities.PedidoEntity;
import com.br.desafiobtg.exception.PedidoNaoEncontradoException;
import com.br.desafiobtg.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public PedidoEntity criarPedido(Pedido pedido){
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setCodigoPedido(pedido.getCodigoPedido());
        pedidoEntity.setItens(pedido.getItens());
        pedidoEntity.setCodigoCliente(pedido.getCodigoCliente());
        return pedidoRepository.save(pedidoEntity);
    }

    public String valorTotalDoPedido(Integer codigoPedido) {
        PedidoEntity pedidoEntity = pedidoRepository.findByCodigoPedido(codigoPedido);
        if (pedidoEntity == null) {
            throw new PedidoNaoEncontradoException("Pedido não encontrado.");
        }
        Double valorTotalDoPedido = pedidoEntity.getItens().stream()
                .mapToDouble(item -> item.getPreco() * item.getQuantidade())
                .sum();
        return decimalFormat.format(valorTotalDoPedido);
    }

    public int quantidadeDePedidosPorCliente(Integer codigoCliente) {
        return pedidoRepository.countByCodigoCliente(codigoCliente);
    }

    public List<PedidoEntity> listaDePedidosPorCliente(Integer codigoCliente) {
        return pedidoRepository.findByCodigoCliente(codigoCliente);
    }

}
