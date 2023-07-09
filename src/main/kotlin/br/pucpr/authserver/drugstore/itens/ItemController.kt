package br.pucpr.authserver.drugstore.itens

import br.pucpr.authserver.users.UsersService
import br.pucpr.authserver.users.requests.UserRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

class ItemController(val service: UsersService) {

    fun createItem(@Valid @RequestBody req: UserRequest) =
        service.save(req)
            .toResponse()
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }

    fun delete(@PathVariable("id") id: Long): ResponseEntity<Void> =
        if (service.delete(id)) ResponseEntity.ok().build()
        else ResponseEntity.notFound().build()
}