package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fornecedor {

	private String nome;
    private String empresa;
    private List<String> servicosOuProdutos;

    public Fornecedor(String nome, String empresa) {
        this.nome = nome;
        this.empresa = empresa;
        this.servicosOuProdutos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public List<String> getServicosOuProdutos() {
        return servicosOuProdutos;
    }

    public void adicionarServicoOuProduto(String servicoOuProduto) {
        servicosOuProdutos.add(servicoOuProduto);
    }
    @Override
    public String toString() {
        return "Fornecedor{" +
                "nome='" + nome + '\'' +
                ", empresa='" + empresa + '\'' +
                ", servicosOuProdutos=" + servicosOuProdutos +
                '}';
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nome, empresa);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return nome.equals(that.nome) && empresa.equals(that.empresa);
    }
}
