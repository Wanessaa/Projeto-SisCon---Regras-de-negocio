package entidade;

import java.time.LocalDateTime;

public class Visitante {

    private String nome;
    private String sobrenome;
    private Unidade unidadeVisitada;
    private LocalDateTime horarioEntrada;

    public Visitante(String nome, String sobrenome, Unidade unidadeVisitada, LocalDateTime horarioEntrada) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.unidadeVisitada = unidadeVisitada;
        this.horarioEntrada = horarioEntrada;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Unidade getUnidadeVisitada() {
        return unidadeVisitada;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }
}