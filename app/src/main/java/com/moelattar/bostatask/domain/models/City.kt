package com.moelattar.bostatask.domain.models

data class City(
    val cityId: String,
    val cityName: String,
    val cityCode: String,
    val districts: List<District>,
    val dropOffAvailability: Boolean,
    val pickupAvailability: Boolean,
    val cityOtherName: String,

    )
