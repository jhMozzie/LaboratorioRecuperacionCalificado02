package com.flores.joseph.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompatExtras
import com.flores.joseph.usolayoutsv4.databinding.ActivityEjercicio2DetailBinding


class Ejercicio2Detail : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio2DetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio2DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listenerComponentUI()
        intent.extras?.let {
            showData(it)
        }


    }

    private fun listenerComponentUI() {
        binding.imgbtnLlamar.setOnClickListener {
            Call()
        }
        binding.imgbtnWtsp.setOnClickListener {
            WtspMessage()
        }
        binding.imgbtnMaps.setOnClickListener {
            GMaps()
        }
    }

    private fun GMaps() {
        val address = binding.tvDireccion.text.toString()
        val uri = Uri.parse("geo:0,0?q=${Uri.encode(address)}")
        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            setPackage("com.google.android.apps.maps")
        }
        intent.resolveActivity(packageManager)?.let {
            startActivity(intent)
        } ?: run {
            Toast.makeText(this, "Google Maps not installed.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun WtspMessage() {
        val phoneNumber = binding.tvNumeroCliente.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
        startActivity(intent)
    }

    private fun Call() {
        val number = binding.tvNumeroCliente.text.toString()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$number")
        startActivity(intent)
    }

    private fun showData(paramExtras: Bundle){
        val nombreCliente = paramExtras.getString(FULL_NAME_KEY)
        val producto = paramExtras.getString(FULL_PRODUCT_KEY)
        val numeroCliente = paramExtras.getString(FULL_CLIENT_PHONE_NUMBER_KEY)
        val direccion = paramExtras.getString(FULL_ADDRESS_KEY)

        binding.tvCliente.text = nombreCliente
        binding.tvProducto.text = producto
        binding.tvNumeroCliente.text = numeroCliente
        binding.tvDireccion.text = direccion
    }
}