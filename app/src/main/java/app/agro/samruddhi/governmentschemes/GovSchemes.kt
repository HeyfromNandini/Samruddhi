package app.agro.samruddhi.governmentschemes

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.login.ui.Select


@Composable
fun GovSchemes(navController: NavController) {

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
                text = stringResource(id = R.string.Gov_Schemes),
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
                        text = "Seach Schemes",
                        color = Color.LightGray,

                        )
                },
                placeholder = { Text(text = "Recent Schemes", fontSize = 14.sp) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .size(60.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {

            FarmerScheme(text = "Especially for YOU!")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(top = 5.dp, bottom = 2.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            Text(text = "Schemes by Gov. of India", fontSize = 20.sp, fontWeight = FontWeight.Bold)


        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(5) { index ->
                CommunityCard(
                    text = "Pradhan Mantri Fasal Bima Yojana (PMFBY)",
                    img = R.drawable.scheme2
                )
                CommunityCard(
                    text = "20 Best Ways to Reuse Old Clothing With Helpful Tutorials",
                    img = R.drawable.scheme3
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(top = 3.dp, bottom = 2.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            Text(
                text = "Schemes by our Vibrant Agri Community",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )


        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(5) { index ->
                CommunityCard(text = "AGRIGro : One crop at a time", img = R.drawable.scheme1)
                CommunityCard(
                    text = "Krishi Vikas Prayojan Samaj Mandali",
                    img = R.drawable.govschemes
                )
            }
        }

        Spacer(modifier = Modifier.height(70.dp))
    }
}


@Composable
fun CommunityCard(text: String, img: Int) {

    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .width(180.dp)
            .height(220.dp),

        shape = RoundedCornerShape(30.dp),
//        elevation = 30.dp
    ) {
        Column(
            modifier = Modifier.clip(RoundedCornerShape(30.dp))
                .padding(bottom = 5.dp),


        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
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


@Composable
fun FarmerScheme(
    text: String,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick()
                },
            border = BorderStroke(1.dp, Color.Green),

            ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier
                        .align(
                            Alignment.CenterStart
                        )
                        .size(30.dp)
                )
                Text(
                    text = text,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 4.dp),
                    color = MaterialTheme.colorScheme.surfaceTint,
                    softWrap = true
                )

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.surfaceTint,
                    modifier = Modifier.align(
                        Alignment.CenterEnd
                    )
                )
            }
        }
    }
}