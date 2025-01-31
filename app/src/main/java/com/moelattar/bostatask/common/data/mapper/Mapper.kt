package com.moelattar.bostatask.common.data.mapper

abstract class Mapper<Dto, Domain> {

    /**
     * Mapping Dto to Domain
     *
     * @param model is the dto class.
     * @return Domain class of the Dto Feature.
     */
    abstract fun dtoToDomain(model: Dto): Domain

//    abstract fun dtoListToDomain(model: List<Dto>?): List<Domain>

    /**
     * Mapping Domain to Dto
     *
     * @param model is the domain class.
     * @return Dto class of the Domain Feature.
     */
    open fun domainToDto(model: Domain): Dto =
        throw NotImplementedError("override and implement this method")

    /**
     * Mapping Dto list to Domain list
     *
     * @param list is the list of dto class.
     * @return Domain list of the Dto list feature.
     */
    fun dtoToDomain(list: List<Dto>?): List<Domain> = (list ?: emptyList()).map(::dtoToDomain)

    /**
     * Mapping Domain list to Dto list
     *
     * @param list is the list of domain class.
     * @return Dto list of the Domain list feature.
     */
    fun domainToDto(list: List<Domain>?): List<Dto> = (list ?: emptyList()).map(::domainToDto)

}