package br.pucpr.authserver.Orders
import br.pucpr.authserver.drugstore.itens.Item
import jakarta.persistence.*

@Entity
@Table(name = "TblOrder")
class Order(
    @Id @GeneratedValue
    var id: Long? = null,

    @ManyToMany
    @JoinTable(
        name = "OrderItem",
        joinColumns = [JoinColumn(name = "idOrder")],
        inverseJoinColumns = [JoinColumn(name = "idItem")]
    )
    var itens: MutableList<Item> = mutableListOf()
)

