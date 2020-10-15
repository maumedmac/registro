package bo.edu.instecmqsc.registro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import bo.edu.instecmqsc.registro.entidad.Usuario;

public class Adaptador extends ArrayAdapter<Usuario> {

    public Adaptador(@NonNull Context context, ArrayList<Usuario> resource) {
        super(context, 0,resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Usuario usuario = getItem(position);

        View itemlista = convertView;
        if(itemlista==null){
            itemlista = LayoutInflater.from(getContext()).inflate(R.layout.item_lista,parent,false);
        }

        TextView id = (TextView)itemlista.findViewById(R.id.id_usuario);
        id.setText(usuario.getId().toString());
        TextView name = itemlista.findViewById(R.id.nombre_usuario);
        name.setText(usuario.getNombre().toString());
        TextView phone = itemlista.findViewById(R.id.telefono_usuario);
        phone.setText(usuario.getTelefono().toString());



        return itemlista;
    }
}
