package com.br.desafiobtg.entities;

import com.br.desafiobtg.domain.ItemPedido;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "pedidos")
public class PedidoEntity {
    @Id
    private String id;
    private Integer codigoPedido;
    private Integer codigoCliente;
    private List<ItemPedido> itens;
}
