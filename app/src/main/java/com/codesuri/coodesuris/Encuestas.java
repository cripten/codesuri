package com.codesuri.coodesuris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Encuestas extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout content;//contendrá todo el contenido
    Button btnMain;//permite ir al menu principal
    RelativeLayout.LayoutParams llp;//almacena los parametros de los LinearLayout
    RelativeLayout.LayoutParams llp1;//almacena los parametros de los LinearLayout
    ArrayList<LinearLayout> titLL = new ArrayList<LinearLayout>();//Linearlayout para contener los titulos
    TextView tvques;
    ArrayList<String> preg = new ArrayList<String>();
    ArrayList<LinearLayout> quesLL = new ArrayList<LinearLayout>();
    ArrayList<LinearLayout> rgLL = new ArrayList<LinearLayout>();//Linearlayout para contener radio group
    ArrayList<RadioButton> rbques = new ArrayList<RadioButton>();
    int index = 1;//Sirve como identificador de las posiciones de los arreglos de titLL
    RadioGroup rg;
    int subindex = 1;//Sirve como identificador de las posiciones de los arreglos de rbques y etrbques
    int j = 2;//sirve como contador para los id de los valores de rbques y etrbques
    int margintop = 20;// aumenta el margin rbques

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuestas);

        //Sera el layout containt all
        content = (RelativeLayout)findViewById(R.id.content);

        //Permite volver al menu
        btnMain = (Button)findViewById(R.id.btnMain);
        btnMain.setOnClickListener(this);

        quesLL.add(0,new LinearLayout(this));
        rgLL.add(0,new LinearLayout(this));
        rbques.add(0,new RadioButton(this));

        //permite manejar los objetos de la base de datos para la tabla titulos
        Dencuesta objPreguntas = new Dencuesta(this);
        ArrayList<Epreguntas> ques = objPreguntas.getPreguntas(1);

        if(!ques.isEmpty()) {


            for (int i = 1; i <= ques.size(); i++) {

                //---------------------LinearLayout for Titulos----------------------------------
                llp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                if (i == 1) {
                    llp.addRule(RelativeLayout.BELOW, btnMain.getId());
                } else {
                    llp.addRule(RelativeLayout.BELOW, rgLL.get(i - 1).getId());
                }
                quesLL.add(i, new LinearLayout(this));
                quesLL.get(i).setId(index);
                content.addView(quesLL.get(i), llp);
                //---------------------------------------//---------------------------------------

                //---------------------LinearLayout for RadioGroup----------------------------------
                llp1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                llp1.addRule(RelativeLayout.BELOW, quesLL.get(i).getId());
                rgLL.add(i, new LinearLayout(this));
                rgLL.get(i).setId(index+1);
                content.addView(rgLL.get(i), llp1);
                //---------------------------------------//-----------------------------------------

                Epreguntas p = ques.get(i - 1);

                //Create button with titles of form
                TextView tv = new TextView(this);
                tv.setId(i + 1);
                tv.setText(p.getPreguntas());
                tv.setTextSize(20);
                tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                quesLL.get(i).addView(tv);

                //RadioGroup for RadioButton
                rg = new RadioGroup(this);
                rg.setId(i);
                rg.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                CrearRB(p);
                rgLL.get(i).addView(rg);

                index += 2;

            }


        }

    }

    //Method for add RadioButton with EditText
    public void CrearRB(Epreguntas p) {

            //RadioButton
            rbques.add(subindex,new RadioButton(this));
            rbques.get(subindex).setId(j);
            rbques.get(subindex).setText(p.getOpc1());

            rbques.add(subindex+1,new RadioButton(this));
            rbques.get(subindex+1).setId(j+1);
            rbques.get(subindex+1).setText(p.getOpc1());

            rbques.add(subindex+2,new RadioButton(this));
            rbques.get(subindex+2).setId(j+2);
            rbques.get(subindex+2).setText(p.getOpc1());

            rbques.add(subindex+3,new RadioButton(this));
            rbques.get(subindex+3).setId(j+3);
            rbques.get(subindex+3).setText(p.getOpc1());

            rg.addView(rbques.get(subindex));
            rg.addView(rbques.get(subindex+1));
            rg.addView(rbques.get(subindex+2));
            rg.addView(rbques.get(subindex+3));



            subindex += 4;
            j += 4;


        }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Encuestas.this,MainActivity.class);
        startActivity(intent);
    }
}
