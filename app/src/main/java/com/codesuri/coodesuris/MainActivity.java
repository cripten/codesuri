package com.codesuri.coodesuris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button Nueva_Encuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nueva_Encuesta = (Button)findViewById(R.id.btnNE);
        Nueva_Encuesta.setOnClickListener(this);
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
