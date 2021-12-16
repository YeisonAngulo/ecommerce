package co.com.tul.ecommerce.model.mapper

interface IMapperOutput <I, O>{

    fun toDtoList(entities: MutableIterable<O>): List<I>

    fun toDto(entity: O): I
}