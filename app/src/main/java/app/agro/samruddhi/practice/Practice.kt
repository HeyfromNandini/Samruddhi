package app.agro.samruddhi.practice

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.navigation.Screens

@Composable
fun Practice(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(imageVector = Icons.Default.Person, contentDescription ="" , tint = Color.White, modifier = Modifier.size(30.dp))

            Icon(imageVector = Icons.Default.Person, contentDescription ="" , tint = Color.White, modifier = Modifier.size(30.dp))

            Icon(imageVector = Icons.Default.Person, contentDescription ="" , tint = Color.White, modifier = Modifier.size(30.dp))

            Icon(imageVector = Icons.Default.Person, contentDescription ="" , tint = Color.White, modifier = Modifier.size(30.dp))

            Icon(imageVector = Icons.Default.Person, contentDescription ="" , tint = Color.White, modifier = Modifier.size(30.dp))


        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(

            modifier = Modifier
                .fillMaxWidth()

                .height(100.dp)
                .background(color = Color.Yellow),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Card(modifier = Modifier.size(80.dp).clickable { navController.navigate(Screens.AGRIEdu.route) }, shape = CircleShape) {

                Image(painter = painterResource(id = R.drawable.apple), contentDescription ="" )
            }


        }
        Text(text = "Hii heloooooo")

    }

}