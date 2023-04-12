package com.br.desafiobtg.controller;

import com.br.desafiobtg.entities.PedidoEntity;
import com.br.desafiobtg.exception.PedidoNaoEncontradoException;
import com.br.desafiobtg.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Operation(summary = "Obtém o valor total de um pedido")
    @GetMapping("/{codigoPedido}/valorTotalPedido")
    public ResponseEntity<String>  valorTotalDoPedido(@PathVariable("codigoPedido") Integer codigoPedido) throws PedidoNaoEncontradoException {
        return ResponseEntity.ok(pedidoService.valorTotalDoPedido(codigoPedido));
    }

    @Operation(summary = "Obtém a quantitdade de pedidos por cliente")
    @GetMapping("/{codigoCliente}/quantidadePorCliente")
    public int quantidadeDePedidosPorCliente(@PathVariable("codigoCliente") Integer codigoCliente) {
        return pedidoService.quantidadeDePedidosPorCliente(codigoCliente);
    }


    @Operation(summary = "Lista de todos os pedidos referente a um cliente")
    @GetMapping("/{codigoCliente}/pedidosPorCliente")
    public List<PedidoEntity> listaDePedidosPorCliente(@PathVariable("codigoCliente") Integer codigoCliente) {
        return pedidoService.listaDePedidosPorCliente(codigoCliente);
    }
}
