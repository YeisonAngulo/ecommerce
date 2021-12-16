package co.com.tul.ecommerce.model.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CartDetailDTO(

        @field:NotEmpty(message = "Must fill value idProduct field")
        @field:NotNull(message = "Must fill value idProduct field")
        var idProduct: String,
        var quantity: Int
)
