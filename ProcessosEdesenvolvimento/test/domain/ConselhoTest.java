package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidade.Condomino;

public class ConselhoTest {

	private Conselho conselho;
    private Condomino membro1;
    private Condomino membro2;
    private Condomino suplente1;
    private Condomino suplente2;
    private Condomino suplente3; // Para testar o caso de exceção

    @BeforeEach
    public void setUp() {
        conselho = new Conselho();
        membro1 = new Condomino("João", "123456789", false);
        membro2 = new Condomino("Maria", "987654321", false);
        
        suplente1 = new Condomino("Carlos", "111223344", false);
        suplente2 = new Condomino("Ana", "555667788", false);
        suplente3 = new Condomino("Pedro", "999000111", false);
    }

    @Test
    public void testAdicionarMembro() {
        conselho.adicionarMembro(membro1);
        conselho.adicionarMembro(membro2);
        assertEquals(2, conselho.getQuantidadeMembrosPrincipais());
    }

    @Test
    public void testAdicionarSuplente() {
        conselho.adicionarSuplente(suplente1);
        conselho.adicionarSuplente(suplente2);
        assertEquals(2, conselho.getQuantidadeSuplentes());
    }

    @Test
    public void testAdicionarMaisDeCincoMembros() {
        conselho.adicionarMembro(membro1);
        conselho.adicionarMembro(membro2);
        // Adicione três mais membros
        for (int i = 0; i < 3; i++) {
            conselho.adicionarMembro(new Condomino("Membro" + i, "00000000" + i, false));
        }
        // Tentativa de adicionar o sexto membro deve lançar exceção
        assertThrows(IllegalStateException.class, () -> conselho.adicionarMembro(new Condomino("Excesso", "000000006", false)));
    }

    @Test
    public void testAdicionarMaisDeDoisSuplentes() {
        conselho.adicionarSuplente(suplente1);
        conselho.adicionarSuplente(suplente2);
        // Tentativa de adicionar o terceiro suplente deve lançar exceção
        assertThrows(IllegalStateException.class, () -> conselho.adicionarSuplente(suplente3));
    }
    
    
    @Test
    public void testRegistrarConselhoSemQuantidadeSuficienteDeMembros() {
        // Adiciona 2 membros principais e 2 suplentes, que não é suficiente para registrar
        conselho.adicionarMembro(membro1);
        conselho.adicionarMembro(membro2);
        conselho.adicionarSuplente(suplente1);
        conselho.adicionarSuplente(suplente2);

        // Tentativa de registrar o conselho deve lançar exceção
        assertThrows(IllegalStateException.class, () -> conselho.registrarConselho(), 
                     "O conselho não pode ser registrado sem pelo menos 3 membros principais e 2 suplentes.");
    }

    @Test
    public void testRegistrarConselhoComQuantidadeSuficienteDeMembros() {
        // Adiciona 3 membros principais e 2 suplentes, que é suficiente para registrar
        conselho.adicionarMembro(membro1);
        conselho.adicionarMembro(membro2);
        conselho.adicionarMembro(new Condomino("Membro3", "333444555", false));
        conselho.adicionarSuplente(suplente1);
        conselho.adicionarSuplente(suplente2);

        // Registrar o conselho deve passar sem exceção
        assertDoesNotThrow(() -> conselho.registrarConselho());

        // Verificar se o conselho está registrado
        assertTrue(conselho.isRegistrado(), "O conselho deve estar registrado.");
    }

    @Test
    public void testTomarDecisaoComConselhoRegistrado() {
        // Adiciona 3 membros principais e 2 suplentes, e registra o conselho
        conselho.adicionarMembro(membro1);
        conselho.adicionarMembro(membro2);
        conselho.adicionarMembro(new Condomino("Membro3", "333444555", false));
        conselho.adicionarSuplente(suplente1);
        conselho.adicionarSuplente(suplente2);
        conselho.registrarConselho();

        // Tomar uma decisão com o conselho registrado
        assertDoesNotThrow(() -> conselho.tomarDecisao("Decisão importante"));
    }

    @Test
    public void testTomarDecisaoSemConselhoRegistrado() {
        // Adiciona menos de 3 membros principais e 2 suplentes, não registra o conselho
        conselho.adicionarMembro(membro1);
        conselho.adicionarMembro(membro2);
        conselho.adicionarSuplente(suplente1);
        conselho.adicionarSuplente(suplente2);

        // Tentar tomar uma decisão sem registrar o conselho deve lançar exceção
        assertThrows(IllegalStateException.class, () -> conselho.tomarDecisao("Decisão importante"),
                     "O conselho não está registrado e não pode tomar decisões.");
    }
}

