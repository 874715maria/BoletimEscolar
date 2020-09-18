package com.example.boletimescolar;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Aluno extends _Default {

    private int id;
    private String nome;
    private String idade;
    private String email;
    private String nomeEscola;



    public Aluno (){
        super();
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.nomeEscola = nomeEscola;
    }

    public ArrayList<Aluno> getLista(){
        DB db = new DB();
        ArrayList<Aluno> lista = new ArrayList<>();
        try {
            ResultSet resultSet = db.select("SELECT * FROM usuario");
            if (resultSet != null){
                while (resultSet.next()){
                    Aluno obj = new Aluno();
                    obj.setId(resultSet.getInt("id"));
                    obj.setNome(resultSet.getString("nome"));
                    obj.setIdade(resultSet.getString("idade"));
                    obj.setEmail(resultSet.getString("email"));
                    obj.setNomeEscola(resultSet.getString("nomeEscola"));
                    lista.add(obj);
                    obj = null;
                }
            }
        }catch (Exception ex){
            this.mensagem = ex.getMessage();
            this._status = false;
        }
        return lista;
    }

    public void salvar(){
        String comando = "";
        if (this.getId() == id){
            comando = String.format("INSERT INTO Aluno(nome, idade, email, nomeEscola);",
                    this.getNome(), this.getIdade(), this.getEmail(), this.getNome());
        }else {
            comando = String.format("UPDATE Aluno SET nome = nome, idade = idade, email = email, nomeEscola = nomeEscola WHERE id = id;",
                    this.getNome(), this.getIdade(), this.getEmail(), this.getNomeEscola(), this.getId());
        }
        DB db = new DB();
        db.execute(comando);
        this.mensagem = db.mensagem;
        this._status = db._status;
    }
    public void apagar(){
        String comando = String.format("DELETE FROM Aluno WHERE id = id);", this.getId());
        DB db = new DB();
        db.execute(comando);
        this.mensagem = db.mensagem;
        this._status = db._status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }
}
