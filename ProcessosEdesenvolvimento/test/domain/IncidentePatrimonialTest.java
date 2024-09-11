package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import entidade.Condomino;
import entidade.TipoUnidade;
import entidade.Unidade;

public class IncidentePatrimonialTest {

	@Test
    public void testAplicarMultaSemHistorico() {
        Condomino condomino = new Condomino("Carlos", "123456789", false);
        Unidade unidade = new Unidade("Bloco A", 101, TipoUnidade.APARTAMENTO, condomino);
        IncidentePatrimonial incidente = new IncidentePatrimonial("Perturbação do sossego", LocalDateTime.now());

        double multa = incidente.aplicarMulta(unidade);

        assertEquals(200.0, multa); // Valor base da multa
    }

    @Test
    public void testAplicarMultaComHistoricoMenorQue12Meses() {
        Condomino condomino = new Condomino("Carlos", "123456789", false);
        Unidade unidade = new Unidade("Bloco A", 101, TipoUnidade.APARTAMENTO, condomino);

        // Adiciona um incidente anterior nos últimos 12 meses
        IncidentePatrimonial incidenteAnterior = new IncidentePatrimonial("Danos ao patrimonio", LocalDateTime.now().minus(6, ChronoUnit.MONTHS));
        condomino.adicionarIncidente(incidenteAnterior);

        IncidentePatrimonial incidente = new IncidentePatrimonial("Perturbação do sossego", LocalDateTime.now());
        double multa = incidente.aplicarMulta(unidade);

        assertEquals(220.0, multa); // 10% de acréscimo por multa recente
    }

    @Test
    public void testAplicarMultaReincidenciaDoMesmoTipo() {
        Condomino condomino = new Condomino("Carlos", "123456789", false);
        Unidade unidade = new Unidade("Bloco A", 101, TipoUnidade.APARTAMENTO, condomino);

        // Histórico de incidente anterior do mesmo tipo
        IncidentePatrimonial incidenteAnterior = new IncidentePatrimonial("Perturbação do sossego", LocalDateTime.now().minus(6, ChronoUnit.MONTHS));
        condomino.adicionarIncidente(incidenteAnterior);

        IncidentePatrimonial incidenteAtual = new IncidentePatrimonial("Perturbação do sossego", LocalDateTime.now());
        double multa = incidenteAtual.aplicarMulta(unidade);

        assertEquals(253.0, multa); // 10% por histórico + 15% por reincidência
    }
}
