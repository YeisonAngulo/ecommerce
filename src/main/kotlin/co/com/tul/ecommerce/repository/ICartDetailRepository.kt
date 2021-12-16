package co.com.tul.ecommerce.repository

import co.com.tul.ecommerce.model.entity.CartDetail
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ICartDetailRepository : CrudRepository<CartDetail, String>{
}