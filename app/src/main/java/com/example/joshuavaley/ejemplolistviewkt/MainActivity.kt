package com.example.joshuavaley.ejemplolistviewkt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciar ListView
        var lista = findViewById<ListView>(R.id.lista)
        //Instanciar ArrayList para llenar la lista.
        var frutas:ArrayList<Fruta> = ArrayList()
        //Dar valores al ArrayList.
        frutas.add(Fruta("Manzana", R.drawable.manzana))
        frutas.add(Fruta("Durazno", R.drawable.durazno))
        frutas.add(Fruta("Platano", R.drawable.platano))
        frutas.add(Fruta("Sandía" , R.drawable.sandia) )

        //Crear el adaptador simple.
        //var adaptador = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, frutas)

        //Crear adaptador Personalizado.
        var adaptador = AdaptadorCustom(this, frutas)

        //Enlazar el adaptador al ListView
        lista.adapter = adaptador

        //Agregar el Listener para el evento onClick

        lista.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, l ->

            Toast.makeText(this, frutas.get(position).nombre_fruta, Toast.LENGTH_SHORT).show()
        }
    }
}
