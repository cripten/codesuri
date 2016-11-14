package com.codesuri.coodesuris;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrearEncuesta extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout content;//contendrá todo el contenido
    EditText etTitulo;// Va el titulo de la encuesta
    Button btnAddCamp;// Sirve para agregar nuevos campos
    RelativeLayout.LayoutParams llp;//almacena los parametros de los LinearLayout
    ArrayList<LinearLayout> quesLL = new ArrayList<LinearLayout>();//Linearlayout para contener preguntas
    ArrayList<LinearLayout> rgLL = new ArrayList<LinearLayout>();//Linearlayout para contener radio group
    ArrayList<LinearLayout> etLL = new ArrayList<LinearLayout>();//Linearlayout para contener edittext
    ArrayList<EditText> etques = new ArrayList<EditText>();
    ArrayList<RadioGroup> rgques = new ArrayList<RadioGroup>();
    int index = 1;//Sirve como identificador de las posiciones de los arreglos de quesLL,rgLL,etLL,etques y rgques
    int i = 1;//sirve como contador para los id de los valores de quesLL,rgLL,etLL,etques y rgques
    ArrayList<RadioButton> rbques = new  ArrayList<RadioButton>();//almacena los contenidos de los radiobutton
    ArrayList<EditText> etrbques = new ArrayList<EditText>();//almacena los contenidos de los EditText
    int subindex = 1;//Sirve como identificador de las posiciones de los arreglos de rbques y etrbques
    int j = 2;//sirve como contador para los id de los valores de rbques y etrbques
    int margintop = 20;// aumenta el margin rbques
    Button btnSaveCamp;

    String tit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_encuesta);

        //Sera el layout containt all
        content = (RelativeLayout)findViewById(R.id.content);

        //EditText
        etTitulo = (EditText)findViewById(R.id.etTitulo);

        //Button agregar campos
        btnAddCamp =(Button)findViewById(R.id.btnAddCamp);
        btnAddCamp.setOnClickListener(this);

        //Button save camps
        btnSaveCamp =(Button)findViewById(R.id.btnSaveCamp);

        quesLL.add(0,new LinearLayout(this));
        rgLL.add(0,new LinearLayout(this));
        etLL.add(0,new LinearLayout(this));
        etques.add(0,new EditText(this));
        rgques.add(0,new RadioGroup(this));
        rbques.add(0,new RadioButton(this));
        etrbques.add(0,new EditText(this));



        btnSaveCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tit = etTitulo.getText().toString();
                //estancia la clase Dpreguntas y envia el contexto
                Dencuesta helper = new Dencuesta(CrearEncuesta.this);
                helper.insertarTitulos(tit);

                String pregunta;
                String[] opc = new String[5];
                int cont = 1;

                for(int k= 1; k < etques.size();k++){
                    pregunta = etques.get(k).getText().toString();

                    for(int m = 1; m <=4; m++){
                        opc[m] = etrbques.get(cont).getText().toString();
                        cont++;

                    }

                    Epreguntas obj = new Epreguntas(pregunta,opc[1],opc[2],opc[3],opc[4]);
                    helper.insertarPreguntas(obj);
                }

                Intent intent = new Intent(CrearEncuesta.this,Encuestas.class);
                startActivity(intent);
            }
        });



    }


    @Override
    public void onClick(View v) {

        //---------------------LinearLayout for Questions----------------------------------
        RelativeLayout.LayoutParams llp1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        if(index == 1){
            llp1.addRule(RelativeLayout.BELOW, btnAddCamp.getId());
        }
        else{
            llp1.addRule(RelativeLayout.BELOW, rgLL.get(index-1).getId());
        }
        quesLL.add(index,new LinearLayout(this));
        quesLL.get(index).setId(i);
        content.addView(quesLL.get(index),llp1);

        //---------------------LinearLayout for RadioGroup----------------------------------
        Params();

        rgLL.add(index,new LinearLayout(this));
        rgLL.get(index).setId(i+1);
        rgLL.get(index).setOrientation(LinearLayout.VERTICAL);
        content.addView(rgLL.get(index),llp);

        //--------------------LinearLayout for Edittext---------------------------------------
        Params();
        llp.addRule(RelativeLayout.RIGHT_OF,rgLL.get(index).getId());
        etLL.add(index,new LinearLayout(this));
        etLL.get(index).setId(i+2);
        etLL.get(index).setOrientation(LinearLayout.VERTICAL);
        content.addView(etLL.get(index),llp);


        //EditText for Questions
        etques.add(index,new EditText(this));
        etques.get(index).setId(i+3);
        etques.get(index).setHint("Escriba su Pregunta:");
        etques.get(index).setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        quesLL.get(index).addView(etques.get(index));

       //RadioGroup for RadioButton
        rgques.add(index,new RadioGroup(this));
        rgques.get(index).setId(i+4);
        rgques.get(index).setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
        CrearRB();
        rgLL.get(index).addView(rgques.get(index));



        index++;
        i+= 5;

    }

   //Method for add Params to LinearLayout
    public void Params(){

        llp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        llp.addRule(RelativeLayout.BELOW, quesLL.get(index).getId());

    }
    //Method for add RadioButton with EditText
    public void CrearRB() {

        for (int p = 1; p <= 4; p++) {

            //RadioButton
            rbques.add(subindex,new RadioButton(this));
            rbques.get(subindex).setId(j);
            RadioGroup.LayoutParams rbParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rbParams.setMargins(0, margintop, 0, 0);
            rbques.get(subindex).setLayoutParams(rbParams);
            rgques.get(index).addView(rbques.get(subindex));

            //EditText
            etrbques.add(subindex,new EditText(this));
            etrbques.get(subindex).setId(j);
            etrbques.get(subindex).setHint("Opcion "+p);
            etrbques.get(subindex).setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
            etLL.get(index).addView(etrbques.get(subindex));

            margintop = 27;
            subindex++;
            j++;


        }
        margintop = 20;
    }


}
