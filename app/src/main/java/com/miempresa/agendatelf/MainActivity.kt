package com.miempresa.agendatelf

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registro_contactos.*
import kotlinx.android.synthetic.main.vista_contacto.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lista.addItemDecoration(DividerItemDecoration(this , DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this)

        var contactorepo = ContactoRepositorio()
        var listaContactos = contactorepo.listar()

        val adapter = AdaptadorContactos(listaContactos as ArrayList<Contacto>)
        lista.adapter = adapter


        btnAgregar.setOnClickListener(){
            val intent = Intent(this,RegistroContactos::class.java)

            startActivity(intent)
        }




    }



    override fun onRestart() {
        super.onRestart()
        var contactorepo = ContactoRepositorio()
        var listaContactos = contactorepo.listar()
        val adapter = AdaptadorContactos(listaContactos as ArrayList<Contacto>)
        lista.adapter = adapter
    }

}