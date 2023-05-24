/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author cauas
 */
public class Colaboradores {
    private String nome;
    private String idade;
    private String endereco;
    private String cidade;
    private String estado;
    private String tipo;    //quais os tipos de móveis da especialidade do colaborador
    
    public Colaboradores(){
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.tipo = tipo;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return(this.nome);
    }
    
    public void setIdade(String idade){
        this.idade = idade;
    }
    public String getIdade(){
        return(this.idade);
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getEndereco(){
        return(this.endereco);
    }
    
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getCidade(){
        return(this.cidade);
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getEstado(){
        return(this.estado);
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return(this.tipo);
    }
}
