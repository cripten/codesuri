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

public class CrearEncuesta extends AppCompatActivity {
    //contendra los radiobutton
    RelativeLayout rlmain;//contendrá todo el contenido
    RadioButton[] arrRb = new RadioButton[6];
    EditText[] arrEt = new EditText[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_encuesta);

        rlmain = (RelativeLayout)findViewById(R.id.rlmain);


        ScrollView sv = new ScrollView(this);
        RelativeLayout rl = new RelativeLayout(this);
        rl.setId(99);

        sv.addView(rl,new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

        RadioGroup rg = new RadioGroup(this);
        rg.setId(100);

        RelativeLayout.LayoutParams p0 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        p0.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);


        for(int i = 1; i<6;i++){

            RadioButton rb = new RadioButton(this);
            arrRb[i] = rb;
            arrRb[i].setId(i);


            RelativeLayout.LayoutParams pRb = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            if(i>1){
                pRb.addRule(RelativeLayout.BELOW,arrRb[i-1].getId());
            }



           /* EditText et = new EditText(this);
            arrEt[i] = et;
            arrEt[i].setHint("Opcion"+i);
            arrEt[i].setId(i);

            RelativeLayout.LayoutParams pEt = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            pEt.addRule(RelativeLayout.RIGHT_OF,arrRb[i].getId());
            pEt.setMargins(0,-10,0,0);

            if(i>1){
                pEt.addRule(RelativeLayout.BELOW,arrRb[i-1].getId());
            }*/

            rg.addView(arrRb[i],pRb);

        }
        rl.addView(rg,p0);

        for(int i = 1; i<6;i++){

            EditText et = new EditText(this);
            arrEt[i] = et;
            arrEt[i].setHint("Opcion"+i);
            arrEt[i].setId(i);

            RelativeLayout.LayoutParams pEt = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            pEt.addRule(RelativeLayout.RIGHT_OF,arrRb[i].getId());
            pEt.setMargins(0,-10,0,0);

            if(i>1){
                pEt.addRule(RelativeLayout.BELOW,arrRb[i-1].getId());
            }

            rl.addView(arrEt[i],pEt);

        }


        rlmain.addView(sv);





    }


}
