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
import android.widget.RelativeLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

public class CrearEncuesta extends AppCompatActivity implements View.OnClickListener{
    LinearLayout llCampos;//permite contener los campos creados Verticalmente
    RadioGroup rg;
    Button btnOp;
    Button btnAddCampos;//permite crear campos
    Integer ContCamp = 0;//sirve para colocar un id diferente a los campos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_encuesta);

        llCampos = (LinearLayout)findViewById(R.id.llCampos);
        btnAddCampos = (Button)findViewById(R.id.btnAddCampo);
        //comienza el escucha
        btnAddCampos.setOnClickListener(this);

    }

   @Override
    public void onClick(View v) {
        switch(v.getId()){
            //crea los campos donde iran las preguntas del formulario
            case R.id.btnAddCampo:
                EditText Campo = new EditText(this);
                Campo.setId(ContCamp);
                Campo.setHint("Ingrese una pregunta:");
                Campo.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
                llCampos.addView(Campo);

                btnOp = new Button(this);
                btnOp.setText("Add");
                btnOp.setId(ContCamp);
                btnOp.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
                btnOp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CrearRB();
                    }
                });
                llCampos.addView(btnOp);



                rg = new RadioGroup(this);
                rg.setOrientation(LinearLayout.HORIZONTAL);
                rg.setId(ContCamp);
                rg.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
                llCampos.addView(rg);


                CrearRB();

                ContCamp++;

                ////////////////////////////////////////////////////////////////////////////////////////////


            break;

        }

    }

    public void CrearRB(){

        RadioButton rbOp = new RadioButton(this);
        rbOp.setId(ContCamp);
        rg.addView(rbOp);

        EditText etOp = new EditText(this);
        etOp.setHint("Opción");
        etOp.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));

        rg.addView(etOp);


    }
}
