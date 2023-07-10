package br.pucpr.authserver.Orders

import br.pucpr.authserver.exception.BadRequestException
import br.pucpr.authserver.users.UsersService
import jakarta.persistence.Id
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: OrderRepository) {
    fun obeterpedidoporid(id: Long): Order? {
        return orderRepository.findByIdOrNull(id)
    }
    fun criarpedido(request: OrderRequest): Order {
        val order = Order(itens = request.itens.toMutableList())
        return orderRepository.save(order)
    }

    fun obterpedidos(): List<Order> {
        return orderRepository.findAll()
    }

    fun delete(id: Long): Boolean {
        val order = orderRepository.findByIdOrNull(id) ?: return false
        orderRepository.delete(order)
        return true
    }
    fun orderAtt(orderRequest: OrderRequest, id: Long): Order?{
        val order = orderRepository.findByIdOrNull(id)
        if (order != null) {
            order.itens = orderRequest.itens.toMutableList()
            return orderRepository.save(order)
        }
        return null
    }


}
