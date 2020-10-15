package bo.edu.instecmqsc.registro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import bo.edu.instecmqsc.registro.utilidades.utilidades;

import androidx.annotation.Nullable;

public class ConexionSQLiteServer extends SQLiteOpenHelper {


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(utilidades.CREA_TABLA_USUARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
    }

    public ConexionSQLiteServer(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
}
