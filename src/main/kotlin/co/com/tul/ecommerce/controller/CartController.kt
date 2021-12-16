package co.com.tul.ecommerce.controller

import co.com.tul.ecommerce.model.dto.CartDTO
import co.com.tul.ecommerce.model.output.CartOutput
import co.com.tul.ecommerce.model.output.CartSummaryOutput
import co.com.tul.ecommerce.service.impl.CartServiceImpl
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
class CartController (val cartService: CartServiceImpl){

    @PostMapping("/")
    @ApiOperation(value = "create cart definition")
    fun createCart(@Valid @RequestBody cartDTO: CartDTO) : ResponseEntity<CartOutput>
            = ResponseEntity<CartOutput>(this.cartService.createCart(cartDTO), HttpStatus.OK)

    @GetMapping("/list")
    @ApiOperation(value = "get all cart details")
    fun getCarts() : List<CartSummaryOutput> = this.cartService.getCartsSummary();

    @PutMapping("/{idCart}")
    @ApiOperation(value = "completed one order cart")
    fun checkoutCart(@PathVariable("idCart") idCart : String) : ResponseEntity<String> {
        this.cartService.checkoutCart(idCart);
        return ResponseEntity<String>("Cart $idCart has been closed successfully",HttpStatus.OK)
    }

}