package app.agro.samruddhi.presentation.apnabazaar.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.navigation.Screens
import app.agro.samruddhi.presentation.utils.LoadingAnimation
import app.samruddhi.smartagro.presentation.apnabazaar.ApnaBazaarViewModel
import kotlinx.coroutines.delay

@Composable
fun FarmerApnabazaar(
    navController: NavController,
    apnaBazaarViewModel: ApnaBazaarViewModel = hiltViewModel()
) {

    val isAnimationPlaying by rememberUpdatedState(newValue = apnaBazaarViewModel.isAnimationPlaying.value)
    LaunchedEffect(key1 = apnaBazaarViewModel.isAnimationPlaying) {
        apnaBazaarViewModel.isAnimationPlaying.value = true
        delay(3000)
        if (apnaBazaarViewModel.isAnimationPlaying.value)
            apnaBazaarViewModel.isAnimationPlaying.value = false
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (isAnimationPlaying)
                        Modifier.blur(10.dp)
                    else Modifier
                )
                .verticalScroll(rememberScrollState())
                .background(
                    MaterialTheme.colorScheme.onPrimary
                )
        ) {
            Row(modifier = Modifier.padding(start = 10.dp, top = 30.dp)) {
                Text(
                    text = stringResource(id = R.string.take_a_picture),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            }
            Row(modifier = Modifier.padding(start = 10.dp, top = 4.dp)) {
                Text(
                    text = stringResource(id = R.string.fit_the_crop_image_with_the_frame),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            )
            {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                        .clip(RoundedCornerShape(15.dp))
                ) {

                    Row() {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.surfaceTint,
                            modifier = Modifier
                                .padding(start = 15.dp, top = 6.dp)
                                .size(23.dp)
                        )

                        Text(
                            text = stringResource(id = R.string.search_here),
                            fontSize = 17.sp,
                            color = MaterialTheme.colorScheme.surfaceTint,
                            modifier = Modifier.padding(start = 3.dp, top = 5.dp, bottom = 8.dp)
                        )
                    }
                }
            }

            FarmerApnabazaarCard(
                image = R.drawable.wheat_preview,
                crop = stringResource(id = R.string.wheat),
                quantityNo = "20kg",
                priceAmount = "1000",
                navController = navController
            )
            FarmerApnabazaarCard(
                image = R.drawable.apple,
                crop = stringResource(id = R.string.apple),
                quantityNo = "20kg",
                priceAmount = "1000",
                navController = navController
            )
            FarmerApnabazaarCard(
                image = R.drawable.cottonimg,
                crop = stringResource(id = R.string.cotton),
                quantityNo = "20kg",
                priceAmount = "1000",
                navController = navController
            )
            FarmerApnabazaarCard(
                image = R.drawable.maizeimg,
                crop = stringResource(id = R.string.maize),
                quantityNo = "20kg",
                priceAmount = "1000",
                navController = navController
            )
        }
        if (isAnimationPlaying) {
            LoadingAnimation(apnaBazaarViewModel = apnaBazaarViewModel)
        }
    }
}


@Composable
fun FarmerApnabazaarCard(
    navController: NavController,
    image: Int,
    crop: String,
    quantityNo: String,
    priceAmount: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                navController.navigate(Screens.BuyerList.route)
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(10.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = crop,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.surfaceTint,
                    modifier = Modifier.padding(start = 15.dp, top = 3.dp, bottom = 4.dp)
                )

                Row {
                    Text(
                        text = stringResource(id = R.string.quantity),
                        fontSize = 17.sp,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier.padding(start = 15.dp, top = 2.dp, bottom = 2.dp)
                    )
                    Text(
                        text = quantityNo,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier.padding(start = 10.dp, top = 2.dp, bottom = 2.dp)
                    )
                }
                Row {
                    Text(
                        text = stringResource(id = R.string.price),
                        fontSize = 17.sp,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier.padding(start = 15.dp, top = 1.dp, bottom = 2.dp)
                    )
                    Text(
                        text = "Rs $priceAmount",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier.padding(start = 35.dp, top = 1.dp, bottom = 2.dp)
                    )

                }
            }
        }
    }
}