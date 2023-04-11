package com.br.desafiobtg.controller;

import com.br.desafiobtg.entities.PedidoEntity;
import com.br.desafiobtg.exception.PedidoNaoEncontradoException;
import com.br.desafiobtg.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/valorTotalPedido/{codigoPedido}")
    public String valorTotalDoPedido(@PathVariable("codigoPedido") Integer codigoPedido) throws PedidoNaoEncontradoException {
        return pedidoService.valorTotalDoPedido(codigoPedido);
    }

    @GetMapping("/quantidadePorCliente/{codigoCliente}")
    public int quantidadeDePedidosPorCliente(@PathVariable("codigoCliente") Integer codigoCliente) {
        return pedidoService.quantidadeDePedidosPorCliente(codigoCliente);
    }

    @GetMapping("/pedidosPorCliente/{codigoCliente}")
    public List<PedidoEntity> listaDePedidosPorCliente(@PathVariable("codigoCliente") Integer codigoCliente) {
        return pedidoService.listaDePedidosPorCliente(codigoCliente);
    }
}
