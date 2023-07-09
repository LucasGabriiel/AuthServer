package br.pucpr.authserver.Orders

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pedidos")
class PedidoController(private val pedidoService: PedidoService) {

    @GetMapping("/{id}")
    fun obterPedidoPorId(@PathVariable id: Long): Pedido? {
        return pedidoService.obterPedidoPorId(id)
    }

    @GetMapping
    fun obterTodosPedidos(): List<Pedido> {
        return pedidoService.obterTodosPedidos()
    }

    @PutMapping
    fun atualizarPedido(@RequestBody pedido: Pedido): Pedido {
        return pedidoService.atualizarPedido(pedido)
    }

    @DeleteMapping("/{id}")
    fun deletarPedido(@PathVariable id: Long) {
        pedidoService.deletarPedido(id)
    }
}
