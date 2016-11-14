package com.codesuri.coodesuris;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by John on 04/11/2016.
 */

public class Dencuesta extends SQLiteOpenHelper {
    private static final String DB_NAME = "encuestas.sqlite";//permite definir el nombre de la base de datos
    private static final int DB_Version = 1 ;//permite controlar las versiones de la base de datos
    private SQLiteDatabase db;//it allow  make queries to  the database

    public Dencuesta(Context context) {
        super(context, DB_NAME, null, DB_Version);
        db = this.getWritableDatabase();// la primera ve si la db no esta creada, la crea sino la sobreescribe
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Etitulos.CREATE_DB_TABLE);
        db.execSQL(Epreguntas.CREATE_DB_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //---------------------------//insertar//-------------------------------
   // titulos
    public void insertarTitulos(String titulo){

        ContentValues valores = new ContentValues();
        valores.put(Etitulos.FIELD_NAME,titulo);
        db.insert(Etitulos.TABLE_NAME,null,valores);
    }

    // preguntas
    public void insertarPreguntas(Epreguntas preguntas){

        String columna[] = {Etitulos.FIELD_ID};
        Cursor c = db.query(Etitulos.TABLE_NAME,columna,null,null,null,null,null);
        c.moveToLast();

        ContentValues valores = new ContentValues();
        valores.put(Epreguntas.FIELD_PREGUNTA,preguntas.getPreguntas());
        valores.put(Epreguntas.FIELD_OPC1,preguntas.getOpc1());
        valores.put(Epreguntas.FIELD_OPC2,preguntas.getOpc1());
        valores.put(Epreguntas.FIELD_OPC3,preguntas.getOpc1());
        valores.put(Epreguntas.FIELD_OPC4,preguntas.getOpc1());
        valores.put(Epreguntas.FIELD_TITULO_ID,c.getInt(0));
        db.insert(Epreguntas.TABLE_NAME,null,valores);
    }
    //---------------------------//-------------------------------------------



    //---------------------------//Leer//-------------------------------
    // titulos
    public ArrayList<Etitulos> getTitulos(){
        ArrayList<Etitulos> titulos = new ArrayList<>();

        String columnas[] = {Etitulos.FIELD_ID,Etitulos.FIELD_NAME};

        Cursor c = db.query(Etitulos.TABLE_NAME,columnas,null,null,null,null,null);
        if(c.moveToFirst()){
            do{
                Etitulos t = new Etitulos();
                t.setId(c.getInt(0));
                t.setName(c.getString(1));
                titulos.add(t);
            }while(c.moveToNext());

        }
        return titulos;
    }
    // preguntas
    public ArrayList<Epreguntas> getPreguntas(int id){
        ArrayList<Epreguntas> preguntas = new ArrayList<Epreguntas>();

        String columnas[] = {Epreguntas.FIELD_ID,Epreguntas.FIELD_PREGUNTA,Epreguntas.FIELD_OPC1,
                             Epreguntas.FIELD_OPC2,Epreguntas.FIELD_OPC3,Epreguntas.FIELD_OPC4};

        Cursor c = db.query(Epreguntas.TABLE_NAME,columnas,"titulo_id = ?",new String[] {String.valueOf(id)},null,null,null);
        if(c.moveToFirst()){
            do{
                Epreguntas p = new Epreguntas();
                p.setId(c.getInt(0));
                p.setPreguntas(c.getString(1));
                p.setOpc1(c.getString(2));
                p.setOpc2(c.getString(2));
                p.setOpc3(c.getString(3));
                p.setOpc4(c.getString(4));
                preguntas.add(p);

            }while(c.moveToNext());
        }
        return preguntas;
    }
    //---------------------------//-------------------------------------------

    //---------------------------//Modificar//-------------------------------
    // titulos
    // preguntas
    //---------------------------//-------------------------------------------

    //---------------------------//Eliminar//-------------------------------
    // titulos
    // preguntas
    //---------------------------//-------------------------------------------

}
