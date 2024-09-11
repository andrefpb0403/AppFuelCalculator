package com.example.appfuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

    class ResultadoActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_resultado)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
            val btnVoltarInicio = findViewById<Button>(R.id.btn_voltar_inicio)
            btnVoltarInicio.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            val edtPrecoCombustivel = intent.getStringExtra("edtPrecoCombustivel")
            val edtConsumo = intent.getStringExtra("edtConsumo")
            val edtDistancia = intent.getStringExtra("edtDistancia")

            findViewById<TextView>(R.id.tv_coleta_preco).text = edtPrecoCombustivel
            findViewById<TextView>(R.id.tv_coleta_consumo).text = edtConsumo
            findViewById<TextView>(R.id.tv_coleta_km).text = edtDistancia

            val resultado = (edtDistancia.toString().toDouble() / edtConsumo.toString().toDouble()) * edtPrecoCombustivel.toString().toDouble()

            findViewById<TextView>(R.id.edt_resultado_final).text = resultado.toString()

        }
    }