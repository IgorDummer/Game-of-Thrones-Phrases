package com.example.gameofthronesphrases

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.gameofthronesphrases.databinding.ActivityMainBinding

import android.content.SharedPreferences


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

        val savedUserName = sharedPreferences.getString("user_name", null)

        if (savedUserName != null) {
            val intent = Intent(this, Home::class.java)
            intent.putExtra("user_name", savedUserName)
            startActivity(intent)
            finish()
        } else {
            binding.botaoGuardar.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.botao_guardar) {
            val userName = binding.inputTextName.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("user_name", userName)
            editor.apply()

            val intent = Intent(this, Home::class.java)
            intent.putExtra("user_name", userName)
            startActivity(intent)
            finish()
        }
    }
}