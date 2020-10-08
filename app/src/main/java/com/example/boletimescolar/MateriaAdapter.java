package com.example.boletimescolar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class MateriaAdapter extends BaseAdapter {

    private Context context;
    private List<Materia> list;
    private StorageReference storageReference = FirebaseStorage.getInstance().getReference();

    public MateriaAdapter(Context context, List<Materia> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View v = View.inflate(context,R.layout.intem_lista_materia,null);
        TextView textNome = (TextView) v.findViewById(R.id.textViewNome);

        textNome.setText(list.get(i).getNome());
        return v;
    }
}
