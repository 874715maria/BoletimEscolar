package com.example.boletimescolar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BoletimEscolar ="boletimEscolar";

    private static final String Tabela_Aluno ="db_Aluno";

    private static final String Coluna_Id ="id";
    private static final String Coluna_Nome ="nome";
    private static final String Coluna_Idade ="idade";
    private static final String Coluno_Email ="email";
    private static final String Coluna_NomeEscola ="nomeEscola";


    public BancoDados(@Nullable Context context) {
        super(context, BoletimEscolar, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //String QUERY_COLUNA = "CREATE TABLE" + Tabela_Aluno + "("
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
