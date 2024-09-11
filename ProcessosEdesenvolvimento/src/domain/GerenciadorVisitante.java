package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entidade.Unidade;
import entidade.Visitante;

public class GerenciadorVisitante {

	private List<Visitante> visitantes;

    public GerenciadorVisitante() {
        this.visitantes = new ArrayList<>();
    }

    // Registra o visitante se ele ainda não estiver registrado no mesmo horário
    public boolean registrarVisitante(String nome, String sobrenome, Unidade unidadeVisitada, LocalDateTime horarioEntrada) {
        // Verifica se o visitante já está registrado no mesmo horário
        for (Visitante visitante : visitantes) {
            if (visitante.getNome().equals(nome) && visitante.getSobrenome().equals(sobrenome) && 
                visitante.getHorarioEntrada().equals(horarioEntrada)) {
                return false; // Visitante já registrado no mesmo horário
            }
        }

        // Se não estiver registrado, adiciona o visitante à lista
        visitantes.add(new Visitante(nome, sobrenome, unidadeVisitada, horarioEntrada));
        return true; // Visitante registrado com sucesso
    }

    // Busca o visitante pelo nome e sobrenome
    public Visitante buscarVisitante(String nome, String sobrenome) {
        for (Visitante visitante : visitantes) {
            if (visitante.getNome().equals(nome) && visitante.getSobrenome().equals(sobrenome)) {
                return visitante;
            }
        }
        return null; // Visitante não encontrado
    }
}
