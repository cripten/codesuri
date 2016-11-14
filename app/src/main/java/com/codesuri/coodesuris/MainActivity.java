package com.codesuri.coodesuris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout content;//contendrá todo el contenido
    Button Nueva_Encuesta;//permite ir a otra actividad para crear una encuesta
    TextView tvVoid;//permite mostrar que no hay encuestas si aun no se han creado
    RelativeLayout.LayoutParams llp;//almacena los parametros de los LinearLayout
    ArrayList<LinearLayout> titLL = new ArrayList<LinearLayout>();//Linearlayout para contener los titulos
    //Array list for storing all the inventoryItems
    private ArrayList<String> inventoryItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sera el layout containt all
        content = (RelativeLayout)findViewById(R.id.content);

        Nueva_Encuesta = (Button)findViewById(R.id.btnNE);
        Nueva_Encuesta.setOnClickListener(this);

        tvVoid = (TextView)findViewById(R.id.tvVoid);
        tvVoid.setVisibility(0);


        titLL.add(0,new LinearLayout(this));

        //permite manejar los objetos de la base de datos para la tabla titulos
         Dencuesta objTitulos = new Dencuesta(this);
         ArrayList<Etitulos> tit = objTitulos.getTitulos();

        if(!tit.isEmpty()){


            for(int i = 1;i <= tit.size();i++){

                //---------------------LinearLayout for Titulos----------------------------------
                llp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                if(i == 1){
                    llp.addRule(RelativeLayout.BELOW, Nueva_Encuesta.getId());
                }
                else{
                    llp.addRule(RelativeLayout.BELOW, titLL.get(i-1).getId());
                }
                titLL.add(i,new LinearLayout(this));
                titLL.get(i).setId(i);
                content.addView(titLL.get(i),llp);
                //---------------------------------------//------------------------------------

                Etitulos t = tit.get(i-1);

                //Create button with titles of form
                Button btn = new Button(this);
                btn.setId(i+1);
                btn.setText(t.getName());
                btn.setTextSize(20);
                btn.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
                titLL.get(i).addView(btn);

            }

        }else{
            tvVoid.setVisibility(1);
        }


    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.btnNE:
              Intent intent = new Intent(MainActivity.this,CrearEncuesta.class);
              startActivity(intent);
              break;
      }
    }


}
