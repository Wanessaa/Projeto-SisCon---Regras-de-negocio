package domain;

import java.time.LocalDateTime;

import entidade.Condomino;
import entidade.Unidade;

public class IncidentePatrimonial {
	private String tipo;
    private LocalDateTime dataIncidente;
    private final double valorBase = 200.0;

    public IncidentePatrimonial(String tipo, LocalDateTime dataIncidente) {
        this.tipo = tipo;
        this.dataIncidente = dataIncidente;
    }

    public String getTipo() {
        return tipo;
    }

    public double aplicarMulta(Unidade unidade) {
        double valorMulta = valorBase;
        Condomino condomino = unidade.getCondomino();
        boolean multaRecente = false;

        // Verifica se há multas recentes (últimos 12 meses)
        for (IncidentePatrimonial incidente : condomino.getIncidentes()) {
            if (incidente.getDataIncidente().isAfter(LocalDateTime.now().minusMonths(12))) {
                valorMulta += valorMulta * 0.10; // Adiciona 10%
                multaRecente = true;
                break;
            }
        }

        // Verifica se o incidente é reincidência do mesmo tipo
        if (condomino.verificarReincidencia(tipo)) {
            valorMulta += valorMulta * 0.15; // Adiciona 15% por reincidência
        }

        // Registra o incidente no condômino
        condomino.adicionarIncidente(this);

        return valorMulta;
    }

    public LocalDateTime getDataIncidente() {
        return dataIncidente;
    }
}
