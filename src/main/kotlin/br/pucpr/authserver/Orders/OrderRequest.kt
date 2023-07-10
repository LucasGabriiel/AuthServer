package br.pucpr.authserver.Orders

import br.pucpr.authserver.drugstore.itens.Item
import jakarta.validation.constraints.NotBlank

data class OrderRequest (

    @field:NotBlank
    val itens: List<Item>
)
