package com.miempresa.agendatelf

import com.orm.dsl.Table
import java.io.Serializable

@Table
data class Contacto(

    var id:Long? = null,
    var nombre:String? = null,
    var correo:String? = null,
    var telefono:String? = null,
    var observaciones:String? = null): Serializable {
    constructor(nombre: String?, correo: String?, telefono: String? , observaciones: String?) : this(){
        this.nombre = nombre
        this.correo = correo
        this.telefono = telefono
        this.observaciones = observaciones

    }

}