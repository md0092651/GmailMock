package com.coroutinelab.coreui.functional

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

fun String.getInitials(): String {
    return split(" ")
        .mapNotNull { it.firstOrNull()?.uppercaseChar() }
        .joinToString("")
}

fun String.toFormattedDate(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")

    val outputFormat = SimpleDateFormat("MMM dd", Locale.getDefault())

    return try {
        val date = inputFormat.parse(this)
        date?.let { outputFormat.format(it) } ?: ""
    } catch (e: Exception) {
        ""
    }
}
