package com.coroutinelab.data.dto.emaillist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attachment(
    @SerialName("filename")
    val filename: String?,
    @SerialName("mimeType")
    val mimeType: String?,
    @SerialName("size")
    val size: Int?
)