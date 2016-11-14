package com.codesuri.coodesuris;

/**
 * Created by John on 04/11/2016.
 */

public class Epreguntas {
    //Create table and fields
    public static final String TABLE_NAME = "preguntas";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_PREGUNTA = "pregunta";
    public static final String FIELD_OPC1 = "opc1";
    public static final String FIELD_OPC2 = "opc2";
    public static final String FIELD_OPC3 = "opc3";
    public static final String FIELD_OPC4 = "opc4";
    public static final String FIELD_TITULO_ID = "titulo_id";
    public static final String CREATE_DB_TABLE = "create table "+ TABLE_NAME + "( "+
            FIELD_ID +" integer primary key autoincrement,"+
            FIELD_PREGUNTA +" text,"+
            FIELD_OPC1 +" text,"+
            FIELD_OPC2 +" text,"+
            FIELD_OPC3 +" text,"+
            FIELD_OPC4 +" text,"+
            FIELD_TITULO_ID +" integer no null,"+
            "foreign key("+ FIELD_TITULO_ID +") references "+
            Etitulos.TABLE_NAME +"("+ Etitulos.FIELD_ID +")"
            +" );";

    private int id;
    private String preguntas;
    private String opc1;
    private String opc2;
    private String opc3;
    private String opc4;

    //------------------//Constructor con y sin parametros//----------------------------
    public Epreguntas(String preguntas, String opc1, String opc2, String opc3, String opc4) {
        this.preguntas = preguntas;
        this.opc1 = opc1;
        this.opc2 = opc2;
        this.opc3 = opc3;
        this.opc4 = opc4;
    }

    public Epreguntas(){

    }
    //-----------------------------------------------------//--------------------------

    // CLICK DERECHO -> GENERATE -> SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public void setOpc1(String opc1) {
        this.opc1 = opc1;
    }

    public void setOpc2(String opc2) {
        this.opc2 = opc2;
    }

    public void setOpc3(String opc3) {
        this.opc3 = opc3;
    }

    public void setOpc4(String opc4) {
        this.opc4 = opc4;
    }

    // CLICK DERECHO -> GENERATE -> GETTER

    public int getId() {
        return id;
    }

    public String getPreguntas() {
        return preguntas;
    }

    public String getOpc1() {
        return opc1;
    }

    public String getOpc2() {
        return opc2;
    }

    public String getOpc3() {
        return opc3;
    }

    public String getOpc4() {
        return opc4;
    }
}
