package com.br.desafiobtg.listener;


import com.br.desafiobtg.entity.Pedido;
import com.br.desafiobtg.exception.message.PedidoException;
import com.br.desafiobtg.service.PedidoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class PedidosListener {

    private static final Logger LOGGER = Logger.getLogger(PedidosListener.class.getName());

    @Autowired
    PedidoService pedidoService;

    @RabbitListener(queues = "${queue.consumer}")
    public void receivePedido(@Payload Pedido pedido) {
        LOGGER.info("Mensagem recebida: " + pedido );
        try{
            Pedido pedidoEntity = pedidoService.criarPedido(pedido);
            LOGGER.info("Pedido criado para o id: " + pedidoEntity);
        } catch (Exception e){
            throw new PedidoException(e.getMessage());
        }

    }
}