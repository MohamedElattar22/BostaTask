package com.moelattar.bostatask.data.mappers

import com.moelattar.bostatask.common.data.mapper.Mapper
import com.moelattar.bostatask.data.model.DistrictsItemDto
import com.moelattar.bostatask.domain.models.District

object DistrictsMapper : Mapper<DistrictsItemDto, District>() {

    override fun dtoToDomain(model: DistrictsItemDto): District {
        return District(
            districtId = model.districtId ?: "",
            districtName = model.districtName ?: "",
            dropOffAvailability = model.dropOffAvailability ?: false,
            pickupAvailability = model.pickupAvailability ?: false,
            districtOtherName = model.districtOtherName ?: "",
            zoneId = model.zoneId ?: "",
            zoneName = model.zoneName ?: "",
            zoneOtherName = model.zoneOtherName ?: "",
            coverage = model.coverage ?: ""
        )
    }

}