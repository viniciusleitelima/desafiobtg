package parse;

import com.br.desafiobtg.entity.ItemPedido;
import com.br.desafiobtg.entity.Pedido;
import entity.database.ItemPedidoEntity;
import entity.database.PedidoEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {
    private PedidoMapper(){}

    public static PedidoEntity mapToEntity(Pedido pedido){
        return PedidoEntity.builder()
                .codigoPedido(pedido.getCodigoPedido())
                .codigoCliente(pedido.getCodigoCliente())
                .itens(converterItensPedido(pedido))
                .build();
    }

    public static Pedido mapFromEntity(PedidoEntity pedidoEntity){
        return Pedido.builder()
                .codigoPedido(pedidoEntity.getCodigoPedido())
                .codigoCliente(pedidoEntity.getCodigoCliente())
                .itens(converterItemPedidoEntityToItemPedido(pedidoEntity))
                .build();
    }

    private static List<ItemPedidoEntity> converterItensPedido(Pedido pedido){
        return pedido
                .getItens()
                .stream()
                .map(item -> ItemPedidoEntity.builder()
                        .preco(item.getPreco())
                        .produto(item.getProduto())
                        .quantidade(item.getQuantidade())
                        .build())
                .collect(Collectors.toList());

    }

    private static List<ItemPedido> converterItemPedidoEntityToItemPedido(PedidoEntity pedidoEntity){
        return pedidoEntity
                .getItens()
                .stream()
                .map(item -> ItemPedido.builder()
                        .preco(item.getPreco())
                        .produto(item.getProduto())
                        .quantidade(item.getQuantidade())
                        .build())
                .collect(Collectors.toList());

    }
}
