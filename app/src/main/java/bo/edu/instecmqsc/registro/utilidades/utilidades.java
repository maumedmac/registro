package bo.edu.instecmqsc.registro.utilidades;

import android.content.Intent;

public class utilidades {
    //Constantes campos
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_TELEFONO="telefono";
    public static final String CREA_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_ID+" INTEGER,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_TELEFONO+" TEXT)";
}
