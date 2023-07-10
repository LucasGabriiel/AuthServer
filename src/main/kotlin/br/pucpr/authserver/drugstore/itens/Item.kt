package br.pucpr.authserver.drugstore.itens

import jakarta.persistence.*

@Entity
@Table(name = "TblItem")
class Item(
    @Id @GeneratedValue
    var id: Long? = null,

    @Column
    var name: String = "",

    @Column
    var preco: Float = 0.0F
)
