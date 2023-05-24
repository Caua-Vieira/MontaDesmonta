/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author cauas
 */
public class Usuario {
    private String nome;
    private String senha;
    private String cidade;
    private String estado;  
    private String endereco;
    
    public Usuario(){
        this.nome = nome;
        this.senha = senha;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return(this.nome);
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return(this.senha);
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
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getEndereco(){
        return(this.endereco);
    }
        
}
