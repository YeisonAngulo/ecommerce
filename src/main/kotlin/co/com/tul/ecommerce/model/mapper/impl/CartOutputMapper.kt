package co.com.tul.ecommerce.model.mapper.impl

import co.com.tul.ecommerce.model.dto.CartDTO
import co.com.tul.ecommerce.model.entity.Cart
import co.com.tul.ecommerce.model.mapper.IMapper


import co.com.tul.ecommerce.model.output.CartOutput

class CartOutputMapper : IMapper<Cart, CartOutput> {
    override fun toEntity(domain: Cart): CartOutput {
        TODO("Not yet implemented")
    }

    fun map(domain: Cart, result: String): CartOutput =
            CartOutput(domain.idCart, result)

}