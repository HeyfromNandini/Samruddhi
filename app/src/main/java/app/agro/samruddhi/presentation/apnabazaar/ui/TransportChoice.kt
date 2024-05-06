package app.agro.samruddhi.presentation.apnabazaar.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.login.ui.Select
import app.agro.samruddhi.presentation.utils.BookedAnimation

@Composable
fun TransportChoice(navController: NavController) {
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
                    text = stringResource(id = R.string.transportchoice),
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 30.dp),
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically // Align vertically to center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.transportation),
                    contentDescription = "",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(top = 20.dp)
                        .fillMaxSize(),

                    )
            }


            Row(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.delivery_location),
                    fontSize = 18.sp,
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.surfaceTint
                )

//            Icon(
//                imageVector = Icons.Outlined.KeyboardArrowDown,
//                contentDescription = "",
//                tint = MaterialTheme.colorScheme.surfaceTint,
//                modifier = Modifier
//                    .padding(start = 40.dp, top = 15.dp)
//                    .size(30.dp)
//            )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
            ) {
                var textState by remember { mutableStateOf(TextFieldValue()) }

                TextField(
                    value = textState,
                    onValueChange = {
                        textState = it
                    },
                    label = { Text("Enter delivery location") },
                    modifier = Modifier.padding(16.dp)
                )
            }


            Row(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                DeliveryLocation()
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "OR",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.surfaceTint
                )

            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                Button(
                    onClick = {},
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(text = "Self Transportation")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        isDealAccepted = true
                    },
                horizontalArrangement = Arrangement.Center
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.onPrimary
                        )
                        .then(
                            if (isDealAccepted) Modifier.blur(5.dp) else Modifier
                        )
                ) {
                    Select(text = stringResource(R.string.make_a_deal)) {

                    }
                }

            }
            if (isDealAccepted) {
                BookedAnimation(navController = navController)
            }


        }

        
        Spacer(modifier = Modifier.height(50.dp))

    }

}


@Composable
fun DeliveryLocation() {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 15.dp)) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {

            Text(
                text = "Plot No. 15, Sector 8,\n" +
                        "Gandhinagar, Gujarat,\n" +
                        "India",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surfaceTint,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 2.dp)
            )

            Text(
                text = "Approx Cost(total):" + "1200-1800 Rupees",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surfaceTint,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 2.dp)
            )

        }

    }
}