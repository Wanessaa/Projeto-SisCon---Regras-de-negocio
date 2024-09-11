package domain;

import java.util.HashMap;
import java.util.Map;

import entidade.Condomino;

public class GerenciadorCondominos {
    private Map<String, Condomino> condominos; // Usa documento de identidade como chave

    public GerenciadorCondominos() {
        this.condominos = new HashMap<>();
    }

    public boolean adicionarCondomino(Condomino condomino) {
        if (condominos.containsKey(condomino.getDocumentoIdentidade())) {
            return false; // Condômino já cadastrado
        }
        condominos.put(condomino.getDocumentoIdentidade(), condomino);
        return true;
    }

    public boolean editarCondomino(String documentoIdentidade, String novoNome) {
        Condomino condomino = condominos.get(documentoIdentidade);
        if (condomino == null) {
            return false; // Condômino não encontrado
        }
        condomino.setNome(novoNome);
        return true;
    }

    public boolean removerCondomino(String documentoIdentidade) {
        if (condominos.containsKey(documentoIdentidade)) {
            condominos.remove(documentoIdentidade);
            return true;
        }
        return false; // Condômino não encontrado
    }

    public Condomino buscarCondomino(String documentoIdentidade) {
        return condominos.get(documentoIdentidade);
    }
}
