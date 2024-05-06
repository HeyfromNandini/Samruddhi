package app.agro.samruddhi.gemini.ai.chatBot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.agro.samruddhi.ui.theme.GreenLight
import app.agro.samruddhi.ui.theme.MainGreen
import app.agro.samruddhi.ui.theme.NeonYellow
import app.agro.samruddhi.gemini.ai.chatBot.componentes.ChatFooter
import app.agro.samruddhi.gemini.ai.chatBot.componentes.ChatHeader
import app.agro.samruddhi.gemini.ai.chatBot.componentes.ChatListComponent


@Composable
fun ChatBot(
    viewModel: ChatBotVM = viewModel(),
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MainGreen)
        ) {
            //Header
            ChatHeader()

            //Chat List
            Box(
                modifier = Modifier.weight(1f).padding(horizontal = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                if (viewModel.list.isNotEmpty()) {
                    ChatListComponent(
                        list = viewModel.list
                    )
                } else {
                    Text(text = "Your friendly agri-assistant bot, here to help with all your agricultural queries!", color = GreenLight)
                }


//                Card(
//                    modifier = Modifier
////                        .clickable { navController.navigate(Screens.ImageAndText.route) }
//                        .align(Alignment.BottomEnd)
//                        .padding(start = 287.dp, bottom = 12.dp)
//                        .size(50.dp)
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Image,
//                        contentDescription = "",
//                        tint = MainGreen,
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .background(color = NeonYellow)
//                    )
//                }

            }

            //Footer
            ChatFooter {
                if (it.isNotEmpty()) {
                    viewModel.sendMessage(it)
                }
            }
        }
    }
}