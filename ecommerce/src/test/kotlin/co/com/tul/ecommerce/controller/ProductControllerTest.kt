package co.com.tul.ecommerce.controller

import co.com.tul.ecommerce.model.dto.ProductDTO
import co.com.tul.ecommerce.model.enums.StatusProduct
import co.com.tul.ecommerce.model.output.ProductOutput
import co.com.tul.ecommerce.service.impl.ProductServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.http.ResponseEntity


class ProductControllerTest {

    @InjectMocks
    lateinit var productController : ProductController

    @Mock
    lateinit var productServiceImpl: ProductServiceImpl

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    var productDTO : ProductDTO = ProductDTO("SIMPLE", "WOOD DOOR", "123", "WOOD DOOR TEST", 10000.0, 100, StatusProduct.ACTIVE)
    var productOutput: ProductOutput = ProductOutput("1321321-131-13-2133", "SIMPLE", "WOOD DOOR", "123", "WOOD DOOR BY YEISON", 10000.0, 100, StatusProduct.ACTIVE.status)

    @Test
    fun WhenSaveProduct_ThenReturnOK() {
        Mockito.`when`(productServiceImpl.createProduct(productDTO)).thenReturn(productOutput)
                var result : ResponseEntity<ProductOutput> = productController.createProduct(productDTO)
                Assertions.assertThat(result.body?.idProduct).isNotEmpty
    }

    @Test
    fun WhenUpdateProduct_ThenReturnOK() {
        Mockito.`when`(productServiceImpl.editProduct("1321321-131-13-2133", productDTO)).thenReturn(productOutput)
        var result : ResponseEntity<ProductOutput> = productController.updateProduct("1321321-131-13-2133", productDTO)
        Assertions.assertThat(result.body?.idProduct).isNotEmpty
    }

    @Test
    fun WhenDeleteProduct_ThenReturnOK() {
        var result : ResponseEntity<String> = productController.deleteProduct("1321321-131-13-2133")
        Assertions.assertThat(result.body).isNotEmpty
    }

    @Test
    fun WhenGetProducts_ThenReturnAllProducts() {
        Mockito.`when`(productServiceImpl.getProducts()).thenReturn(listOf(productOutput))
        var result : List<ProductOutput> = productController.getProducts()
        Assertions.assertThat(result).isNotEmpty
    }
}