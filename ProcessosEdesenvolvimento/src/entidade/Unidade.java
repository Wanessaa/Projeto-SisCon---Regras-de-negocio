package entidade;

import java.util.Objects;


public class Unidade {
	private String nome;
	private int numero;
	private TipoUnidade tipoUnidade;
	
	private Condomino condomino;

	public Unidade(String nome, int numero, TipoUnidade tipoUnidade, Condomino condomino) {
		this.nome = nome;
		this.numero = numero;
		this.tipoUnidade = tipoUnidade;
		this.condomino = condomino;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public TipoUnidade getTipoUnidade() {
		return tipoUnidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, numero, tipoUnidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidade other = (Unidade) obj;
		return Objects.equals(nome, other.nome) && numero == other.numero && tipoUnidade == other.tipoUnidade;
	}

	@Override
	public String toString() {
		return "Unidade [nome=" + nome + ", numero=" + numero + ", tipoUnidade=" + tipoUnidade + "]";
	}
	
	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
		
	}
}
