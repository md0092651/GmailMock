package com.coroutinelab.data.dto.emaildetails

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attachment(
    @SerialName("downloadUrl")
    val downloadUrl: String? = null,
    @SerialName("filename")
    val filename: String? = null,
    @SerialName("mimeType")
    val mimeType: String? = null,
    @SerialName("size")
    val size: Long? = null
)
