package domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ReservaEspaco {
    // Armazena as reservas no formato: espaço -> data/hora -> proprietário
    private Map<String, Map<LocalDateTime, String>> reservas;

    public ReservaEspaco() {
        reservas = new HashMap<>();
    }

    /**
     * Adiciona um espaço comum ao sistema.
     * @param espaco Nome do espaço comum.
     */
    public void adicionarEspaco(String espaco) {
        reservas.putIfAbsent(espaco, new HashMap<>());
    }

    /**
     * Verifica se o espaço comum está disponível para a reserva.
     * @param espaco Nome do espaço comum.
     * @param dataHora Data e hora da reserva.
     * @return true se o espaço está disponível, false caso contrário.
     */
    public boolean verificarDisponibilidade(String espaco, LocalDateTime dataHora) {
        Map<LocalDateTime, String> reservasEspaco = reservas.get(espaco);
        return reservasEspaco == null || !reservasEspaco.containsKey(dataHora);
    }

    /**
     * Reserva um espaço comum se estiver disponível.
     * @param espaco Nome do espaço comum.
     * @param dataHora Data e hora da reserva.
     * @param proprietario Nome do proprietário que está realizando a reserva.
     * @return true se a reserva for bem-sucedida, false caso contrário.
     */
    public boolean reservarEspaco(String espaco, LocalDateTime dataHora, String proprietario) {
        if (verificarDisponibilidade(espaco, dataHora)) {
            reservas.get(espaco).put(dataHora, proprietario);
            return true;
        }
        return false;
    }
}
