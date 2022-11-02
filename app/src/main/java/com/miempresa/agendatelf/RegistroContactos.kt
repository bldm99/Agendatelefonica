package com.miempresa.agendatelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton


import kotlinx.android.synthetic.main.activity_registro_contactos.*

class RegistroContactos : AppCompatActivity() {

    var edita: Boolean = false
    var id:Long = -1
    var cambionombre:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_contactos)


        btnGuardar.setOnClickListener(){
            var nombre= txtNombre.text.toString()
            var correo= txtCorreo.text.toString()
            var telefono= txtTelefono.text.toString()
            var observaciones= txtObs.text.toString()

            if(nombre.isEmpty() && correo.isEmpty() && telefono.isEmpty() && observaciones.isEmpty() ){
                Toast.makeText(this , "Se debe completar todos los campos" ,Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }


            //Actualizar usuario seleccionado
            if (edita){

                var contactorepo = ContactoRepositorio()
                contactorepo.actualizar(id , nombre , correo ,telefono, observaciones)

                //Crear nuevo Usuario
            }else{
                var contactorepo = ContactoRepositorio()
                contactorepo.crear(nombre , correo ,telefono, observaciones)
            }


            finish()

            //var datoGuardado = usuariorepo.listar().size
            //Toast.makeText(this , "Datos Guardados:\n"  + datoGuardado,Toast.LENGTH_LONG).show()

        }

        var recibidos:Bundle? = intent.extras

        if (recibidos != null){

            var contacto =recibidos?.get("contacto") as Contacto
            edita = true
            id = contacto.id!!
            txtNombre.setText(contacto.nombre)
            txtCorreo.setText(contacto.correo)
            txtTelefono.setText(contacto.telefono)
            txtObs.setText(contacto.observaciones)
        }

        val cambio:Bundle? = intent.extras
        if (cambio!= null){
            cambionombre = cambio.getString("a").toString()
            btnGuardar.setText(cambionombre)
        }









    }
}