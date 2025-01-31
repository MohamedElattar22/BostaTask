package com.moelattar.bostatask.domain.models

data class District(
    val districtId: String,
    val districtName: String,
    val zoneId: String,
    val zoneName: String,
    val zoneOtherName: String,
    val districtOtherName: String,
    val coverage: String,
    val dropOffAvailability: Boolean,
    val pickupAvailability: Boolean,
)
