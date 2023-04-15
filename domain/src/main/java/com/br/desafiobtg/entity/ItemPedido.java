package com.br.desafiobtg.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ItemPedido {
    private String produto;
    private int quantidade;
    private double preco;


}
