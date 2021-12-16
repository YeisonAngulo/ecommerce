package co.com.tul.ecommerce.model.entity

import java.sql.Timestamp
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table


@Table(name = "CART")
@Entity
data class Cart(

        @Id
    @Column(name = "ID_CART", nullable = false, length = 50)
        var idCart: String,

        @Column(name = "TOTAL_VALUE", nullable = false)
        var totalValue: Double,

        @Column(name = "STATUS", nullable = false, length = 10)
        var status: String,

        @Column(name = "DATE_CREATED", nullable = false, length = 10)
        var dateCreated: Timestamp,

        /*@OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val cartDetail: List<Product>*/
)
