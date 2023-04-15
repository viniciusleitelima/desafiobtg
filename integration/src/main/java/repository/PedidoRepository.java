package repository;

import entity.database.PedidoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends MongoRepository<PedidoEntity, String> {

     PedidoEntity findByCodigoPedido(Integer codigoPedido);

    int countByCodigoCliente(Integer codigoCliente);

    List<PedidoEntity> findByCodigoCliente(Integer codigoCliente);
}
