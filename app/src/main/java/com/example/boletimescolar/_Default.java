package com.example.boletimescolar;

public class _Default {

    protected String mensagem;
    protected boolean _status;

    public _Default(){
        this._status = true;
        this.mensagem = "";
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean is_status() {
        return _status;
    }

    public void set_status(boolean _status) {
        this._status = _status;
    }
}
