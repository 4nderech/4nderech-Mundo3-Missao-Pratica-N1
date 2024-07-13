package cadastropoo;

import cadastropoo.model.*;
        
/**
 *
 * @author Anderson Rech
 */
public class CadastroPOO {
    public static void main(String[] args) throws Exception {
        
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisica pf1 = new PessoaFisica(1, "Ana", "11111111111", 25);
        PessoaFisica pf2 = new PessoaFisica(2, "Carlos", "22222222222", 52);
        repo1.inserir(pf1);
        repo1.inserir(pf2);
        repo1.persistir("dados-pf");
        System.out.println("Dados de Pessoa Fisica Armazenados.");
        
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar("dados-pf");
        System.out.println("Dados de Pessoa Fisica Recuperados.");
        for (PessoaFisica pf : repo2.obterTodos()){
            pf.exibir();
        }
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo()        ;
        PessoaJuridica pj1 = new PessoaJuridica(3, "XPTO Sales", "333333333333");
        PessoaJuridica pj2 = new PessoaJuridica(4, "XPTO Solutions", "444444444444");
        repo3.inserir(pj1);
        repo3.inserir(pj2);
        repo3.persistir("dados-pj");
        System.out.println("Dados de Pessoa Juridica Armazenados.");
        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar("dados-pj");
        System.out.println("Dados de Pessoa Juridica Recuperados.");
        for (PessoaJuridica pj : repo4.obterTodos()){
            pj.exibir();
        }
    }
}
