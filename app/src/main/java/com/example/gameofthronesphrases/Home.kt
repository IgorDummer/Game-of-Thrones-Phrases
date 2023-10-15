package com.example.gameofthronesphrases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gameofthronesphrases.databinding.ActivityHomeBinding

class Home : AppCompatActivity(), View.OnClickListener {
    private val johnSnowPhrases = listOf(
        "Frase 1 de John Snow",
        "Frase 2 de John Snow",
        "Frase 3 de John Snow",
    )
    private val tyrionLannisterPhrases = listOf(
        "Frase 1 de Tyrion Lannister",
        "Frase 2 de Tyrion Lannister",
        "Frase 3 de Tyrion Lannister",
    )
    private var iconSelected: String? = null
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("user_name")
        if (userName != null) {
            val helloMessage = "Olá, $userName"
            binding.userText.text = helloMessage
        }

        binding.botaoGerarFrase.setOnClickListener(this)
        binding.iconTyrion.setOnClickListener(this)
        binding.iconJohn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.botao_gerar_frase) {
            if(iconSelected === "John"){
                val random = (0 until johnSnowPhrases.size).random()
                val selectedPhrase = johnSnowPhrases[random]
                binding.phraseText.text = selectedPhrase
            } else if (iconSelected === "Tyrion"){
                val random = (0 until tyrionLannisterPhrases.size).random()
                val selectedPhrase = tyrionLannisterPhrases[random]
                binding.phraseText.text = selectedPhrase
            }
        }
        else if (v?.id == R.id.icon_john){
            iconSelected = "John"
            val random = (0 until johnSnowPhrases.size).random()
            val selectedPhrase = johnSnowPhrases[random]
            binding.phraseText.text = selectedPhrase
        }
        else if (v?.id == R.id.icon_tyrion){
            iconSelected = "Tyrion"
            val random = (0 until tyrionLannisterPhrases.size).random()
            val selectedPhrase = tyrionLannisterPhrases[random]
            binding.phraseText.text = selectedPhrase
        }
    }
}