package com.br.desafiobtg.service;

import com.br.desafiobtg.entity.Pedido;
import com.br.desafiobtg.exception.message.PedidoNaoEncontradoException;
import com.br.desafiobtg.ports.PedidoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {


    private final PedidoPort pedidoPort;
    DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public Pedido criarPedido(Pedido pedido){
        Pedido pedidoEntity = new Pedido();
        pedidoEntity.setCodigoPedido(pedido.getCodigoPedido());
        pedidoEntity.setItens(pedido.getItens());
        pedidoEntity.setCodigoCliente(pedido.getCodigoCliente());
        return pedidoPort.criarPedido(pedidoEntity);
    }

    public String valorTotalDoPedido(Integer codigoPedido) {
        Pedido pedidoEntity = pedidoPort.buscarPeloCodidodoPedido(codigoPedido);
        if (pedidoEntity == null) {
            throw new PedidoNaoEncontradoException("Pedido não encontrado.");
        }
        Double valorTotalDoPedido = pedidoEntity.getItens().stream()
                .mapToDouble(item -> item.getPreco() * item.getQuantidade())
                .sum();
        return decimalFormat.format(valorTotalDoPedido);
    }

    public int quantidadeDePedidosPorCliente(Integer codigoCliente) {
        return pedidoPort.quantidadeDePedidosPorCliente(codigoCliente);
    }

    public List<Pedido> listaDePedidosPorCliente(Integer codigoCliente) {
        return pedidoPort.listaDePedidosPorCliente(codigoCliente);
    }

}
