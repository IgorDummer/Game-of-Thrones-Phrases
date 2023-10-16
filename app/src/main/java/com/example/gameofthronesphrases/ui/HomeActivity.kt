package com.example.gameofthronesphrases.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthronesphrases.viewModel.HomeViewModel
import com.example.gameofthronesphrases.R
import com.example.gameofthronesphrases.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private var iconSelected: String? = null
    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeVM: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoGerarFrase.setOnClickListener(this)
        binding.iconTyrion.setOnClickListener(this)
        binding.iconJohn.setOnClickListener(this)

        homeVM = ViewModelProvider(this).get(HomeViewModel::class.java)
        setPhraseObserver()
        setUserNameObserver()

        val userName = intent.getStringExtra("user_name")
        if (userName != null) {
            /* Passando o texto atual para questão de localização */
            homeVM.setGreetingMessage(binding.userText.text.toString(), userName)
        }
    }

    private fun setPhraseObserver() {
        homeVM.getTextPhrase().observe(this, Observer { phrase ->
            binding.phraseText.text = phrase
        })
    }

    private fun setUserNameObserver() {
        homeVM.getGreetingMessage().observe(this, Observer { greeting ->
            binding.userText.text = greeting
        })
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.botao_gerar_frase) {
            if(iconSelected === "John"){
                homeVM.generateJohnSnowPhrase()
            } else if (iconSelected === "Tyrion"){
                homeVM.generateTyrionPhrase()
            }
        }
        else if (v?.id == R.id.icon_john){
            iconSelected = "John"
            homeVM.generateJohnSnowPhrase()
        }
        else if (v?.id == R.id.icon_tyrion){
            iconSelected = "Tyrion"
            homeVM.generateTyrionPhrase()
        }
    }
}