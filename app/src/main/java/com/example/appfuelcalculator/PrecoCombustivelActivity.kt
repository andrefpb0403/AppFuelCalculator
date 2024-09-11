package com.example.appfuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PrecoCombustivelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco_combustivel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnProximo = findViewById<Button>(R.id.btn_proximo_1)
        val edtPrecoCombustivel = findViewById<EditText>(R.id.edt_preco_combustivel)
        btnProximo.setOnClickListener {
            val edtPrecoCombustivel = edtPrecoCombustivel.text.toString()
            val intent = Intent(this, ConsumoActivity::class.java)
            intent.putExtra("edtPrecoCombustivel", edtPrecoCombustivel)
            startActivity(intent)
        }

    }
}