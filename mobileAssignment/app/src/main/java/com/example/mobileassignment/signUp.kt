package com.example.mobileassignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileassignment.databinding.ActivitySignUpBinding

class signUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textView = findViewById<TextView>(R.id.hello_name)

        // Get the text from the intent
        val text = intent.getStringExtra("text")

        // Set the text to the TextView
        textView.text = text

        var button: Button =findViewById(R.id.cal)
        button.setOnClickListener{
            var i = Intent(this,calc::class.java)
            startActivity(i)
        }
    }
}