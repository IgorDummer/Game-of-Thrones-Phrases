package com.example.gameofthronesphrases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.gameofthronesphrases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoGuardar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.botao_guardar) {
            startActivity(Intent(this, Home::class.java))
            finish()
        }
    }


}