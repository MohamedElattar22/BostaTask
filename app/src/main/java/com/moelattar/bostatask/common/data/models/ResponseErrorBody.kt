package com.moelattar.bostatask.common.data.models

import com.google.gson.annotations.SerializedName

data class ResponseErrorBody(
    @SerializedName("message")
    val message: String,
    @SerializedName("errors")
    val errors: Map<String, List<String>>,
)