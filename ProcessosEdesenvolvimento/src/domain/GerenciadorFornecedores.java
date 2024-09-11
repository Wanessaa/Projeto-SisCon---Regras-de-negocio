package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entidade.Fornecedor;

public class GerenciadorFornecedores {
	
	private Set<Fornecedor> fornecedores;

    public GerenciadorFornecedores() {
        this.fornecedores = new HashSet<>();
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        if (!fornecedores.add(fornecedor)) {
            throw new IllegalArgumentException("Fornecedor já cadastrado: " + fornecedor);
        }
    }

    public List<Fornecedor> listarFornecedores() {
        return List.copyOf(fornecedores);
    }
}
