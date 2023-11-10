package com.example.mobileassignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.mobileassignment.databinding.ActivityMainBinding

class data : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val editText = findViewById<EditText>(R.id.name)
        val button = findViewById<Button>(R.id.btn)

        // Set a click listener for the button
        button.setOnClickListener {
            // Get the text from the EditText
            val text = editText.text.toString()

            // Create an Intent to start the signUp activity
            val intent = Intent(this, signUp::class.java)

            // Put the text as an extra in the intent
            intent.putExtra("text", text)

            // Start the signUp activity
            startActivity(intent)
        }

    }
}