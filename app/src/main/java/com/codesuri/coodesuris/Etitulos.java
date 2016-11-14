package com.codesuri.coodesuris;

/**
 * Created by John on 04/11/2016.
 */

public class Etitulos {

    //Create table and fields
    public static final String TABLE_NAME = "titulos";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_PREGUNTA_ID = "pregunta_id";
    public static final String CREATE_DB_TABLE = "create table "+ TABLE_NAME +"( "+
            FIELD_ID +" integer primary key autoincrement,"+
            FIELD_NAME +" text"
            +" );";

    private int id;
    private String name;

    //------------------//Constructor con y sin parametros//----------------------------
    public Etitulos(String name) {
        this.name = name;
    }

    public Etitulos(){

    }
    //-----------------------------------------------------//--------------------------

    // CLICK DERECHO -> GENERATE -> SETTER

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    // CLICK DERECHO -> GENERATE -> GETTER

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
