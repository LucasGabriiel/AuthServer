package br.pucpr.authserver.drugstore.itens

import jakarta.persistence.*


@Entity
data class Item(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nome: String,

    @Column(nullable = false)
    val preco: Double
)