package com.example.joshuavaley.ejemplolistviewkt

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text

//Clase adaptador.
class AdaptadorCustom(var context:Context, items:ArrayList<Fruta>):BaseAdapter() {

    var items:ArrayList<Fruta>? = null

    init {
        this.items = items
    }
    //#5
    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var holder:ViewHolder? = null

        var view:View? = convertView


        //Si celda no tiene contenido.
        if (view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.template, null)//vista asociada.
            holder = ViewHolder(view)//vista inicializa elementos del archivo xml
            view.tag = holder
        }
        else
        {
            holder = view.tag as? ViewHolder
        }

        var item = getItem(position) as Fruta
        //asociar atributos de Fruta con elementos graficos.
        holder?.texto_fruta?.text = item.nombre_fruta
        holder?.img_fruta?.setImageResource(item.imagen_fruta)


        if(position % 2 == 0){
            holder?.celda?.setBackgroundColor(Color.GRAY)
        }

        return view!!
    }
    //#3
    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }
    //#2
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
//#1
    override fun getCount(): Int {
        return items?.count()!!
    }

//#4Clase que trae la vista template.xml
    private class ViewHolder(view:View){

        var img_fruta:ImageView? = null
        var texto_fruta:TextView? = null
        var celda:LinearLayout? = null

        init {
            img_fruta = view.findViewById(R.id.imgFruta)
            texto_fruta = view.findViewById(R.id.txtFrta)
            celda = view.findViewById(R.id.celda)
        }

    }
}