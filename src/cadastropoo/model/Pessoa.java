package cadastropoo.model;

import java.io.Serializable;

/**
 *
 * @author Anderson Rech
 */
public class Pessoa implements Serializable {
    private int id;
    private String nome;
    
    public Pessoa(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    
    //Getters e Setters
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void exibir(){
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
    }
    
}
