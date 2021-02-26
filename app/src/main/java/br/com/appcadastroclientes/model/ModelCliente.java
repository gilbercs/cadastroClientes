package br.com.appcadastroclientes.model;

import java.io.Serializable;

public class ModelCliente implements Serializable {
    //declaração de atributos da class cliente
    private Long cliCodigo;
    private String cliNome;
    private String cliCelular;
    private String cliEmail;
    private String cliEndereco;
    private String cliObservacao;
    //metodo construtor
    public ModelCliente() {
    }
    //get e set
    public Long getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(Long cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliEndereco() {
        return cliEndereco;
    }

    public void setCliEndereco(String cliEndereco) {
        this.cliEndereco = cliEndereco;
    }

    public String getCliObservacao() {
        return cliObservacao;
    }

    public void setCliObservacao(String cliObservacao) {
        this.cliObservacao = cliObservacao;
    }

    @Override
    public String toString() {
        return "ModelCliente{" +
                "cliCodigo=" + cliCodigo +
                ", cliNome='" + cliNome + '\'' +
                ", cliCelular='" + cliCelular + '\'' +
                ", cliEmail='" + cliEmail + '\'' +
                ", cliEndereco='" + cliEndereco + '\'' +
                ", cliObservacao='" + cliObservacao + '\'' +
                '}';
    }
}
