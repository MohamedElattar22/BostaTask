package com.moelattar.bostatask.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CityDto(

    @field:SerializedName("cityOtherName")
    val cityOtherName: String? = null,

    @field:SerializedName("cityName")
    val cityName: String? = null,

    @field:SerializedName("cityCode")
    val cityCode: String? = null,

    @field:SerializedName("districts")
    val districts: List<DistrictsItemDto?>? = null,

    @field:SerializedName("dropOffAvailability")
    val dropOffAvailability: Boolean? = null,

    @field:SerializedName("cityId")
    val cityId: String? = null,

    @field:SerializedName("pickupAvailability")
    val pickupAvailability: Boolean? = null,
)