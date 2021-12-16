/**
 *
 */
package co.com.tul.ecommerce.controller;

import co.com.tul.ecommerce.model.dto.ProductDTO
import co.com.tul.ecommerce.model.output.ProductOutput
import co.com.tul.ecommerce.service.impl.ProductServiceImpl;
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


/**
 * @author Yeison
 *
 */
@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
class ProductController(val productService: ProductServiceImpl) {

    @GetMapping("/list")
    @ApiOperation(value = "get all products")
    fun getProducts() : List<ProductOutput> = this.productService.getProducts();

    @PostMapping("/")
    @ApiOperation(value = "add new product")
    fun createProduct(@Valid @RequestBody productDTO: ProductDTO) : ResponseEntity<ProductOutput>
        = ResponseEntity<ProductOutput>(this.productService.createProduct(productDTO), HttpStatus.OK)

    @PutMapping("/{idProduct}")
    @ApiOperation(value = "update data of a product")
    fun updateProduct(@PathVariable("idProduct") idProduct : String, @Valid @RequestBody productDTO: ProductDTO) : ResponseEntity<ProductOutput>
        = ResponseEntity<ProductOutput>(this.productService.editProduct(idProduct, productDTO), HttpStatus.OK)

    @DeleteMapping("/{idProduct}")
    @ApiOperation(value = "delete some product")
    fun deleteProduct(@PathVariable("idProduct") idProduct: String) : ResponseEntity<String> {
        this.productService.deleteProduct(idProduct);
        return ResponseEntity<String>("Product $idProduct has been deleted",HttpStatus.OK)
    }
}