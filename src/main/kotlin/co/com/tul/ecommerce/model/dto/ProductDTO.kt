package co.com.tul.ecommerce.model.dto

import co.com.tul.ecommerce.model.enums.StatusProduct
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class ProductDTO (
        @field:NotEmpty(message = "Must fill value type product field with SIMPLE or DISCOUNT")
        @field:NotNull(message = "Must fill value type product field with SIMPLE or DISCOUNT")
        var typeProduct: String,
        @field:NotEmpty(message = "Must fill value name field")
        @field:NotNull(message = "Must fill value name field")
        var name: String,
        @field:NotEmpty(message = "Must fill value sku field")
        @field:NotNull(message = "Must fill value sku field")
        var sku: String,
        @field:NotEmpty(message = "Must fill value description field")
        @field:NotNull(message = "Must fill value description field")
        var description: String,
        var price: Double,
        var stock: Int,
        var status: StatusProduct
)

