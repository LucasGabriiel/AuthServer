package br.pucpr.authserver.drugstore.itens

import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class DrugListBootstrap(
    val itemRepository: ItemRepository
): ApplicationListener<ContextRefreshedEvent>{

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        val item = generateDrugHormone()
        item.forEach{
            itemRepository.save(it)
        }
    }

    fun generateDrugHormone(): List<Item> {
        val item: MutableList<Item> = mutableListOf()


        val item1 = Item(
            id = 0,
            name = "Trembolona",
            preco = 25.00F
        )
        item.add(item1)

        val item2 = Item(
            id = 1,
            name = "Durateston",
            preco = 20.00F
        )
        item.add(item2)

        val item3 = Item(
            id = 2,
            name = "Hemogenin",
            preco = 29.00F
        )
        item.add(item3)

        val item4 = Item(
            id = 3,
            name = "Stanozolol",
            preco = 100.00F
        )
        item.add(item4)

        val item5 = Item(
            id = 4,
            name = "GH",
            preco = 348.00F
        )
        item.add(item5)
        return item
    }
}