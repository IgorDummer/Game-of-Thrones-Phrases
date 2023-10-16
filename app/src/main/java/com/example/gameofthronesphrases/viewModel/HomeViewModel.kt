package com.example.gameofthronesphrases.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private var textPhrase = MutableLiveData<String>()
    private val greetingMessage = MutableLiveData<String>()
    private val  tyrionLannisterPhrases = listOf(
        "Todos os anões serão bastardos, mas nem todos os bastardos precisam ser anões.",
        "A Morte é terrivelmente final, ao passo que a vida está cheia de possibilidades.",
        "A maioria dos homens mais depressa nega uma verdade dura do que a enfrenta.",
        "Tenho a manga rasgada e os calções úmidos por motivos inconfessáveis, mas nada foi ferido, além da minha dignidade.",
        "Talvez seja este o segredo. Não é o que fazemos, mas o motivo por que fazemos."
    )
    private val johnSnowPhrases = listOf(
        "Love is the death of duty",
        "They were born on the wrong side of the wall.",
        "I Am not beholden to my ancestors vows.",
        "I never wanted it.",
        "Not just the boys."
    )

    fun getTextPhrase(): LiveData<String> {
        return textPhrase
    }

    fun generateJohnSnowPhrase() {
        val random = (0 until johnSnowPhrases.size).random()
        textPhrase.value = johnSnowPhrases[random]
    }

    fun generateTyrionPhrase() {
        val random = (0 until tyrionLannisterPhrases.size).random()
        textPhrase.value = tyrionLannisterPhrases[random]
    }

    fun setGreetingMessage(helloMessage: String, userName: String){
        greetingMessage.value = "$helloMessage $userName"
    }

    fun getGreetingMessage() : LiveData<String> {
        return greetingMessage
    }
}