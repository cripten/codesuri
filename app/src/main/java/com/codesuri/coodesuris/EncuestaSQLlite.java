package com.codesuri.coodesuris;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by John on 30/10/2016.
 */
public class EncuestaSQLlite extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Encuestas.db";

    public static final String TABLA_NOMBRES = "nombres";
    public static final String COLUMNA_ID = "_id";
    public static final String COLUMNA_NOMBRE = "NOMBRE";

    public static final String SQL_CREAR = "create table "+TABLA_NOMBRES
            +"("+COLUMNA_ID+" integer primary key autoincrement,"
            +COLUMNA_NOMBRE+" text not null);";

    public EncuestaSQLlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(SQL_CREAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void agregar(String nombre){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COLUMNA_NOMBRE, nombre);

        db.insert(TABLA_NOMBRES, null,values);
        db.close();

    }

    public void obtener(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMNA_ID, COLUMNA_NOMBRE};

        Cursor cursor =
                db.query(TABLA_NOMBRES,
                        projection,
                        " _id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);


        if (cursor != null)
            cursor.moveToFirst();

        System.out.println("El nombre es " +  cursor.getString(1) );
        db.close();

    }
}
