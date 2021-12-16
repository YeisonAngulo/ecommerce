package co.com.tul.ecommerce.service;

import co.com.tul.ecommerce.model.dto.ProductDTO
import co.com.tul.ecommerce.model.entity.Product
import co.com.tul.ecommerce.model.output.ProductOutput


/**
 * @author Yeison
 *
 */
interface IProductService {

    fun getProducts(): List<ProductOutput>

    fun createProduct(productDTO: ProductDTO): ProductOutput

    fun editProduct(idProduct: String, productDTO: ProductDTO): ProductOutput

    fun deleteProduct(idProduct: String)
}