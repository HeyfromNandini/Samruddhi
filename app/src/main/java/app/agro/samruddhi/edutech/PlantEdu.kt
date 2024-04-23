package app.agro.samruddhi.edutech

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.rentalservices.RentalServicesListCard

@Composable
fun PlantEdu(navController: NavController) {


    Box(modifier = Modifier.fillMaxSize()) {
        var isDealAccepted by remember { mutableStateOf(false) }


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
                    text = "Mitti-ka-Man(Edu)",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 30.dp),
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            }



            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                EduCards(
                    image = R.drawable.pedu1,
                    text = "Hybrid selection",
//                navController = navController
                )
                EduCards(
                    image = R.drawable.pedu2,
                    text = "All about Pesticides",
//                navController = navController
                )
               EduCards(
                    image = R.drawable.pedu3,
                    text = "The right soil for yur crops",
//                navController = navController
                )
                EduCards(
                    image = R.drawable.pedu1,
                    text = "Hybrid selection",
//                navController = navController
                )
                EduCards(
                    image = R.drawable.pedu2,
                    text = "All about Pesticides",
//                navController = navController
                )
                EduCards(
                    image = R.drawable.pedu3,
                    text = "The right soil for yur crops",
//                navController = navController
                )



            }


        }
    }
}



@Composable
fun EduCards(image: Int, text: String, ) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(15.dp)),
//            .clickable {
//                navController.navigate(Screens.ConfirmBuyer.route)
//            }
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(10.dp),
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.width(80.dp), horizontalAlignment = Alignment.Start) {

                Column (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = text,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier,
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "available for 6 months",
                        fontSize = 11.sp,
                        lineHeight = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier,
                        textAlign = TextAlign.Start
                    )

                }
            }


        }
    }
}
