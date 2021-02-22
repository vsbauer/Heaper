package com.vsbauer.shared

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.core.store.create
import com.vsbauer.shared.StackStore.Intent
import com.vsbauer.shared.StackStore.State

internal class StackStoreFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): StackStore =
        object : StackStore, Store<Intent, State, Nothing> by storeFactory.create(
            name = "StackStore",
            initialState = State(),
            reducer = ReducerImpl
        ) {
        }


    private object ReducerImpl : Reducer<State, Intent> {
        override fun State.reduce(result: Intent): State =
            when (result) {
                is Intent.AddTask -> copy(items = items + result.taskItem)
                is Intent.RemoveTask -> copy(items = items.filter { it.id != result.id })
                is Intent.ToggleDone -> copy(items = items.map {
                    if (it.id == result.id) {
                        TaskItem(it.id, TaskItem.Data(it.data.text, true))
                    }
                    it
                })
            }
    }
}