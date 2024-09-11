package domain;

import org.junit.jupiter.api.Test;

import entidade.Condomino;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorCondominosTest {

    @Test
    public void testAdicionarCondomino() {
        GerenciadorCondominos gerenciador = new GerenciadorCondominos();
        Condomino condomino = new Condomino("João Silva", "12345678900", false);

        assertTrue(gerenciador.adicionarCondomino(condomino), "Condômino deveria ser adicionado com sucesso");
        assertNotNull(gerenciador.buscarCondomino("12345678900"), "Condômino deveria estar presente após adição");
    }

    @Test
    public void testAdicionarCondominoDuplicado() {
        GerenciadorCondominos gerenciador = new GerenciadorCondominos();
        Condomino condomino1 = new Condomino("João Silva", "12345678900", false);
        Condomino condomino2 = new Condomino("Maria Oliveira", "12345678900", false);

        gerenciador.adicionarCondomino(condomino1);
        assertFalse(gerenciador.adicionarCondomino(condomino2), "Não deveria ser possível adicionar um condômino com documento duplicado");
    }

    @Test
    public void testEditarCondomino() {
        GerenciadorCondominos gerenciador = new GerenciadorCondominos();
        Condomino condomino = new Condomino("João Silva", "12345678900", false);

        gerenciador.adicionarCondomino(condomino);
        assertTrue(gerenciador.editarCondomino("12345678900", "João Pedro Silva"), "Nome do condômino deveria ser atualizado com sucesso");
        assertEquals("João Pedro Silva", gerenciador.buscarCondomino("12345678900").getNome(), "Nome do condômino não foi atualizado corretamente");
    }

    @Test
    public void testRemoverCondomino() {
        GerenciadorCondominos gerenciador = new GerenciadorCondominos();
        Condomino condomino = new Condomino("João Silva", "12345678900", false);

        gerenciador.adicionarCondomino(condomino);
        assertTrue(gerenciador.removerCondomino("12345678900"), "Condômino deveria ser removido com sucesso");
        assertNull(gerenciador.buscarCondomino("12345678900"), "Condômino não deveria estar presente após remoção");
    }
}
