package com.example.boletimescolar;

public class Nota extends _Default{

    private String id;
    private String periodo;
    private String unidade;
    private String nota;

    public Nota (){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }
    /*public void salvar(){
        String comando = "";
        if (this.getId() == id){
            comando = String.format("INSERT INTO Nota(periodo, unidade, nota);",
                    this.getPeriodo(), this.getUnidade(), this.getNota());
        }else {
            comando = String.format("UPDATE Nota SET periodo = periodo, unidade = unidade, nota = nota WHERE id = id;",
                    this.getPeriodo(), this.getUnidade(), this.getNota(), this.getId());
        }

    }
    public void apagar(){
        String comando = String.format("DELETE FROM Nota WHERE id = id);", this.getId());

    }*/

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
