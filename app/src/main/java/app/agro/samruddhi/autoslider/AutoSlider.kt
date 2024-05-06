package app.agro.samruddhi.autoslider


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import app.agro.samruddhi.R
import app.samruddhi.smartagro.presentation.login.ImageSlider
import coil.compose.ImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ImageSlider(imageList: List<Int>, interval: Long = 2000) {
    var currentIndex by remember { mutableStateOf(0) }
    val animatableOffset = remember { Animatable(0F) }

    LaunchedEffect(key1 = currentIndex) {
        while (true) {
            val nextIndex = (currentIndex + 1) % imageList.size
            animatableOffset.animateTo(
                targetValue = 1F, animationSpec = tween(durationMillis = 1000)
            )
            animatableOffset.snapTo(0F)
            currentIndex = nextIndex
            delay(interval)
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Image(
                painter = painterResource(id = imageList[currentIndex]),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .offset {
                        IntOffset(
                            x = (animatableOffset.value * 100).toInt() - 100, // Adjust offset for right to left
                            y = 0
                        )
                    },
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
fun ImageSliderDemo() {
    val imageList = listOf(
        R.drawable.femfarmers,
        R.drawable.slider2,
        R.drawable.slider3
    )
    ImageSlider(imageList = imageList)
}

