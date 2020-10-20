package com.example.boletimescolar;

public class Materia extends _Default {

    private String id;
    private String nome;
    private String unidade;
    private String periodo;
    private String nota;

    public Materia(String id, String nome, String unidade, String periodo, String nota) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.periodo = periodo;
        this.nota = nota;
    }

    public Materia() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nome;
    }
}