package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidade.Condomino;

public class MuralEletronicoTest {

	private MuralEletronico mural;
    private Condomino proprietario;
    private Condomino inquilino;

    @BeforeEach
    public void setUp() {
        mural = new MuralEletronico();
        proprietario = new Condomino("João", "123456789", true);
        inquilino = new Condomino("Maria", "987654321", false);

        mural.adicionarMensagem("Reunião do condomínio dia 15/09.");
        mural.adicionarMensagem("Manutenção do elevador dia 20/09.");
    }

    @Test
    public void testVisualizarMensagens() {
        // Ambos, proprietário e inquilino, devem visualizar todas as mensagens
        assertEquals(2, mural.visualizarMensagens(proprietario).size());
        assertEquals(2, mural.visualizarMensagens(inquilino).size());
    }

    @Test
    public void testConfirmarLeitura() {
        // Confirmar leitura de uma mensagem
        mural.confirmarLeitura(proprietario, "Reunião do condomínio dia 15/09.");
        assertTrue(mural.isLeituraConfirmada(proprietario, "Reunião do condomínio dia 15/09."));
        assertFalse(mural.isLeituraConfirmada(inquilino, "Reunião do condomínio dia 15/09."));
    }

    @Test
    public void testConfirmarLeituraMensagemNaoExistente() {
        // Tentar confirmar leitura de uma mensagem inexistente deve lançar exceção
        assertThrows(IllegalArgumentException.class, () -> mural.confirmarLeitura(proprietario, "Mensagem inexistente"));
    }

    @Test
    public void testGetMensagensConfirmadas() {
        // Confirmar uma mensagem e verificar a lista de mensagens confirmadas
        mural.confirmarLeitura(proprietario, "Manutenção do elevador dia 20/09.");
        assertEquals(1, mural.getMensagensConfirmadas(proprietario).size());
        assertTrue(mural.getMensagensConfirmadas(proprietario).contains("Manutenção do elevador dia 20/09."));
    }
}
