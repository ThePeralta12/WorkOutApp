package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val flStartButton : FrameLayout = findViewById(R.id.flStart)

        flStartButton.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "This is a test, Will start the exercise",
                Toast.LENGTH_SHORT
            ).show()
        }


    }
}