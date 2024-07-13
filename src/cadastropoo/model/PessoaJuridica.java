package cadastropoo.model;

import java.io.Serializable;

/**
 *
 * @author Anderson Rech
 */
public class PessoaJuridica extends Pessoa implements Serializable {
    private String cnpj;
    
    public PessoaJuridica(int id, String nome, String cnpj){
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    //Getters e Setters
    public String getCnpj(){
        return cnpj;
    }
    
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    
    @Override
    public void exibir(){
        super.exibir();
        System.out.println("CNPJ: " + this.cnpj);
    }
            
}
