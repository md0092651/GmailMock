package com.coroutinelab.data.remote.api

import com.coroutinelab.data.dto.emaildetails.EmailDetailsDto
import com.coroutinelab.data.dto.emaillist.EmailListDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("api/v1/email")
    suspend fun getEmailList(): Response<EmailListDto>

    @GET("api/v1/emaildetails")
    suspend fun getEmailDetail(): Response<EmailDetailsDto>
}
