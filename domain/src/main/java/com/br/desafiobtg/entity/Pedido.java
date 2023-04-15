package com.br.desafiobtg.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pedido {
    private Integer codigoPedido;
    private Integer codigoCliente;
    private List<ItemPedido> itens;
}
