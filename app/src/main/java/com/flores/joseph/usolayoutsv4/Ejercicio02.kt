package com.flores.joseph.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.flores.joseph.usolayoutsv4.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)
        obsserveComponents()


    }

    fun obsserveComponents(){
        binding.btnRegistrar.setOnClickListener {
            if(isEmptyInput()){
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                goEjercicio2Detail()
            }
        }
    }


    fun goEjercicio2Detail(){
        val nombreCliente = binding.edtNombres.text.toString()
        val producto = binding.edtProducto.text.toString()
        val numeroCelular = binding.edtCelular.text.toString()
        val direccion = binding.edtDireccion.text.toString()

        val intent = Intent(this, Ejercicio2Detail::class.java)
        intent.putExtra(FULL_NAME_KEY, nombreCliente)
        intent.putExtra(FULL_PRODUCT_KEY, producto)
        intent.putExtra(FULL_CLIENT_PHONE_NUMBER_KEY, numeroCelular)
        intent.putExtra(FULL_ADDRESS_KEY, direccion)

        startActivity(intent)
    }

    fun isEmptyInput():Boolean{
        return binding.edtNombres.text.isEmpty() ||
                binding.edtProducto.text.isEmpty() ||
                binding.edtCelular.text.isEmpty() ||
                binding.edtDireccion.text.isEmpty()
    }

}