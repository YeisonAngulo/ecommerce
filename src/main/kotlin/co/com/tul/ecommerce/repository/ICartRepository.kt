package co.com.tul.ecommerce.repository

import co.com.tul.ecommerce.model.entity.Cart
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ICartRepository : CrudRepository<Cart, String> {
}