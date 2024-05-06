package app.agro.samruddhi.gemini.ai.imageBot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.agro.samruddhi.ui.theme.NeonYellow

@Composable
fun ImageHeader() {
    Row (modifier = Modifier.fillMaxWidth()){
        Text(
            text = "AGRI-GPT",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(NeonYellow)
                .padding(10.dp)
        )
    }
}

@Preview
@Composable
fun ImageHeaderPreview() {
    ImageHeader()
}