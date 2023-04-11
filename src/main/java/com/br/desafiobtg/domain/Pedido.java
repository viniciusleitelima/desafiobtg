package com.br.desafiobtg.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pedido{
    private Integer codigoPedido;
    private Integer codigoCliente;
    private List<ItemPedido> itens;


}
