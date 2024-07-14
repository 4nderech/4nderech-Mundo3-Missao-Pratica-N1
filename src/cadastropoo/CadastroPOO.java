package cadastropoo;

import cadastropoo.model.*;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Anderson Rech
 */


// 1º PROCEDIMENTO: Criacao das Entidades e Sistema de Persistencia
/**
 * 
 * public class CadastroPOO {
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
 */

// 2º PROCEDIMENTO: Criacao do Cadastro em Modo Texto
public class CadastroPOO {
    public static void main(String[] args) {
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
            int opcao;
            
            do {
                System.out.println("====================================");
                System.out.println("1. Incluir");
                System.out.println("2. Alterar");
                System.out.println("3. Excluir");
                System.out.println("4. Exibir pelo ID");
                System.out.println("5. Exibir todos");
                System.out.println("6. Salvar dados");
                System.out.println("7. Recuperar dados");
                System.out.println("0. Sair");
                System.out.println("====================================");
                System.out.print("Digite a opcao desejada: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao) {
                    case 1 -> incluir(scanner, repoFisica, repoJuridica);
                    case 2 -> alterar(scanner, repoFisica, repoJuridica);
                    case 3 -> excluir(scanner, repoFisica, repoJuridica);
                    case 4 -> exibirPorId(scanner, repoFisica, repoJuridica);
                    case 5 -> exibirTodos(scanner, repoFisica, repoJuridica);
                    case 6 -> salvarDados(scanner, repoFisica, repoJuridica);
                    case 7 -> recuperarDados(scanner, repoFisica, repoJuridica);
                    case 0 -> System.out.println("Encerrando o programa.");
                    default -> System.out.println("Opcao invalida. Tente novamente.");
                }
            } while (opcao != 0);
        }
    }

    private static void incluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Tipo (F para Fisica, J para Juridica): ");
        char tipo = scanner.next().charAt(0);
        scanner.nextLine(); 
        switch (Character.toUpperCase(tipo)) {
            case 'F' -> {
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();
                PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
                repoFisica.inserir(pf);
                System.out.println("Pessoa Fisica incluida com sucesso.");
            }
            case 'J' -> {
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CNPJ: ");
                String cnpj = scanner.nextLine();
                PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
                repoJuridica.inserir(pj);
                System.out.println("Pessoa Juridica incluida com sucesso.");
            }
            default -> System.out.println("Tipo invalido.");
        }
    }

    private static void alterar(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Tipo (F para Fisica, J para Juridica): ");
        char tipo = scanner.next().charAt(0);
        scanner.nextLine();
        switch (Character.toUpperCase(tipo)) {
            case 'F' -> {
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 
                PessoaFisica pf = repoFisica.obter(id);
                if (pf != null) {
                    System.out.println("Dados atuais: ");
                    pf.exibir();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Nova idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    PessoaFisica novaPf = new PessoaFisica(id, nome, cpf, idade);
                    repoFisica.alterar(novaPf);
                    System.out.println("Pessoa Fisica alterada com sucesso.");
                } else {
                    System.out.println("Pessoa Fisica nao encontrada.");
                }
            }
            case 'J' -> {
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 
                PessoaJuridica pj = repoJuridica.obter(id);
                if (pj != null) {
                    System.out.println("Dados atuais: ");
                    pj.exibir();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo CNPJ: ");
                    String cnpj = scanner.nextLine();
                    
                    PessoaJuridica novaPj = new PessoaJuridica(id, nome, cnpj);
                    repoJuridica.alterar(novaPj);
                    System.out.println("Pessoa Juridica alterada com sucesso.");
                } else {
                    System.out.println("Pessoa Juridica nao encontrada.");
                }
            }
            default -> System.out.println("Tipo invalido.");
        }
    }

    private static void excluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Tipo (F para Fisica, J para Juridica): ");
        char tipo = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        switch (Character.toUpperCase(tipo)) {
            case 'F' -> {
                repoFisica.excluir(id);
                System.out.println("Pessoa Fisica excluida com sucesso.");
            }
            case 'J' -> {
                repoJuridica.excluir(id);
                System.out.println("Pessoa Juridica excluida com sucesso.");
            }
            default -> System.out.println("Tipo invalido.");
        }
    }

    private static void exibirPorId(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Tipo (F para Fisica, J para Juridica): ");
        char tipo = scanner.next().charAt(0);
        scanner.nextLine(); 

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        switch (Character.toUpperCase(tipo)) {
            case 'F' -> {
                PessoaFisica pf = repoFisica.obter(id);
                if (pf != null) {
                    pf.exibir();
                } else {
                    System.out.println("Pessoa Fisica não encontrada.");
                }
            }
            case 'J' -> {
                PessoaJuridica pj = repoJuridica.obter(id);
                if (pj != null) {
                    pj.exibir();
                } else {
                    System.out.println("Pessoa Juridica não encontrada.");
                }
            }
            default -> System.out.println("Tipo invalido.");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Tipo (F para Fisica, J para Juridica): ");
        char tipo = scanner.next().charAt(0);
        scanner.nextLine();
        switch (Character.toUpperCase(tipo)) {
            case 'F' -> {
                for (PessoaFisica pf : repoFisica.obterTodos()) {
                    pf.exibir();
                }
            }
            case 'J' -> {
                for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                    pj.exibir();
                }
            }
            default -> System.out.println("Tipo invalido.");
        }
    }

    private static void salvarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Prefixo do arquivo: ");
        String prefixo = scanner.nextLine();

        try {
            repoFisica.persistir(prefixo + ".fisica.bin");
            repoJuridica.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private static void recuperarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Prefixo do arquivo: ");
        String prefixo = scanner.nextLine();

        try {
            repoFisica.recuperar(prefixo + ".fisica.bin");
            repoJuridica.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }
    }
}

