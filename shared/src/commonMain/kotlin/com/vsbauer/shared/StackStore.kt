package com.vsbauer.shared

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.utils.JvmSerializable
import com.vsbauer.shared.StackStore.Intent
import com.vsbauer.shared.StackStore.State

interface StackStore : Store<Intent, State, Nothing> {

    sealed class Intent : JvmSerializable {
        data class AddTask(val taskItem: TaskItem) : Intent()
        data class RemoveTask(val id: String) : Intent()
        data class ToggleDone(val id: String) : Intent()
    }

    data class State(
        val items: List<TaskItem> = emptyList(),
    ) : JvmSerializable
}