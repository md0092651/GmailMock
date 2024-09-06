package com.coroutinelab.core.functional

fun String?.orEmpty(): String = this ?: ""

fun Boolean?.orDefault(default:Boolean = false): Boolean = this ?: default

fun <T, R> List<T>?.mapOrDefault(defaultValue: List<R> = emptyList(), transform: (T) -> R): List<R> {
    return this?.map(transform) ?: defaultValue
}
