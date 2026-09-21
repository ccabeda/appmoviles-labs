package com.example.holayo
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
// Tu modelo de datos: una línea, y ya tiene igualdad, copia y representación.
data class Perfil(
    val nombre: String,
    val dato: String,
    val apodo: String?, // el ? declara: "puede no haber apodo" — y el compilador lo vigila
    val comidaFavorita: String?,
)
class MainActivity : AppCompatActivity() {
    private val perfil = Perfil(
        nombre = "Agustin Cabeda",
        dato = "Estoy cursando aplicaciones móviles",
        apodo = null, // probá también con un apodo real: "Rama"
        comidaFavorita = "la hamburguesa con queso",
    )
    private var saludoFormal = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("VIDA", "Main → onCreate")
        setContentView(R.layout.activity_main)
        val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
        val tvDato = findViewById<TextView>(R.id.tvDato)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        // Si hay apodo se usa; si es null, el nombre. El operador ?: es el "plan B".
        val comoLlamarme = perfil.apodo ?: perfil.nombre
        tvSaludo.text = getString(R.string.saludo_formal, comoLlamarme)
        tvDato.text = perfil.comidaFavorita?.let { comida ->
            getString(R.string.dato_con_comida, perfil.dato, comida)
        } ?: perfil.dato

        btnSaludar.setOnClickListener {
            saludoFormal = !saludoFormal
            tvSaludo.text = if (saludoFormal) {
                getString(R.string.saludo_formal, comoLlamarme)
            } else {
                getString(R.string.saludo_informal, comoLlamarme)
            }
        }
        val btnIrSegunda = findViewById<Button>(R.id.btnIrSegunda)
        btnIrSegunda.setOnClickListener {
            // Intent EXPLÍCITO: nombra al destino por su clase.
            val intent = Intent(this, SegundaActivity::class.java)
            // El equipaje: un dato que viaja con el mensaje.
            intent.putExtra("nombre", perfil.apodo ?: perfil.nombre)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnCompartir).setOnClickListener {
            val texto = getString(
                R.string.perfil_para_compartir,
                perfil.apodo ?: perfil.nombre,
                perfil.dato
            )

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, texto)
            }

            startActivity(Intent.createChooser(intent, getString(R.string.elegir_app)))
        }
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("VIDA", "Main → onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("VIDA", "Main → onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("VIDA", "Main → onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("VIDA", "Main → onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("VIDA", "Main → onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("VIDA", "Main → onDestroy")
    }
}