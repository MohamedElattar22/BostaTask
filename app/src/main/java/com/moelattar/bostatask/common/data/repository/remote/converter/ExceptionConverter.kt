package com.moelattar.bostatask.common.data.repository.remote.converter

import com.moelattar.bostatask.R
import com.moelattar.bostatask.common.data.models.ResponseErrorBody
import com.moelattar.bostatask.common.data.models.exception.BostaTaskException
import com.moelattar.bostatask.common.extensions.getModelFromJSON
import okhttp3.ResponseBody
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ExceptionConverter : IExceptionConverter {
    override fun convertNetworkExceptions(throwable: Throwable): BostaTaskException {
        return when (throwable) {
            is SocketTimeoutException, is UnknownHostException, is IOException -> BostaTaskException.Network.Retrial(
                messageRes = R.string.encryption_error,
                message = "Retrial network error."
            )

            else -> BostaTaskException.Network.Unhandled(
                messageRes = R.string.unknown_network_error,
                message = "NetworkException Unhandled error."
            )
        }
    }

    override fun convertResponseExceptions(
        code: Int, errorBody: ResponseBody?,
    ): BostaTaskException {
        return when (code) {
            401 -> BostaTaskException.Client.Unauthorized

            in 400..499 -> handleClientException(code, errorBody)

            in 500..599 -> BostaTaskException.Server.InternalServerError(
                httpErrorCode = code,
                message = errorBody?.string()
            )

            else -> BostaTaskException.Client.Unhandled(
                httpErrorCode = code,
                message = errorBody?.string()
            )
        }
    }

    private fun handleClientException(code: Int, errorBody: ResponseBody?): BostaTaskException {
        return if (errorBody == null) {
            BostaTaskException.Client.Unhandled(
                httpErrorCode = code,
                message = "There is no error body for this code."
            )
        } else {
            try {
                handleValidationException(code, errorBody)
            } catch (e: Exception) {
                BostaTaskException.Client.Unhandled(
                    httpErrorCode = code,
                    message = e.message
                )
            }
        }
    }

    private fun handleValidationException(code: Int, errorBody: ResponseBody): BostaTaskException {
        val responseErrorBody =
            errorBody.string().trimIndent()
                .getModelFromJSON<ResponseErrorBody>(ResponseErrorBody::class.java)

        val errorsMap =
            responseErrorBody.errors.map { it.key to it.value.joinToString(", ") }.toMap()

        val message = responseErrorBody.message

        return when (code) {
            422 -> BostaTaskException.Client.ResponseValidation(
                errors = errorsMap,
                message = message
            )

            else -> BostaTaskException.Client.Unhandled(
                httpErrorCode = code,
                message = message
            )
        }
    }
}