package co.com.tul.ecommerce.model.output

data class ProductOutput(
        var idProduct: String,
        var typeProduct: String,
        var name: String,
        var sku: String,
        var description: String,
        var price: Double,
        var stock: Int,
        var status: String
)

