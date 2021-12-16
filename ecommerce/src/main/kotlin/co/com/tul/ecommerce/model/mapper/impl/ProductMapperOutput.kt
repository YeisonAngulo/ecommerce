package co.com.tul.ecommerce.model.mapper.impl

import co.com.tul.ecommerce.model.entity.Product
import co.com.tul.ecommerce.model.mapper.IMapperOutput
import co.com.tul.ecommerce.model.output.ProductOutput

open class ProductMapperOutput : IMapperOutput<ProductOutput, Product> {

    override fun toDtoList(entities: MutableIterable<Product>): List<ProductOutput>
        = entities.map { e -> ProductOutput(e.idProduct,
        e.typeProduct,
        e.name,
        e.sku,
        e.description,
        e.price,
        e.stock,
        e.status) }.toList()

    override fun toDto(entity: Product): ProductOutput
        = ProductOutput( entity.idProduct,
            entity.typeProduct,
            entity.name,
            entity.sku,
            entity.description,
            entity.price,
            entity.stock,
            entity.status
        )



}