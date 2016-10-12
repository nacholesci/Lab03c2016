package com.example.ignacio.lab03c2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class CrearOfertaActivity extends AppCompatActivity {

    private Spinner spinnerCategoria;
    private RadioGroup rdGroup;
    private Button btnGuardar;
    private EditText nombreEditText;
    private Trabajo trabajoNuevo;
    private Categoria categoria;
    private int moneda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_oferta);


        spinnerCategoria = (Spinner) findViewById(R.id.categoriaSpinner);
        rdGroup = (RadioGroup) findViewById(R.id.rdGroup);
        nombreEditText = (EditText) findViewById(R.id.nombreOfertaEditText);
        btnGuardar = (Button) findViewById(R.id.guardarButton);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoria = new Categoria((int) spinnerCategoria.getSelectedItemId(),spinnerCategoria.getSelectedItem().toString());
                trabajoNuevo = new Trabajo(Trabajo.TRABAJOS_MOCK.length+1,nombreEditText.getText().toString(),categoria);
                trabajoNuevo.setMonedaPago(moneda);
                Intent i = getIntent();
                // seteamos el resultado a enviar a la actividad principal.
                i.putExtra("resultado",trabajoNuevo);
                // invocamos al método de activity setResult
                setResult(RESULT_OK, i);
                // Finalizamos la Activity para volver a la anterior
                finish();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,buscaNombresCategorias());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapter);


        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.usRadioButton:
                        moneda=1;
                        break;
                    case R.id.euRadioButton:
                        moneda=2;
                        break;
                    case R.id.arRadioButton:
                        moneda=3;
                        break;
                    case R.id.libRadioButton:
                        moneda=4;
                        break;
                    case R.id.reRadioButton:
                        moneda=4;
                        break;
                    default:
                        moneda=0;
                }


            }
        });


    }

    private String[] buscaNombresCategorias(){
        String[] categorias = new String[Categoria.CATEGORIAS_MOCK.length];

        for(int i=0;i<Categoria.CATEGORIAS_MOCK.length;i++){
            categorias[i]=Categoria.CATEGORIAS_MOCK[i].getDescripcion();
        }
        return categorias;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("NOMBRE", nombreEditText.getText().toString());
        outState.putInt("MONEDA",moneda);
        outState.putSerializable("CATEGORIA",categoria);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        nombreEditText.setText(savedInstanceState.getString("NOMBRE"));
        moneda= savedInstanceState.getInt("MONEDA");
        categoria= (Categoria) savedInstanceState.getSerializable("CATEGORIA");
    }
}
