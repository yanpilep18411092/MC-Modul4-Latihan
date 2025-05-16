package com.example.projectserwin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projectserwin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //dapatkan intent yang memulai aktivitas ini
        val nama = intent.getStringExtra("EXTRA_MESSAGE1")
        val email = intent.getStringExtra("EXTRA_MESSAGE2")
        val phone = intent.getStringExtra("EXTRA_MESSAGE3")


        //capture layout dari TevtView dan setting string sebagai textnya
        binding.txtNama.text = "Nama : " + nama
        binding.txtEmail.text =  "Email :"+ email
        binding.txtPhone.text = "Phone : " + phone
    }
}