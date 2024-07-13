package cadastropoo.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson Rech
 */
public class PessoaJuridicaRepo {
    private final List<PessoaJuridica> listaPJ = new ArrayList<>();

    public void inserir(PessoaJuridica pj) {
        listaPJ.add(pj);
    }

    public void alterar(PessoaJuridica pj) {
        for (int i = 0; i < listaPJ.size(); i++) {
            if (pj.getId() == listaPJ.get(i).getId()) {
                listaPJ.set(i, pj);
                return;
            }
        }
    }

    public void excluir(int id){
        for (int i = 0; i < listaPJ.size(); i++){
            if (listaPJ.get(i).getId() == id){
                listaPJ.remove(i);
                return;
            }
        }
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pj : listaPJ) {
            if (pj.getId() == id) {
                return pj;
            }
        }
        return null;
    }

    public List<PessoaJuridica> obterTodos() {
        return listaPJ;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(listaPJ);
        } catch (IOException e){
            throw e;
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPJ.clear();
            List<PessoaJuridica> listaRecuperada = (List<PessoaJuridica>) inputStream.readObject();
            listaPJ.addAll(listaRecuperada);            
        } catch (IOException | ClassNotFoundException e){
            throw e;
        }
    }
}
