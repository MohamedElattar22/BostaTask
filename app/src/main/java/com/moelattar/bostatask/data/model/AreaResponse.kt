package com.moelattar.bostatask.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class AreaResponse(

    @field:SerializedName("data")
    val citiesList: List<CityDto?>? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null,
)