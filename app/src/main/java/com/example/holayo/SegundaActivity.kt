package com.example.holayo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button
class SegundaActivity : AppCompatActivity() {
    private var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("VIDA", "Segunda → onCreate")
        setContentView(R.layout.activity_segunda)
        val nombre = intent.getStringExtra("nombre") ?: "misterioso visitante"
        findViewById<TextView>(R.id.tvBienvenida).text =
            getString(R.string.saludo_segunda, nombre)
        val tvContador = findViewById<TextView>(R.id.tvContador)
        contador = savedInstanceState?.getInt("contador") ?: 0
        tvContador.text = contador.toString()
        findViewById<Button>(R.id.btnSumar).setOnClickListener {
            contador++
            tvContador.text = contador.toString()
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("contador", contador)
        super.onSaveInstanceState(outState)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("VIDA", "Segunda → onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("VIDA", "Segunda → onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("VIDA", "Segunda → onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("VIDA", "Segunda → onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("VIDA", "Segunda → onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("VIDA", "Segunda → onDestroy")
    }
}
