package com.miempresa.agendatelf

import com.orm.SugarRecord

class ContactoRepositorio {

    fun crear(nombre:String , correo: String , telefono:String, observaciones:String){
        var contacto = Contacto(nombre , correo , telefono ,observaciones )
        SugarRecord.save(contacto)
    }

    fun listar():List<Contacto>{
        var contactos = SugarRecord.listAll(Contacto::class.java)
        return contactos
    }

    fun borrar(id:Long){
        var contacto:Contacto = SugarRecord.findById(Contacto::class.java,id)
        SugarRecord.delete(contacto)
    }

    fun leer(id:Long):Contacto{
        var contacto:Contacto = SugarRecord.findById(Contacto::class.java,id)
        return contacto
    }

    fun actualizar(id:Long ,nombre: String , correo: String ,telefono: String ,observaciones: String){
        var contacto:Contacto = SugarRecord.findById(Contacto::class.java,id)
        contacto.nombre = nombre
        contacto.correo = correo
        contacto.telefono= telefono
        contacto.observaciones= observaciones
        SugarRecord.save(contacto)
    }

}