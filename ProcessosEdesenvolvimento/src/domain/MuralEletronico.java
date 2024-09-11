package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidade.Condomino;

public class MuralEletronico {

	 private List<String> mensagens;
	    private Map<Condomino, List<String>> confirmacoesLeitura;

	    public MuralEletronico() {
	        this.mensagens = new ArrayList<>();
	        this.confirmacoesLeitura = new HashMap<>();
	    }

	    // Método para adicionar uma nova mensagem ao mural
	    public void adicionarMensagem(String mensagem) {
	        mensagens.add(mensagem);
	    }

	    // Método para visualizar as mensagens do mural
	    public List<String> visualizarMensagens(Condomino condomino) {
	        return new ArrayList<>(mensagens); // Retorna uma cópia da lista de mensagens
	    }

	    // Método para confirmar a leitura de uma mensagem
	    public void confirmarLeitura(Condomino condomino, String mensagem) {
	        if (!mensagens.contains(mensagem)) {
	            throw new IllegalArgumentException("Mensagem não encontrada no mural.");
	        }

	        confirmacoesLeitura.putIfAbsent(condomino, new ArrayList<>());
	        confirmacoesLeitura.get(condomino).add(mensagem);
	    }

	    // Método para verificar se um condômino confirmou a leitura de uma mensagem
	    public boolean isLeituraConfirmada(Condomino condomino, String mensagem) {
	        List<String> mensagensLidas = confirmacoesLeitura.get(condomino);
	        return mensagensLidas != null && mensagensLidas.contains(mensagem);
	    }

	    // Método para listar as confirmações de leitura de um condômino
	    public List<String> getMensagensConfirmadas(Condomino condomino) {
	        return confirmacoesLeitura.getOrDefault(condomino, new ArrayList<>());
	    }
}
