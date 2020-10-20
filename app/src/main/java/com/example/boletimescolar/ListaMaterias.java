package com.example.boletimescolar;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaMaterias extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Materia> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teste_recycle);

        recyclerView = (RecyclerView) findViewById(R.id.myRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Materia>();

        reference = FirebaseDatabase.getInstance().getReference().child("Materia");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Materia m = dataSnapshot.getValue(Materia.class);
                    list.add(m);
                }
                adapter = new MyAdapter(ListaMaterias.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ListaMaterias.this,"ops....Something is wrong",Toast.LENGTH_SHORT).show();
            }
        });

    }
}