package app.agro.samruddhi.edutech


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.input.key.Key.Companion.Ro
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.login.ui.Select
import app.agro.samruddhi.presentation.navigation.Screens
import app.agro.samruddhi.ui.theme.PurpleGrey80
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun AgriEdu(navController: NavController) {

    var nameValue = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                MaterialTheme.colorScheme.onPrimary
            )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.AGRI_Edu),
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 30.dp),
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .clickable { },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = nameValue.value,
                colors = TextFieldDefaults.textFieldColors(Color.Black),
                onValueChange = {
                    nameValue.value = it
                },
                label = {
                    Text(
                        text = "Seach about?",
                        color = Color.LightGray,

                        )
                },
                placeholder = { Text(text = "Your Courses", fontSize = 14.sp) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .size(60.dp)
            )
        }


        Spacer(modifier = Modifier.height(15.dp))
        TextBig(text = "Choose a way to", color = Color.White)
        TextBig(text = "study information", color = Color.White)
        Spacer(modifier = Modifier.height(15.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp)
        ) {

            Row(modifier = Modifier.fillMaxWidth()) {

                AGRIEduCard(img = R.drawable.mitti, text = "Mitti-ka-Man  (edu)"){
                    navController.navigate(Screens.PlantEdu.route)
                }


                AGRIEduCard(img = R.drawable.mausam, text = "Mausam Charcha  (edu)")
            }

Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                AGRIEduCard(img = R.drawable.pashu, text = "Pashu-Palak  (edu)")


                AGRIEduCard(img = R.drawable.tipstech, text = "Tips & Techniques")

            }
        }
    }

}






@Composable
fun TextBig(text: String, color: Color) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text,
            fontSize = 30.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(
                    top = 2.dp
                )
                .padding(horizontal = 20.dp)
            , color = color
        )
    }
}


@Composable
fun AGRIEduCard(text: String, img: Int,  onClick: () -> Unit = {}) {

    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .width(135.dp)
            .height(180.dp) .clickable {
                onClick()
            },

        shape = RoundedCornerShape(30.dp),
//        elevation = 30.dp
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .padding(bottom = 5.dp),


            ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
            ) {

                Image(
                    painter = painterResource(id = img),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )

            }




            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp)
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Card(modifier = Modifier.fillMaxWidth(0.8f)) {
                    Text(
                        text = text,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        lineHeight = 13.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Card(modifier = Modifier) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "",
                        tint = Color.Red
                    )

                }
            }


            Spacer(modifier = Modifier.height(5.dp))

        }
    }
}
