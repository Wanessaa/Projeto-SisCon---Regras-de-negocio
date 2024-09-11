package entidade;

import java.time.LocalDateTime;

public class Multa {
	
	private double valor;
    private LocalDateTime dataAplicacao;

    public Multa(double valor, LocalDateTime dataAplicacao) {
        this.valor = valor;
        this.dataAplicacao = dataAplicacao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataAplicacao() {
        return dataAplicacao;
    }
}
