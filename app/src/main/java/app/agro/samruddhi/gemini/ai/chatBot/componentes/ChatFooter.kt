package app.agro.samruddhi.gemini.ai.chatBot.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.agro.samruddhi.ui.theme.MainGreen
import app.agro.samruddhi.ui.theme.NeonYellow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatFooter(
    submitClick: (text: String) -> Unit
) {

    var inputText by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(NeonYellow)
            .padding(10.dp)
    ) {
        //Text Field
        TextField(
            value = inputText,
            onValueChange = {
                inputText = it
            },
            placeholder = {
                Text(text = "Enter Your Question")
            },
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .background(MainGreen)
        )

        //Button Icon
        IconButton(onClick = {
            submitClick(inputText)
            inputText = ""
        }) {
            Icon(
                Icons.Default.Send,
                contentDescription = "Send",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MainGreen)
                    .padding(8.dp),
                tint = Color.White
            )
        }
    }
    Spacer(modifier = Modifier.height(55.dp))


}

@Preview
@Composable
fun ChatFooterPreview() {
    ChatFooter{

    }
}