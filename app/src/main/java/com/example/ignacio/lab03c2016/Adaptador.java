package com.example.ignacio.lab03c2016;

import android.content.Context;
import android.support.v7.widget.RecyclerView.*;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ignacio on 09/09/2016.
 */
public class Adaptador extends BaseAdapter {


    private Context mContext;
    private Trabajo[] mTrabajos;

    public Adaptador(Context context,Trabajo[] trabajos){
        mContext = context;
        mTrabajos = trabajos;
    }


    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public Trabajo[] getTrabajos() {
        return mTrabajos;
    }

    public void setTrabajos(Trabajo[] trabajos) {
        mTrabajos = trabajos;
    }

    @Override
    public int getCount() {
        return mTrabajos.length;
    }

    @Override
    public Object getItem(int position) {
        return mTrabajos[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.fila_oferta_lab,null);
            holder = new ViewHolder();
            holder.bandera = (ImageView) convertView.findViewById(R.id.banderaImageView);
            holder.profesion = (TextView) convertView.findViewById(R.id.profesionTextView);
            holder.actividad = (TextView) convertView.findViewById(R.id.actividadTextView);
            holder.fechaFin = (TextView) convertView.findViewById(R.id.fechaTextView);
            holder.sueldoMax = (TextView) convertView.findViewById(R.id.maxPagoTextView);
            holder.esIngles = (CheckBox) convertView.findViewById(R.id.enInglescheckBox);
            holder.horas = (TextView) convertView.findViewById(R.id.horasTextView);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        Trabajo trabajo = mTrabajos[position];

        switch (trabajo.getMonedaPago()){
            case 1:
                holder.bandera.setImageResource(R.drawable.us);
                break;
            case 2:
                holder.bandera.setImageResource(R.drawable.eu);
                break;
            case 3:
                holder.bandera.setImageResource(R.drawable.ar);
                break;
            case 4:
                holder.bandera.setImageResource(R.drawable.uk);
                break;
            case 5:
                holder.bandera.setImageResource(R.drawable.br);
                break;
        }
        holder.profesion.setText(trabajo.getCategoria().getDescripcion());
        holder.actividad.setText(trabajo.getDescripcion());
        holder.fechaFin.setText(DateFormat.format("yyyy-MM-dd",trabajo.getFechaEntrega()));
        holder.sueldoMax.setText(String.format("%.2f",trabajo.getPrecioMaximoHora()));
        holder.esIngles.setChecked(trabajo.getRequiereIngles());
        holder.horas.setText(trabajo.getHorasPresupuestadas()+"");


        return convertView;
    }


    public class ViewHolder {
        ImageView bandera;
        TextView fechaFin;
        TextView actividad;
        TextView profesion;
        TextView sueldoMax;
        TextView horas;
        CheckBox esIngles;
    }
}
