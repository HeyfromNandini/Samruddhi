package app.agro.samruddhi.gemini.ai.imageBot.components

import android.graphics.Bitmap
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import app.agro.samruddhi.BuildConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import project.environment.carby.gemini.ai.imageBot.components.ImageTextUiState
import project.environment.carby.gemini.ai.imageBot.components.utils.ModelConstants

class ImageAndTextVM : ViewModel() {

    var imageUiState = MutableStateFlow<ImageTextUiState>(ImageTextUiState.Ideal)
        private set

    val imageList by lazy { mutableStateListOf<Bitmap>() }

    private val generativeModel by lazy { GenerativeModel(
        modelName = ModelConstants.GEMINI_PRO_VISION,
        apiKey = BuildConfig.apikey
    ) }


    fun generateContentData(text: String) = viewModelScope.launch {
        if (imageList.isEmpty()) return@launch

        imageUiState.update { ImageTextUiState.Loading }

        val contentData = content {
            imageList.forEach { bitmap ->
                image(bitmap)
            }
            text(text)
        }

        generativeModel.generateContent(contentData).text?.let { data ->
            imageUiState.update { ImageTextUiState.Success(data) }
        } ?: run {
            imageUiState.update { ImageTextUiState.Error("Something Went Wrong.") }
        }
    }

}