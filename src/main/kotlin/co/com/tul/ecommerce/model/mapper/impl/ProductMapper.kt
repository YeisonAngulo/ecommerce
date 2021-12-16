package co.com.tul.ecommerce.model.mapper.impl

import co.com.tul.ecommerce.commons.util.Util
import co.com.tul.ecommerce.model.dto.ProductDTO
import co.com.tul.ecommerce.model.entity.Product
import co.com.tul.ecommerce.model.enums.StatusProduct
import co.com.tul.ecommerce.model.mapper.IMapper


open class ProductMapper : IMapper<ProductDTO, Product> {

    override fun toEntity(domain: ProductDTO): Product = Product(
            Util().getUUID(),
            domain.typeProduct,
            domain.name,
            domain.sku,
            domain.description,
            domain.price,
            domain.stock,
            StatusProduct.ACTIVE.status
    )

    open fun toEntityDiscount(domain: ProductDTO): Product = Product(
            Util().getUUID(),
            domain.typeProduct,
            domain.name,
            domain.sku,
            domain.description,
            domain.price / 2,
            domain.stock,
            StatusProduct.ACTIVE.status
    )

    open fun toEntity(idProduct: String, domain: ProductDTO): Product = Product(
            idProduct,
            domain.typeProduct,
            domain.name,
            domain.sku,
            domain.description,
            domain.price,
            domain.stock,
            domain.status.status
    )

}

