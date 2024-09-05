package com.coroutinelab.data.dto.emaildetails


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class From(
    @SerialName("email")
    val email: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("profileImage")
    val profileImage: String?
)