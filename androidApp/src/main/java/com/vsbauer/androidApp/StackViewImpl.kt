package com.vsbauer.androidApp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.arkivanov.mvikotlin.core.view.BaseMviView
import com.vsbauer.shared.TaskItem

class StackViewImpl() : BaseMviView<StackView.Model, StackView.Event>(), StackView {

    override fun render(model: StackView.Model) {
        super.render(model)

    }
}

@Composable
fun UserList(taskList: List<TaskItem>) {
    LazyColumnFor(items = taskList) { taskItem ->
        UserRow(taskItem = taskItem, onUserClick = {
        })
        Divider()
    }
}

@Composable
fun UserRow(taskItem: TaskItem, onUserClick: (TaskItem) -> Unit) {
    Row(modifier = Modifier.clickable(onClick = { onUserClick(taskItem) }).fillMaxWidth()) {

//            val imageModifier = Modifier.preferredSize(46.dp).clip(shape = CircleShape)
//            val image = imageResource(id = R.drawable.header)

//            Image(asset = image,modifier = imageModifier,contentScale = ContentScale.Crop)

        Column {
            Text(
                text = taskItem.data.text,
                modifier = Modifier.clickable { },
                color = Color(0xFF000000),
                fontSize = TextUnit(18),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )
//                ProvideEmphasis(EmphasisAmbient.current.medium) {
//                    Text(text = user.bio,style = MaterialTheme.typography.body2)
//                }

        }
    }
}