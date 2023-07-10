package br.pucpr.authserver.drugstore.itens

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/itens")
class ItemController(val itemService: ItemService) {
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "AuthServer")
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

    @Transactional
    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    fun atualizarItem(@RequestBody item: ItemRequest, @PathVariable id: Long) =
        itemService.atualizarItem(item, id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "AuthServer")
    fun deletarItem(@PathVariable id: Long) {
        itemService.deletarItem(id)
    }
}