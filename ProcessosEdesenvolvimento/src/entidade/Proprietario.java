package entidade;

import domain.Veiculo;

public class Proprietario {
    private String nome;
    private Veiculo veiculo;

    public Proprietario(String nome) {
        this.nome = nome;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (this.veiculo != null) {
            throw new RuntimeException("O proprietário já possui um veículo registrado.");
        }
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    
    
    public void removerVeiculo() {
        this.veiculo = null;
    }
}

