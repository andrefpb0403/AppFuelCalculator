package com.example.appfuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtPrecoCombustivel = intent.getStringExtra("edtPrecoCombustivel")
        val btnProximo = findViewById<Button>(R.id.btn_proximo_2)
        val edtConsumo = findViewById<EditText>(R.id.edt_consumo)

        btnProximo.setOnClickListener {
            val edtConsumo = edtConsumo.text.toString()
            val intent = Intent(this, DistanciaActivity::class.java)
            intent.putExtra("edtPrecoCombustivel", edtPrecoCombustivel)
            intent.putExtra("edtConsumo", edtConsumo)
            startActivity(intent)
        }
    }
}