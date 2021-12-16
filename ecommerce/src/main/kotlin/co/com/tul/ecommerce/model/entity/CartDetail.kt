package co.com.tul.ecommerce.model.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "CART_DETAIL")
@Entity
data class CartDetail(

    @Id
    @Column(name = "ID_DETAIL", nullable = false, length = 50)
    var idCartDetail: String,

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_CART", nullable = false, updatable = false)
    var idCart: Cart,

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_PRODUCT", nullable = false, updatable = false)
    var idProduct: Product,

    @Column(name = "QUANTITY", nullable = false, length = 4)
    var quantity: Int,
)
