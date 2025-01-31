package com.moelattar.bostatask.common.data.repository.remote.call_factory

import com.moelattar.bostatask.common.data.repository.remote.converter.IExceptionConverter
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class BostaTaskCallAdapter(
    private val exceptionConverter: IExceptionConverter,
) : CallAdapter<ResponseBody, Call<ResponseBody>> {

    override fun responseType(): Type {
        return ResponseBody::class.java
    }

    override fun adapt(call: Call<ResponseBody>): Call<ResponseBody> {
        return BostaTaskCall(call, exceptionConverter)
    }
}