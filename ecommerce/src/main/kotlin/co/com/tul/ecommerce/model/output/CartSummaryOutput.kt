package co.com.tul.ecommerce.model.output

data class CartSummaryOutput(
        var cartId : String,
        var totalValueCart: Double,
        var idProduct: String,
        var name: String,
        var priceUnit: Double,
        var quantity: Int,
        var statusCart: String
)
