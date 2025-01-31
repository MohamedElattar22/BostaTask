package com.moelattar.bostatask.data.mappers

import com.moelattar.bostatask.common.data.mapper.Mapper
import com.moelattar.bostatask.data.model.CityDto
import com.moelattar.bostatask.domain.models.City

object CitiesMapper : Mapper<CityDto, City>() {
    override fun dtoToDomain(model: CityDto): City {
        return City(
            cityId = model.cityId ?: "",
            cityName = model.cityName ?: "",
            cityCode = model.cityCode ?: "",
            districts = model.districts!!.map {
                DistrictsMapper.dtoToDomain(it!!)
            },
            dropOffAvailability = model.dropOffAvailability ?: false,
            pickupAvailability = model.pickupAvailability ?: false,
            cityOtherName = model.cityOtherName ?: "false"

        )
    }

}