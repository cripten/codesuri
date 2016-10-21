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
import java.util.List;

public class CrearEncuesta extends AppCompatActivity implements View.OnClickListener{
    //contendra los radiobutton
    EditText etTitulo;
    LinearLayout llques;
    LinearLayout llrg;
    RelativeLayout rlmain;//contendrá todo el contenido
    RelativeLayout content;//contendrá todo el contenido
    Button btnAddCamp;
    int i = 0;//sirve como contador para los id
    int cont = 1;
    RadioButton[] arrRb = new RadioButton[6];//almacena los contenidos de los radiobutton
    EditText[] arrEt = new EditText[6];//almacena los contenidos de los EditText
    int margintop = 0;
    int j = 160;
    int margintopLL = 1;
    Button btnOp;
    RadioGroup rg;
    RelativeLayout relativeLayout;
    ArrayList<LinearLayout> quesLL = new ArrayList<LinearLayout>();
    ArrayList<LinearLayout> rgLL = new ArrayList<LinearLayout>();
    ArrayList<LinearLayout> etLL = new ArrayList<LinearLayout>();
    ArrayList<LinearLayout> btnLL = new ArrayList<LinearLayout>();
    int index = 0;
    ScrollView sv;
    LinearLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_encuesta);

        //Sera el layout containt all
        content = (RelativeLayout)findViewById(R.id.content);

        //ScrollView
        sv = (ScrollView)findViewById(R.id.sv);

        //EditText
        etTitulo = (EditText)findViewById(R.id.etTitulo);
        //Button agregar campos
        btnAddCamp =(Button)findViewById(R.id.btnAddCamp);
        btnAddCamp.setOnClickListener(this);

        // layout contendrá los campos
         llques = (LinearLayout)findViewById(R.id.llques);
         llrg = (LinearLayout)findViewById(R.id.llques);



        //Linear layout para ocupar la posicion cero de los arraylist
        /*quesLL.add(index,new LinearLayout(this));
        quesLL.get(index).setId(index);
        quesLL.get(index).setOrientation(LinearLayout.VERTICAL);

        RelativeLayout.LayoutParams quesp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        quesp.addRule(RelativeLayout.BELOW,btnAddCamp.getId());*/
        quesLL.add(index,new LinearLayout(this));
        rgLL.add(index,new LinearLayout(this));
        etLL.add(index,new LinearLayout(this));
        btnLL.add(index,new LinearLayout(this));


       //agrega los objetos a  sus correspondientes vistas

        //content.addView(quesLL.get(index));//,quesp);
        index++;


    }


    @Override
    public void onClick(View v) {

        //Question Layout
        if(index == 1){
            quesLL.add(index,llques);
            rgLL.add(index,llrg);
        }else{
            quesLL.add(index,new LinearLayout(this));
            quesLL.get(index).setId(index);
            quesLL.get(index).setOrientation(LinearLayout.VERTICAL);

            RelativeLayout.LayoutParams quesp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            quesp.addRule(RelativeLayout.BELOW,rgLL.get(index-1).getId());
            quesp.setMargins(0,90,0,0);

            //RadioGroup Layout
            rgLL.add(index,new LinearLayout(this));
            rgLL.get(index).setId(index);
            rgLL.get(index).setOrientation(LinearLayout.VERTICAL);

            RelativeLayout.LayoutParams rgp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            rgp.addRule(RelativeLayout.BELOW,quesLL.get(index).getId());
            rgp.setMargins(0,40,0,0);


            content.addView(quesLL.get(index),quesp);
            content.addView(rgLL.get(index),rgp);
        }

        //Edit text question
        EditText etQ = new EditText(this);
        etQ.setId(1+i);
        etQ.setHint("Escriba su Pregunta");
        LinearLayout.LayoutParams etQParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        quesLL.get(index).addView(etQ,etQParams);



        rgLL.get(index).addView(rg);

        //EditText
        EditText et = new EditText(this);
        et.setId(1+i);
        et.setHint("Opcion "+cont);
        LinearLayout.LayoutParams etParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        //etParams.setMargins(0,0,0,0);
        rgLL.get(index).addView(et,etParams);


        //EditText Layout
      /*  etLL.add(index,new LinearLayout(this));
        etLL.get(index).setId(index);
        etLL.get(index).setOrientation(LinearLayout.VERTICAL);

        RelativeLayout.LayoutParams etp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        etp.addRule(RelativeLayout.BELOW,quesLL.get(index).getId());
        etp.setMargins(55,j,0,0);

        // Button ADD  Layout
        btnLL.add(index,new LinearLayout(this));
        btnLL.get(index).setId(index);
        btnLL.get(index).setOrientation(LinearLayout.VERTICAL);

        RelativeLayout.LayoutParams btnp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        btnp.addRule(RelativeLayout.BELOW,quesLL.get(index).getId());
        btnp.setMargins(240,j,0,0);

        //Edit text question
        EditText etQ = new EditText(this);
        etQ.setId(1+i);
        etQ.setHint("Escriba su Pregunta");
        LinearLayout.LayoutParams etQParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        quesLL.get(index).addView(etQ,etQParams);


        //Radio group
        rg = new RadioGroup(this);
        rg.setId(1+i);
        rg.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
        CrearRB();
        rgLL.get(index).addView(rg);
        margintop = 25;

       // Button
        Button btnAdd = new Button(this);
        btnAdd.setId(1+i);
        btnAdd.setText("Add");
        btnAdd.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrearRB();
            }
        });
        btnLL.get(index).addView(btnAdd);
        //Agregar Objetos a las vistas
        //content.addView(etLL.get(index),etp);
        //content.addView(btnLL.get(index),btnp);
        index++;
        */




    }

    public void CrearRB(){

       for(int p=1;p<4;p++){

           //RadioButton
           RadioButton rb = new RadioButton(this);
           rb.setId(1+i);
           RadioGroup.LayoutParams rbParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
           rbParams.setMargins(0,margintop,0,0);
           rb.setLayoutParams(rbParams);
           rg.addView(rb);

           //EditText
           EditText et = new EditText(this);
           et.setId(1+i);
           et.setHint("Opcion "+cont);
           LinearLayout.LayoutParams etParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
           //etParams.setMargins(0,0,0,0);
           etLL.get(index).addView(et,etParams);

           margintop = 25;

       }
        margintop=0;
        j = 180;

       /* //RadioButton
        RadioButton rb = new RadioButton(this);
        rb.setId(1+i);
        RadioGroup.LayoutParams rbParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
       // rbParams.setMargins(0,margintop,0,0);
        rb.setLayoutParams(rbParams);
        rg.addView(rb);

        //EditText
        EditText et = new EditText(this);
        et.setId(1+i);
        et.setText("Opcion "+cont);
        LinearLayout.LayoutParams etParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        //etParams.setMargins(0,0,0,0);
        etLL.get(index).addView(et,etParams);

        margintop = 25;*/

    }


}
