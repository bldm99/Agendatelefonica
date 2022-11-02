package com.miempresa.agendatelf

import android.R.id
import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miempresa.agendatelf.Contacto
import kotlinx.android.synthetic.main.activity_registro_contactos.*
import kotlinx.android.synthetic.main.vista_contacto.*
import java.io.Serializable


class AdaptadorContactos(val ListaContactos:ArrayList<Contacto> ): RecyclerView.Adapter<AdaptadorContactos.ViewHolder>() {


    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

        val fImagen = itemView.findViewById<ImageView>(R.id.imgFoto)
        val fNombre = itemView.findViewById<TextView>(R.id.lblNombre)
        val fTelefono= itemView.findViewById<TextView>(R.id.lblTelefono)
        val fEliminar= itemView.findViewById<ImageButton>(R.id.btnEliminar)
        val fVer= itemView.findViewById<ImageButton>(R.id.btnVer)



    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.vista_contacto, parent, false);
        return ViewHolder(v);
    }



    override fun onBindViewHolder(holder: AdaptadorContactos.ViewHolder, position: Int) {
        //Log.d("ID:" , position.toString())
        var contact = this.ListaContactos.get(position)


        holder?.fNombre?.text=ListaContactos[position].nombre
        holder?.fTelefono?.text=ListaContactos[position].telefono

        //holder?.fImagen?.setImageBitmap(ListaContactos[position].imagen)



        holder.fEliminar.setOnClickListener(View.OnClickListener {
            val builder = AlertDialog.Builder(holder.itemView.context)
            builder.setMessage("¿Desea eliminar este contacto?")
                .setPositiveButton(
                    "SI"
                ) { dialogInterface, i ->
                    var contactrepo = ContactoRepositorio()  //creando objeto userrepo
                    contactrepo.borrar(contact.id!!)
                    var a = this.ListaContactos.removeAt(position)
                    var b = notifyItemRemoved(position)
                    var c =notifyItemRangeChanged(position , itemCount)
                }
                .setNegativeButton(
                    "NO"
                ) { dialogInterface, i -> }.show()
        })

        holder.fVer.setOnClickListener(View.OnClickListener {

            var contactrepo = ContactoRepositorio()  //creando objeto userrepo
            var contacto = contactrepo.leer(contact.id!!)

            var verContacto = Intent(holder.itemView.context,vista_unica::class.java)

            verContacto.putExtra("contacto" , contacto as Serializable)
            holder.itemView.context.startActivity(verContacto)

        })



        holder.itemView.setOnClickListener(){

            var contactrepo = ContactoRepositorio()  //creando objeto userrepo
            var contacto = contactrepo.leer(contact.id!!)

            var editarContacto = Intent(holder.itemView.context,RegistroContactos::class.java)


            editarContacto.putExtra("contacto" , contacto as Serializable)
            editarContacto.putExtra("a" , "Actualizar" )
            holder.itemView.context.startActivity(editarContacto)

        }




    }

    override fun getItemCount(): Int {
        return ListaContactos.size;
    }
}