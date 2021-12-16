package co.com.tul.ecommerce.model.mapper.impl

import co.com.tul.ecommerce.commons.util.Util
import co.com.tul.ecommerce.model.dto.CartDTO
import co.com.tul.ecommerce.model.dto.CartDetailDTO
import co.com.tul.ecommerce.model.entity.Cart
import co.com.tul.ecommerce.model.entity.Product
import co.com.tul.ecommerce.model.enums.StatusCart
import co.com.tul.ecommerce.model.mapper.IMapper
import java.sql.Timestamp
import kotlin.streams.toList

open class CartMapper : IMapper<CartDTO, Cart>{

    override fun toEntity(domain: CartDTO): Cart {

        if ("" != domain.idCart && null != domain.idCart)
            return mapCartExist(domain)
        else
            return mapCart()
    }

    private fun mapCart(): Cart = Cart(
            Util().getUUID(),
            0.0,
            StatusCart.OPEN.status,
            Timestamp(System.currentTimeMillis())
    )

    private fun mapCartExist(domain: CartDTO): Cart = Cart(
            domain.idCart,
            0.0,
            StatusCart.OPEN.status,
            Timestamp(System.currentTimeMillis())
    )



}