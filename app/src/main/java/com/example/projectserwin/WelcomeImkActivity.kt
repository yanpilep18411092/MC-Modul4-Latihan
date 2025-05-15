package com.example.projectserwin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projectserwin.databinding.ActivityWelcomeImkBinding
import android.graphics.Color


class WelcomeImkActivity : AppCompatActivity() {
    private lateinit var layoutMain: ConstraintLayout
    private lateinit var binding:ActivityWelcomeImkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWelcomeImkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        layoutMain = findViewById(R.id.main)


        binding.btnMaroon.setOnClickListener {
            layoutMain.setBackgroundColor(Color.parseColor("#800000")) // Maroon
        }

        binding.btnDarkBlue.setOnClickListener {
            layoutMain.setBackgroundColor(Color.parseColor("#00008B")) // Dark Blue
        }

        binding.btnDarkGreen.setOnClickListener {
            layoutMain.setBackgroundColor(Color.parseColor("#006400")) // Dark Green
        }

        binding.btnReset.setOnClickListener {
            layoutMain.background = ContextCompat.getDrawable(this, R.drawable.imk_pic)
        }
    }
}