package entity.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


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
    private List<ItemPedidoEntity> itens;
}

