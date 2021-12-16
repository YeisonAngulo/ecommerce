package co.com.tul.ecommerce.model.mapper

interface IMapper <I, O> {

    fun toEntity(domain: I) : O

}