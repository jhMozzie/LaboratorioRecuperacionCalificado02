package com.flores.joseph.usolayoutsv4

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.flores.joseph.usolayoutsv4.databinding.ActivityEjercicio1Binding

class Ejercicio1 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMostrar.setOnClickListener {
            binding.cardView.visibility = View.VISIBLE
            binding.imageView.visibility = View.VISIBLE
        }

        binding.btnOcultar.setOnClickListener {
            binding.cardView.visibility = View.INVISIBLE
            binding.imageView.visibility = View.GONE
        }

    }
}