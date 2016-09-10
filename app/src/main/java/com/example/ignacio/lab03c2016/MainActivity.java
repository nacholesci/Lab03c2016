package com.example.ignacio.lab03c2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView listaEmpleos;
    private BaseAdapter<Trabajo> listaTrabajosAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos las variables
        listaEmpleos = (ListView) findViewById(R.id.empleosListView);
        listaTrabajosAdaptador = new BaseAdapter<Trabajo> (this,android.R.layout.simple_list_item_single_choice);
        listaEmpleos.setAdapter(listaTrabajosAdaptador);
        listaTrabajosAdaptador.addAll(Arrays.asList(Trabajo.TRABAJOS_MOCK));
    }
}
