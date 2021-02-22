package com.vsbauer.shared

import com.arkivanov.mvikotlin.core.utils.JvmSerializable

data class TaskItem(
    val id: String,
    val data: Data
) : JvmSerializable {

    data class Data(
        val text: String,
        val isDone: Boolean = false
    ) : JvmSerializable
}
