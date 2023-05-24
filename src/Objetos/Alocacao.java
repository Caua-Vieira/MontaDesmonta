/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author cauas
 */
public class Alocacao {
    private String empresa;
    private String prestador;
    private String horas;
    private String tipo;
    private String descricao;

    public Alocacao(){
        this.empresa = empresa;
        this.prestador = prestador;
        this.horas = horas;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getEmpresa() {
        return(this.empresa);
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPrestador() {
        return(this.prestador);
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public String getHoras() {
        return(this.horas);
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getTipo() {
        return(this.tipo);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return(this.descricao);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
