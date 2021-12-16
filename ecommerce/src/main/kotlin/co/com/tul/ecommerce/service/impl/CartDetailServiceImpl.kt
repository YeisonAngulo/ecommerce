package co.com.tul.ecommerce.service.impl

import co.com.tul.ecommerce.model.entity.CartDetail
import co.com.tul.ecommerce.repository.ICartDetailRepository
import co.com.tul.ecommerce.service.ICartDetailService
import org.springframework.stereotype.Service

@Service
class CartDetailServiceImpl (private val cartDetailRepository: ICartDetailRepository ) : ICartDetailService {
    override fun createDetail(cartDetail: CartDetail) {
        cartDetailRepository.save(cartDetail)
    }

    override fun getCartsSummary(): List<CartDetail> {
        return cartDetailRepository.findAll().toList()
    }
}