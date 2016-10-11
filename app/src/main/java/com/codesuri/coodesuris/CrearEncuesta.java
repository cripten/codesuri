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
    //contendra los radiobutton
    RelativeLayout rlmain;//contendrá todo el contenido
    LinearLayout FirstLL;
    LinearLayout ThirdLL;
    Button btnAddCamp;
    int i = 0;//sirve como contador para los id
    int cont = 1;
    RadioButton[] arrRb = new RadioButton[6];//almacena los contenidos de los radiobutton
    EditText[] arrEt = new EditText[6];//almacena los contenidos de los EditText
    int margintop = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_encuesta);

        //Sera el layout containt all
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

        //ScrollView
        ScrollView sv = new ScrollView(this);
        sv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

        //Button agregar campos
        btnAddCamp = new Button(this);
        btnAddCamp.setId(1);
        btnAddCamp.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        btnAddCamp.setText("Agregar Campo");
        btnAddCamp.setOnClickListener(this);

        // First layout
        FirstLL = new LinearLayout(this);
        FirstLL.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
        FirstLL.setOrientation(LinearLayout.VERTICAL);

        RelativeLayout.LayoutParams firstLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        firstLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        firstLayoutParams.addRule(RelativeLayout.BELOW,btnAddCamp.getId());
        firstLayoutParams.setMargins(0,20,0,0);

        //Second layout
        ThirdLL = new LinearLayout(this);
        FirstLL.setOrientation(LinearLayout.VERTICAL);

        RelativeLayout.LayoutParams thirdLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        thirdLayoutParams.addRule(RelativeLayout.ALIGN_BASELINE,FirstLL.getId());
        thirdLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        thirdLayoutParams.addRule(RelativeLayout.LEFT_OF,FirstLL.getId());
        thirdLayoutParams.setMargins(55,0,0,0);




        relativeLayout.addView(btnAddCamp);
        relativeLayout.addView(FirstLL,firstLayoutParams);
        relativeLayout.addView(ThirdLL,thirdLayoutParams);
        setContentView(relativeLayout);



    }


    @Override
    public void onClick(View v) {
       // switch(v.getId()){
            //case 1:
                cont = 0;
                //Radio group
                RadioGroup rg = new RadioGroup(this);
                rg.setId(1+i);
                rg.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));

                //RadioButton
                RadioButton rb = new RadioButton(this);
                rb.setId(1+i);
                RadioGroup.LayoutParams rbParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                rbParams.setMargins(0,margintop,0,0);
                rb.setLayoutParams(rbParams);
                rg.addView(rb);

                EditText et = new EditText(this);
                et.setId(1+i);
                et.setText("Opcion "+cont);
                LinearLayout.LayoutParams etParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
                etParams.setMargins(0,0,0,0);
                margintop = 0;

                ThirdLL.addView(et,etParams);
                FirstLL.addView(rg);
           // break;
      //  }
    }
}
