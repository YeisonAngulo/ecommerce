package co.com.tul.ecommerce.model.mapper.impl

import co.com.tul.ecommerce.commons.util.Util
import co.com.tul.ecommerce.model.entity.Cart
import co.com.tul.ecommerce.model.entity.CartDetail
import co.com.tul.ecommerce.model.entity.Product
import co.com.tul.ecommerce.model.output.CartSummaryOutput
import co.com.tul.ecommerce.model.output.ProductOutput


class CartDetailMapper {

    fun toEntity(cart: Cart, quantity: Int, product: Product): CartDetail = CartDetail(
            Util().getUUID(),
            cart,
            product,
            quantity
    )

    fun toOutputList(entities: List<CartDetail>): List<CartSummaryOutput>
            = entities.map { e -> CartSummaryOutput(e.idCart.idCart,
            e.idCart.totalValue,
            e.idProduct.idProduct,
            e.idProduct.name,
            e.idProduct.price,
            e.quantity,
            e.idCart.status
            ) }.toList()
}