package com.br.desafiobtg.ports;


import com.br.desafiobtg.entity.Pedido;

import java.util.List;

public interface PedidoPort {
   

     Pedido criarPedido(Pedido pedido);

    String valorTotalDoPedido(Integer codigoPedido);

    int quantidadeDePedidosPorCliente(Integer codigoCliente);

    List<Pedido> listaDePedidosPorCliente(Integer codigoCliente);
    Pedido buscarPeloCodidodoPedido(Integer codigoPedido);
}
