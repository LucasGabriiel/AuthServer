package br.pucpr.authserver.drugstore.itens

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ItemService(private val itemRepository: ItemRepository) {
    fun criarItem(item: Item): Item {
        return itemRepository.save(item)
    }

    fun obterItemPorId(id: Long): Item? {
        return itemRepository.findById(id).orElse(null)
    }

    fun obterTodosItens(): List<Item> {
        return itemRepository.findAll()
    }

    fun atualizarItem(newitem: ItemRequest, id: Long): Item? {
        val originalitem =itemRepository.findByIdOrNull(id)
        if (originalitem != null) {
            originalitem.name = newitem.name ?: originalitem.name
            originalitem.preco = newitem.preco ?: originalitem.preco
            return itemRepository.save(originalitem)
        }
        return null
    }

    fun deletarItem(id: Long) {
        itemRepository.deleteById(id)
    }
}
