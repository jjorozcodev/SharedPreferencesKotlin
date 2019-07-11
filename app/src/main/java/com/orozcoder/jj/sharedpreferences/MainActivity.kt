package com.orozcoder.jj.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = SharedPreferences(this)

        etPreferencias.hint = "No hay registro"

        btnLeer.setOnClickListener{
            if(sp.leer() == null){
                etPreferencias.setText("")
                Snackbar.make(
                    it, // Parent view
                    "¡Error 404! :p", // Message to show
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
            }
            else{
                etPreferencias.setText(sp.leer())
            }
        }

        btnEscribir.setOnClickListener{
            sp.escribir(etPreferencias.text.toString())
            etPreferencias.setText("")
            Snackbar.make(
                it, // Parent view
                "¡Preferencia almacenada!", // Message to show
                Snackbar.LENGTH_SHORT // How long to display the message.
            ).show()
        }

        btnBorrar.setOnClickListener{
            sp.borrar()
            etPreferencias.setText("")
            Snackbar.make(
                it, // Parent view
                "¡Preferencia eliminada!", // Message to show
                Snackbar.LENGTH_SHORT // How long to display the message.
            ).show()
        }


    }

}
