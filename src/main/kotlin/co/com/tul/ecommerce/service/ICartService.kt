package co.com.tul.ecommerce.service

import co.com.tul.ecommerce.model.dto.CartDTO
import co.com.tul.ecommerce.model.output.CartOutput
import co.com.tul.ecommerce.model.output.CartSummaryOutput

interface ICartService {

    fun createCart(cartDTO: CartDTO) : CartOutput

    fun getCartsSummary() : List<CartSummaryOutput>

    fun checkoutCart(idCart: String)
}