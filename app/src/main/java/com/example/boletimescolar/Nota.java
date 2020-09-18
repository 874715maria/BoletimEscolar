package com.example.boletimescolar;

public class Nota extends _Default{

    private int periodo;
    private int unidade;
    private double nota;

    public Nota(){
        super();
        this.nota = nota;
        this.periodo = periodo;
        this.unidade = unidade;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
