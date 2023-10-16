package com.example.gameofthronesphrases.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gameofthronesphrases.R
import com.example.gameofthronesphrases.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var myPreferences: MyPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myPreferences = MyPreferences(this)

        if (myPreferences.hasUserName()) {
            val savedUserName = myPreferences.getUserName()
            val intent = Intent(this, HomeActivity::class.java)
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

            myPreferences.saveUserName(userName)

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("user_name", userName)
            startActivity(intent)
            finish()
        }
    }
}