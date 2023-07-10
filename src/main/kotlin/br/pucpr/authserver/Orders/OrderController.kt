package br.pucpr.authserver.drugstore.orders

import br.pucpr.authserver.Orders.Order
import br.pucpr.authserver.Orders.OrderRequest
import br.pucpr.authserver.Orders.OrderService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class ordercontroller(val orderService: OrderService) {

    @GetMapping("/{id}")
    fun obterPedidoPorId(@PathVariable id: Long): ResponseEntity<Order> {
        return orderService.obeterpedidoporid(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    fun criarpedido(@RequestBody pedidorequest: OrderRequest): Order{
        return orderService.criarpedido(pedidorequest)
    }

    @GetMapping()
    fun listOrders() = orderService.obterpedidos()

    @DeleteMapping("/{id}")
    @PreAuthorize("permitAll()")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Void> =
        if (orderService.delete(id)) ResponseEntity.ok().build()
        else ResponseEntity.notFound().build()

    @Transactional
    @PatchMapping("/{id}")
    @PreAuthorize("permitAll()")
    fun atualizarPedido(@RequestBody orderRequest: OrderRequest, @PathVariable id: Long) =
        orderService.orderAtt(orderRequest, id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()


}