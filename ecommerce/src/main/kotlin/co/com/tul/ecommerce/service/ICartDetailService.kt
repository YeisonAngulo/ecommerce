package co.com.tul.ecommerce.service

import co.com.tul.ecommerce.model.entity.CartDetail

interface ICartDetailService {

    fun createDetail(cartDetail: CartDetail)

    fun getCartsSummary() : List<CartDetail>
}