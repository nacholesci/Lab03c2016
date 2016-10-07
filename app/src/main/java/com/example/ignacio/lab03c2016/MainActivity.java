package com.example.ignacio.lab03c2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView listaEmpleos;
    private Adaptador listaTrabajosAdaptador;
    private Trabajo mTrabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos las variables
        listaEmpleos = (ListView) findViewById(R.id.empleosListView);
        listaTrabajosAdaptador = new Adaptador (this,mTrabajo.TRABAJOS_MOCK);
        listaEmpleos.setAdapter(listaTrabajosAdaptador);

    }
}
