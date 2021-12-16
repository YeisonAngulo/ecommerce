package co.com.tul.ecommerce.service.impl

import co.com.tul.ecommerce.commons.exceptions.ProductException
import co.com.tul.ecommerce.model.dto.ProductDTO
import co.com.tul.ecommerce.model.entity.Product
import co.com.tul.ecommerce.model.enums.TypeProduct
import co.com.tul.ecommerce.model.mapper.impl.ProductMapper
import co.com.tul.ecommerce.model.mapper.impl.ProductMapperOutput
import co.com.tul.ecommerce.model.output.ProductOutput
import co.com.tul.ecommerce.repository.IProductRepository
import co.com.tul.ecommerce.service.IProductService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl (val productRepository: IProductRepository) : IProductService {

    override fun getProducts(): List<ProductOutput> {
        return ProductMapperOutput().toDtoList(productRepository.findAll())
    }

    @Throws(ProductException::class)
    override fun createProduct(productDTO: ProductDTO): ProductOutput {
        try {
            val product =
                    if (TypeProduct.DISCOUNT.type == productDTO.typeProduct)
                        productRepository.save(ProductMapper().toEntityDiscount(productDTO))
                    else
                        productRepository.save(ProductMapper().toEntity(productDTO))
            return ProductMapperOutput().toDto(product)
        } catch (ex: Exception) {
            throw ProductException(HttpStatus.SERVICE_UNAVAILABLE, "Problem to create product " + productDTO.name)
        }

    }

    @Throws(ProductException::class)
    override fun editProduct(idProduct: String, productDTO: ProductDTO) : ProductOutput {
        if (existProduct(idProduct))
            return ProductMapperOutput().toDto(productRepository.save(ProductMapper().toEntity(idProduct, productDTO)))
        else
            throw ProductException(HttpStatus.NOT_FOUND, "product not found  $productDTO.name")

    }

    @Throws(ProductException::class)
    override fun deleteProduct(idProduct: String) {
        if (existProduct(idProduct))
            productRepository.deleteById(idProduct)
        else
            throw ProductException(HttpStatus.NOT_FOUND, "product not found $idProduct")
    }

    fun existProduct(idProduct: String) : Boolean {
        return productRepository.existsById(idProduct)
    }

    fun getProduct(idProduct: String) : Product {
        if (existProduct(idProduct))
            return productRepository.findById(idProduct).get()
        else
            throw ProductException(HttpStatus.NOT_FOUND, "product not found  $idProduct")
    }
}