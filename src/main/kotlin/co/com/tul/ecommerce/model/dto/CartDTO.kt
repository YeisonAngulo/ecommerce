package co.com.tul.ecommerce.model.dto

import javax.validation.constraints.NotEmpty

data class CartDTO (
        var idCart: String,
        @field:NotEmpty(message = "Must fill some detail field")
        var cartDetail : List<CartDetailDTO>
)