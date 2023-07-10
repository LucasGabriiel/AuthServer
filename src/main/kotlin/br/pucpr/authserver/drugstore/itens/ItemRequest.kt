package br.pucpr.authserver.drugstore.itens

import jakarta.validation.constraints.NotBlank

data class ItemRequest(
    @field:NotBlank
    var name: String?,

    @field:NotBlank
    var preco: Float?
)
