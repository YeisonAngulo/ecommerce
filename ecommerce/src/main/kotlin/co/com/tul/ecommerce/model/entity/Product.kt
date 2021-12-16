package co.com.tul.ecommerce.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Table(name = "PRODUCT")
@Entity
data class Product(

    @Id
    @Column(name = "ID_PRODUCT", nullable = false, length = 50)
    var idProduct: String,

    @Column(name = "TYPE_PRODUCT", nullable = false, length = 50)
    var typeProduct: String,

    @Column(name = "NAME", nullable = false, length = 100)
    var name: String,

    @Column(name = "SKU", nullable = false, length = 30)
    var sku: String,

    @Column(name = "DESCRIPTION", nullable = false)
    var description: String,

    @Column(name = "PRICE", nullable = false)
    var price: Double,

    @Column(name = "STOCK", nullable = false)
    var stock: Int,

    @Column(name = "STATUS", nullable = false, length = 10)
    var status: String
)
