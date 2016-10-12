package com.example.ignacio.lab03c2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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


        registerForContextMenu(listaEmpleos);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mimenuprincipal,menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx,menu);
        menu.setHeaderTitle("Acciones");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.idMenu1:
                Intent intent = new Intent(this,CrearOfertaActivity.class);
                startActivityForResult(intent,0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
