package bo.edu.instecmqsc.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import bo.edu.instecmqsc.registro.entidad.Usuario;
import bo.edu.instecmqsc.registro.utilidades.utilidades;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText userId= findViewById(R.id.user_id);
        final EditText userName= findViewById(R.id.user_name);
        final EditText userPhone= findViewById(R.id.user_phone);
        Button button = findViewById(R.id.user_reg);
        Button button1 = findViewById(R.id.user_ver);
        final ListView listView = findViewById(R.id.lvp);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConexionSQLiteServer conexionSQLiteServer = new ConexionSQLiteServer(getBaseContext(),"bd_usuario",null,1);
                SQLiteDatabase db=conexionSQLiteServer.getWritableDatabase();
                String insert="INSERT INTO "+utilidades.TABLA_USUARIO+" ("+utilidades.CAMPO_ID+","+
                        utilidades.CAMPO_NOMBRE+","+utilidades.CAMPO_TELEFONO+") VALUES ("+userId.getText().toString()+
                        ",'"+userName.getText().toString()+"','"+userPhone.getText().toString()+"')";
                db.execSQL(insert);
                db.close();

               /* ConexionSQLiteServer conexionSQLiteServer = new ConexionSQLiteServer(getBaseContext(),"bd_usuario",null,1);
                SQLiteDatabase db=conexionSQLiteServer.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(utilidades.CAMPO_ID,userId.getText().toString());
                values.put(utilidades.CAMPO_NOMBRE,userName.getText().toString());
                values.put(utilidades.CAMPO_TELEFONO,userPhone.getText().toString());
                Long idRes=db.insert(utilidades.TABLA_USUARIO,utilidades.CAMPO_ID,values);
                Toast.makeText(getApplicationContext(),"Id:"+idRes,Toast.LENGTH_SHORT).show();
                db.close();*/
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ErrorRRRRRRR");
                ConexionSQLiteServer conexionSQLiteServer = new ConexionSQLiteServer(getBaseContext(),"bd_usuario",null,1);

                SQLiteDatabase db=conexionSQLiteServer.getReadableDatabase();
                System.out.println(db.isOpen());
                System.out.println(db.getVersion());
                ArrayList<String> listaI = new ArrayList<String>();
                ArrayList<Usuario> listaU= new ArrayList<Usuario>();
                listaU.add(new Usuario(0,"NOMBRE","TELEFONO"));
                Cursor cursor= db.rawQuery("SELECT * FROM "+utilidades.TABLA_USUARIO,null);
                while (cursor.moveToNext()){
                    Usuario usuario=new Usuario();
                    usuario.setId(cursor.getInt(0));
                    usuario.setNombre(cursor.getString(1));
                    usuario.setTelefono(cursor.getString(2));
                    listaU.add(usuario);
                }
                Adaptador arrayAdapter = new Adaptador(getBaseContext(),listaU);
                listView.setAdapter(arrayAdapter);
                db.close();

            }
        });

    }
}