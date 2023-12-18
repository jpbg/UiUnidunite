package br.edu.ifbaiano.guanambi.edutech.uiuni.model;

public class Task {

    private String descricao;
    private boolean urgente;
    private boolean imporante;
    private Integer usuario;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isUrgente(boolean checked) {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public boolean isImporante(boolean checked) {
        return imporante;
    }

    public void setImporante(boolean imporante) {
        this.imporante = imporante;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
}
