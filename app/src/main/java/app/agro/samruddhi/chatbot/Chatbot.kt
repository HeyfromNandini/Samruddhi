package app.agro.samruddhi.chatbot

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Chat
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


//chatui not used here
@Composable
fun ChatMessage(
    message: String,
    isSentByUser: Boolean,
    modifier: Modifier = Modifier
) {
    val icon = if (isSentByUser) {
        Icons.Filled.AccountCircle
    } else {
        Icons.Filled.Chat
    }

    Box(
        modifier = modifier.padding(horizontal = 5.dp, vertical = 8.dp),
        contentAlignment = if (isSentByUser) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (isSentByUser) Arrangement.Start else Arrangement.End
        ) {
            if (isSentByUser) {
                Icon(
                    imageVector = icon,
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp).padding(end = 4.dp)
                )
            }
            Box(
                modifier = Modifier.background(
                    color = if (isSentByUser) MaterialTheme.colors.primary else Color.LightGray,
                    shape = RoundedCornerShape(16.dp)
                )
            ) {
                Text(
                    text = message,
                    style = MaterialTheme.typography.body1,
                    color = if (isSentByUser) Color.White else Color.Black,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
            if (!isSentByUser) {
                Icon(
                    imageVector = icon,
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp).padding(start = 4.dp)
                )
            }
        }
    }
}


@Composable
fun ChatBotScreen(navHostController: NavHostController) {
    var message by remember { mutableStateOf("") }
    var chatHistory by remember { mutableStateOf(listOf("Hello! How can I assist you?")) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            chatHistory.forEachIndexed { index, chat ->
                ChatMessage(
                    message = chat,
                    isSentByUser = index % 2 == 0,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.weight(1f).padding(end = 8.dp).background(color = Color.LightGray)
            ) {
                if (message.isEmpty()) {
                    // Placeholder text with white color
                    Text(
                        text = "Type your message...",
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 16.dp, horizontal = 12.dp)
                    )
                }
                // Actual TextField
                TextField(
                    value = message,
                    onValueChange = { message = it },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent, textColor = Color.Black), // Set text color to white
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Send",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.clickable {
                        if (message.isNotBlank()) {
                            chatHistory = chatHistory.toMutableList().apply {
                                add(message)
                            }
                            message = ""
                        }
                    }
                )
            }
        }
    }
}
