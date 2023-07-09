package br.pucpr.authserver.Orders

import org.springframework.stereotype.Service

@Service
class PedidoService(private val pedidoRepository: PedidoRepository) {

    fun obterPedidoPorId(id: Long): Pedido? {
        return pedidoRepository.findById(id).orElse(null)
    }

    fun obterTodosPedidos(): List<Pedido> {
        return pedidoRepository.findAll()
    }

    fun atualizarPedido(pedido: Pedido): Pedido {
        return pedidoRepository.save(pedido)
    }

    fun deletarPedido(id: Long) {
        pedidoRepository.deleteById(id)
    }
}
