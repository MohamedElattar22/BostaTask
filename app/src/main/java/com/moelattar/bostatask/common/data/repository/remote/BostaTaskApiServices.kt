package com.moelattar.bostatask.common.data.repository.remote

//interface BostaTaskApiServices {
//    @POST("{path}")
//    @JvmSuppressWildcards
//    suspend fun post(
//        @Path("path") pathUrl: String, @QueryMap queryParams: Map<String, Any>,
//        @HeaderMap headers: Map<String, Any>, @Body requestBody: Any,
//    ): ResponseBody
//
//    @GET("{path}")
//    @JvmSuppressWildcards
//    suspend fun get(
//        @Path("path") pathUrl: String, @QueryMap queryParams: Map<String, Any>,
//        @HeaderMap headers: Map<String, Any>,
//    ): ResponseBody
//
//    @PUT("{path}")
//    @JvmSuppressWildcards
//    suspend fun put(
//        @Path("path") pathUrl: String, @QueryMap queryParams: Map<String, Any>,
//        @HeaderMap headers: Map<String, Any>, @Body requestBody: Any,
//    ): ResponseBody
//
//    @DELETE("{path}")
//    @JvmSuppressWildcards
//    suspend fun delete(
//        @Path("path") pathUrl: String, @QueryMap queryParams: Map<String, Any>,
//        @HeaderMap headers: Map<String, Any>
//    ): ResponseBody
//
//    @Multipart
//    @POST("{path}")
//    @JvmSuppressWildcards
//    suspend fun postWithFile(
//        @Path("path") pathUrl: String,
//        @QueryMap queryParams: Map<String, Any>, @HeaderMap headers: Map<String, Any>,
//        @PartMap requestBody: HashMap<String, RequestBody>, @Part file: List<MultipartBody.Part>
//    ): ResponseBody
//}