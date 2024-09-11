package domain;

import java.util.HashSet;
import java.util.Set;

import entidade.Condomino;
import entidade.Proprietario;

public class ReceitaCondominio {

	private Set<Proprietario> proprietarios;
    private String receitaFinanceira;

    public ReceitaCondominio(String receitaFinanceira) {
        this.proprietarios = new HashSet<>();
        this.receitaFinanceira = receitaFinanceira;
    }

    public void adicionarProprietario(Proprietario proprietario) {
        this.proprietarios.add(proprietario);
    }

    public String acessarReceita(Proprietario proprietario) {
        if (proprietarios.contains(proprietario)) {
            return receitaFinanceira;
        } else {
            throw new SecurityException("Acesso negado: apenas proprietários podem acessar as informações financeiras.");
        }
    }
}
