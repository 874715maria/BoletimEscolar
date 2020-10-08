package com.example.boletimescolar;

public class Materia extends _Default{

    private String id;
    private String nome;

    public Materia(){
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){

    }

    @Override
    public String toString() {
        return nome;
    }
}
