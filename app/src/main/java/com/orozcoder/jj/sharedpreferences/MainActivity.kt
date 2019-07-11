package com.orozcoder.jj.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = SharedPreferences(this)

        btnLeer.setOnClickListener{
            if(sp.leer() == null){
                etPreferencias.setText("No se encontró registro.")
            }
            else{
                etPreferencias.setText(sp.leer())
            }
        }

        btnEscribir.setOnClickListener{
            sp.escribir(etPreferencias.text.toString())
            etPreferencias.setText("")
        }

        btnBorrar.setOnClickListener{
            sp.borrar()
            etPreferencias.setText("")
        }


    }

}
