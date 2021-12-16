/**
 *
 */
package co.com.tul.ecommerce.repository

import co.com.tul.ecommerce.model.entity.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * @author Yeison
 *
 */
@Repository
interface IProductRepository : CrudRepository<Product, String>{
}