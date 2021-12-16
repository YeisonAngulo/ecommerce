package co.com.tul.ecommerce.commons.exceptions

import org.springframework.http.HttpStatus

class ProductException
    (val statusCode: HttpStatus, val exception: String)
    : Exception()