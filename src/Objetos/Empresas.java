/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author cauas
 */
public class Empresas {
    private String nome;
    private String razao;
    private String cidade;
    private String CNPJ;
    private String endereco;
    
    public Empresas(){
        this.nome = nome;
        this.razao = razao;
        this.cidade = cidade;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
    }

    public String getNome() {
        return(this.nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazao() {
        return(this.razao);
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getCidade() {
        return(this.cidade);
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCNPJ() {
        return(this.CNPJ);
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return(this.endereco);
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}
