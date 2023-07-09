package br.pucpr.authserver.drugstore.itens

import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextStartedEvent
import org.springframework.stereotype.Component



@Component
class itemBootstrap(
        val roleItemRepository: RoleItemRepository
): ApplicationListener<ContextStartedEvent>{

    override fun onApplicationEvent(event: ContextStartedEvent) {
        if (roleItemRepository.count() == 0L) {
            roleItemRepository.save(RoleItem(name = "LISTA", preco = 10.0))
            roleItemRepository.save(RoleItem(name = "USER", preco = 10.0))
        }
    }
}