package com.example.boletimescolar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Materia> materias;

    public MyAdapter(Context c, ArrayList<Materia> m){
        context = c;
        materias = m;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_lista,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nome.setText(materias.get(position).getNome());
        holder.unidade.setText(materias.get(position).getNome());
        holder.unidade.setText(materias.get(position).getNome());
        holder.unidade.setText(materias.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return materias.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome, unidade, periodo, nota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.list_nome);
            unidade = (TextView) itemView.findViewById(R.id.list_unidade);
            periodo = (TextView) itemView.findViewById(R.id.list_periodo);
            nota = (TextView) itemView.findViewById(R.id.list_nota);

        }
    }
}
