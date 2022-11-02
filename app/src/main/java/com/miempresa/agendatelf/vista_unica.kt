package com.miempresa.agendatelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton


import kotlinx.android.synthetic.main.activity_registro_contactos.*
import kotlinx.android.synthetic.main.activity_vista_unica.*
import kotlinx.android.synthetic.main.vista_contacto.*

class vista_unica : AppCompatActivity() {

    var edita: Boolean = false
    var id:Long = -1
    var cambionombre:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_unica)



        var recibidos:Bundle? = intent.extras
        if (recibidos != null){

            var contacto =recibidos?.get("contacto") as Contacto
            edita = true
            id = contacto.id!!
            txtNombre1.setText(contacto.nombre)
            txtCorreo1.setText(contacto.correo)
            txtTelefono1.setText(contacto.telefono)
            txtObs1.setText(contacto.observaciones)
        }


    }
}