package persistence;

import com.br.desafiobtg.entity.Pedido;
import com.br.desafiobtg.ports.PedidoPort;
import entity.database.PedidoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import parse.PedidoMapper;
import repository.PedidoRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PedidoAdapter implements PedidoPort {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        try {
            PedidoEntity pedidoEntity = PedidoMapper.mapToEntity(pedido);
            pedidoEntity = pedidoRepository.save(pedidoEntity);
            return PedidoMapper.mapFromEntity(pedidoEntity);
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public String valorTotalDoPedido(Integer codigoPedido) {
        return null;
    }

    @Override
    public int quantidadeDePedidosPorCliente(Integer codigoCliente) {
        return 0;
    }

    @Override
    public List<Pedido> listaDePedidosPorCliente(Integer codigoCliente) {
        return null;
    }

    @Override
    public Pedido buscarPeloCodidodoPedido(Integer codigoPedido) {
        return null;
    }
}

