package com.moelattar.bostatask.common.data.repository.remote.converter

import com.moelattar.bostatask.common.data.models.exception.BostaTaskException
import okhttp3.ResponseBody

interface IExceptionConverter {
    fun convertNetworkExceptions(throwable: Throwable): BostaTaskException
    fun convertResponseExceptions(code: Int, errorBody: ResponseBody?): BostaTaskException
}