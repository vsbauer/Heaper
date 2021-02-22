package com.vsbauer.androidApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.vsbauer.shared.Greeting
import com.vsbauer.shared.TaskItem

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = listOf<TaskItem>(TaskItem("asfkasjf", TaskItem.Data(isDone = false, text = "KEK")))
        setContent {
            UserList(taskList =list)
        }
    }
}
