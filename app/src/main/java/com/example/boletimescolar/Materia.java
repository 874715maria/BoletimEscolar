package com.example.boletimescolar;

public class Materia extends _Default{

    private int id;
    private String nome;

    public Materia (){
        super();
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void salvar(){
        String comando = "";
        if (this.getId() == id){
            comando = String.format("INSERT INTO Materia(nome);",
                    this.getNome());
        }else {
            comando = String.format("UPDATE Materia SET nome = nome, WHERE id = id;",
                    this.getNome(), this.getId());
        }
        DB db = new DB();
        db.execute(comando);
        this.mensagem = db.mensagem;
        this._status = db._status;
    }
    public void apagar(){
        String comando = String.format("DELETE FROM Materia WHERE id = id);", this.getId());
        DB db = new DB();
        db.execute(comando);
        this.mensagem = db.mensagem;
        this._status = db._status;
    }
}
