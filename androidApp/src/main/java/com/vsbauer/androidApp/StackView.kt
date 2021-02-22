package com.vsbauer.androidApp

import com.arkivanov.mvikotlin.core.view.BaseMviView
import com.arkivanov.mvikotlin.core.view.MviView
import com.vsbauer.androidApp.StackView.Event
import com.vsbauer.shared.TaskItem

interface StackView : MviView<StackView.Model, Event> {
    data class Model(
        val items: List<TaskItem>
    )

    sealed class Event {
        data class ItemClicked(val id: String) : Event()
        data class ItemDoneClicked(val id: String) : Event()
        data class ItemDeleteClicked(val id: String) : Event()
    }
}