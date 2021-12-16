package co.com.tul.ecommerce.commons.util

import java.util.*

open class Util {

    open fun getUUID() : String = UUID.randomUUID().toString();
}