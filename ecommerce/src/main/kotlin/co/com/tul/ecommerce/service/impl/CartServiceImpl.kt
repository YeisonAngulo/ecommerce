package co.com.tul.ecommerce.service.impl

import co.com.tul.ecommerce.commons.exceptions.ProductException
import co.com.tul.ecommerce.model.dto.CartDTO
import co.com.tul.ecommerce.model.entity.Cart
import co.com.tul.ecommerce.model.enums.StatusCart
import co.com.tul.ecommerce.model.mapper.impl.CartDetailMapper
import co.com.tul.ecommerce.model.mapper.impl.CartMapper
import co.com.tul.ecommerce.model.mapper.impl.CartOutputMapper
import co.com.tul.ecommerce.model.output.CartOutput
import co.com.tul.ecommerce.model.output.CartSummaryOutput
import co.com.tul.ecommerce.repository.ICartRepository
import co.com.tul.ecommerce.service.ICartService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class CartServiceImpl (private val cartRepository: ICartRepository, private val productService: ProductServiceImpl, private val cartDetailService: CartDetailServiceImpl) : ICartService {

    override fun createCart(cartDTO: CartDTO): CartOutput {

        if ("" != cartDTO.idCart && null != cartDTO.idCart)
            cartRepository.deleteById(cartDTO.idCart)

        var cart : Cart = this.createCartEntity(cartDTO)

        var totalValue : Double = 0.0

        cartDTO.cartDetail.forEach { p ->
            var product = productService.getProduct(p.idProduct)
            if (product.idProduct != null)
                if (p.quantity < product.stock) {
                    this.cartDetailService.createDetail(CartDetailMapper().toEntity(cart, p.quantity, product))
                    totalValue = totalValue.plus(product.price)
                }
            else
                throw ProductException(HttpStatus.NOT_FOUND, "product not found  $p.idProduct")
        }
        cart.totalValue = totalValue
        this.cartRepository.save(cart)

        return CartOutputMapper().map(cart, "Cart Created successfully ")
    }

    override fun getCartsSummary(): List<CartSummaryOutput> {
        return CartDetailMapper().toOutputList(this.cartDetailService.getCartsSummary())
    }

    override fun checkoutCart(idCart: String) {
        var cart : Cart = this.cartRepository.findById(idCart).get()
        cart.status = StatusCart.COMPLETED.status
        this.cartRepository.save(cart)
    }

    fun createCartEntity(cartDTO: CartDTO) : Cart = this.cartRepository.save(CartMapper().toEntity(cartDTO))

}