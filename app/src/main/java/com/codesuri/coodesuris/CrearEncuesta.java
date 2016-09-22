package com.codesuri.coodesuris;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

public class CrearEncuesta extends AppCompatActivity implements View.OnClickListener{
    LinearLayout svCampos;//permite contener los campos creados
    Button btnAddCampos;//permite crear campos
    Integer ContCamp = 0;//sirve para colocar un id diferente a los campos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_encuesta);

        svCampos = (LinearLayout)findViewById(R.id.svCampos);
        btnAddCampos = (Button)findViewById(R.id.btnAddCampo);

        //comienza el escucha
        btnAddCampos.setOnClickListener(this);


           /* String cadena = extra.getString("Cadena");
            TextView valueTV = new TextView(this);
            valueTV.setText(cadena);
            valueTV.setId(5);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

            ((LinearLayout) linearLayout).addView(valueTV);*/


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            //crea los campos
            case R.id.btnAddCampo:
                EditText Campo = new EditText(this);
                Campo.setId(ContCamp);
                Campo.setHint("Ingrese una pregunta:");
                Campo.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
                svCampos.addView(Campo);
                ContCamp++;
            break;

        }
    }
}
