package br.pucpr.authserver.drugstore.itens

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/itens")
class ItemController(val itemService: ItemService) {
    @PostMapping
    fun criarItem(@RequestBody item: Item): Item {
        return itemService.criarItem(item)
    }

    @GetMapping("/{id}")
    fun obterItemPorId(@PathVariable id: Long): Item? {
        return itemService.obterItemPorId(id)
    }

    @GetMapping
    fun obterTodosItens(): List<Item> {
        return itemService.obterTodosItens()
    }

    @PutMapping
    fun atualizarItem(@RequestBody item: Item): Item {
        return itemService.atualizarItem(item)
    }

    @DeleteMapping("/{id}")
    fun deletarItem(@PathVariable id: Long) {
        itemService.deletarItem(id)
    }
}