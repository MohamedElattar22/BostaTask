package com.moelattar.bostatask.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class DistrictsItemDto(


    @field:SerializedName("coverage")
    val coverage: String? = null,

    @field:SerializedName("districtId")
    val districtId: String? = null,

    @field:SerializedName("districtName")
    val districtName: String? = null,

    @field:SerializedName("zoneOtherName")
    val zoneOtherName: String? = null,

    @field:SerializedName("zoneId")
    val zoneId: String? = null,

    @field:SerializedName("dropOffAvailability")
    val dropOffAvailability: Boolean? = null,

    @field:SerializedName("zoneName")
    val zoneName: String? = null,

    @field:SerializedName("districtOtherName")
    val districtOtherName: String? = null,

    @field:SerializedName("pickupAvailability")
    val pickupAvailability: Boolean? = null,
)