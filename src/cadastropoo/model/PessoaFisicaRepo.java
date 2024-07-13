package cadastropoo.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson Rech
 */
public class PessoaFisicaRepo {
    private final List<PessoaFisica> listaPF = new ArrayList<>();
    
    public void inserir(PessoaFisica pf) {
        listaPF.add(pf);
    }

    public void alterar(PessoaFisica pf) {
        for (int i = 0; i < listaPF.size(); i++) {
            if (pf.getId() == listaPF.get(i).getId()) {
                listaPF.set(i, pf);
                return;
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < listaPF.size(); i++){
            if (listaPF.get(i).getId() == id){
                listaPF.remove(i);
                return;
            }
        }
        
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pf : listaPF) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null;
    }

    public List<PessoaFisica> obterTodos() {
        return listaPF;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(listaPF);
        } catch (IOException e){
            throw e;
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPF.clear();
            List<PessoaFisica> listaRecuperada = (List<PessoaFisica>) inputStream.readObject();
            listaPF.addAll(listaRecuperada);
        } catch (IOException | ClassNotFoundException e){
            throw e;
        }
    }
}