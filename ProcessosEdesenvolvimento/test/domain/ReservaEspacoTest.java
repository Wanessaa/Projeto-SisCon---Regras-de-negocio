package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaEspacoTest {
    private ReservaEspaco reservaEspaco;

    @BeforeEach
    public void setUp() {
        reservaEspaco = new ReservaEspaco();
        reservaEspaco.adicionarEspaco("Salão de Festas");
        reservaEspaco.adicionarEspaco(null);
    }

    @Test
    public void testVerificarDisponibilidadeEspacoLivre() {
        LocalDateTime dataHora = LocalDateTime.of(2024, 9, 5, 14, 0);
        assertTrue(reservaEspaco.verificarDisponibilidade("Salão de Festas", dataHora));
    }

    @Test
    public void testReservarEspacoComDisponibilidade() {
        LocalDateTime dataHora = LocalDateTime.of(2024, 9, 5, 14, 0);
        assertTrue(reservaEspaco.reservarEspaco("Salão de Festas", dataHora, "João"));
    }

    @Test
    public void testReservarEspacoComConflito() {
        LocalDateTime dataHora = LocalDateTime.of(2024, 9, 5, 14, 0);
        reservaEspaco.reservarEspaco("Salão de Festas", dataHora, "João");
        assertFalse(reservaEspaco.reservarEspaco("Salão de Festas", dataHora, "Maria"));
    }
}
