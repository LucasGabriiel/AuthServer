package br.pucpr.authserver.drugstore.itens

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

    fun atualizarItem(item: Item): Item {
        return itemRepository.save(item)
    }

    fun deletarItem(id: Long) {
        itemRepository.deleteById(id)
    }
}
