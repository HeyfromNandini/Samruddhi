package app.agro.samruddhi.gemini.ai.chatBot.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.agro.samruddhi.R
import app.agro.samruddhi.gemini.ai.chatBot.ChatData
import app.agro.samruddhi.gemini.ai.chatBot.ChatRoleEnum
import app.agro.samruddhi.ui.theme.GreenLight
import app.agro.samruddhi.ui.theme.MainGreen

@Composable
fun ChatListComponent(
    list: MutableList<ChatData>
) {
    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
    ) {
        items(list) {
            if (it.role == ChatRoleEnum.USER.role) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 10.dp)
                        .padding(start = 50.dp)
                ) {
                    Row( modifier = Modifier
                        .fillMaxSize()) {

                        Row(
                            modifier = Modifier.clip(RoundedCornerShape(16.dp))
                                .fillMaxWidth(0.8f)
                                .background(GreenLight)
                        ) {
                            UserChatMessage(message = it.message)
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Card(modifier = Modifier.size(35.dp), shape = CircleShape) {
                            Image(
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = "",
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }

                }
            } else {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 10.dp)
                        .padding(end = 10.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Row( modifier = Modifier
                        .fillMaxSize()) {
                        Card(modifier = Modifier.size(35.dp), shape = CircleShape) {
                            Image(
                                painter = painterResource(id = R.drawable.wheat_preview),
                                contentDescription = "",
                                contentScale = ContentScale.FillBounds
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .fillMaxWidth(0.8f)
                                .background(GreenLight)
                        ) {
                            ModelChatMessage(message = it.message)
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun UserChatMessage(
    message: String
) {

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = message,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .background(GreenLight)
                .padding(8.dp)
        )
        Icon(
            imageVector = Icons.Default.Person,
            tint = Color.White,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(start = 4.dp)
        )
    }
}

@Composable
fun ModelChatMessage(
    message: String
) {




        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            androidx.compose.material.Text(
                text = message,
                style = MaterialTheme.typography.body1,
                color = Color.White ,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )
        }



}