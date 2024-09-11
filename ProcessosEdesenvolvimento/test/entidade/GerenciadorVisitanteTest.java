package entidade;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import domain.GerenciadorVisitante;

public class GerenciadorVisitanteTest {

	 @Test
	    public void testRegistroDeVisitante() {
	        GerenciadorVisitante gerenciadorVisitante = new GerenciadorVisitante();
	        Condomino condomino = new Condomino("João Silva", "12345678900", false);
	        Unidade unidade = new Unidade("Bloco A", 101, TipoUnidade.APARTAMENTO, condomino);
	        LocalDateTime horarioEntrada = LocalDateTime.of(2024, 9, 7, 10, 0);

	        boolean registrado = gerenciadorVisitante.registrarVisitante("Carlos", "Silva", unidade, horarioEntrada);

	        assertTrue(registrado); // O visitante deve ser registrado com sucesso
	    }

	    @Test
	    public void testVisitanteVinculadoAoProprietario() {
	    	GerenciadorVisitante gerenciadorVisitante = new GerenciadorVisitante();
	    	Condomino condomino = new Condomino("João Silva", "12345678900", false);
	        Unidade unidade = new Unidade("Bloco A", 101, TipoUnidade.APARTAMENTO, condomino);
	        LocalDateTime horarioEntrada = LocalDateTime.of(2024, 9, 7, 10, 0);

	        gerenciadorVisitante.registrarVisitante("Carlos", "Silva", unidade, horarioEntrada);
	        
	        Visitante visitante = gerenciadorVisitante.buscarVisitante("Carlos", "Silva");
	        assertEquals(unidade, visitante.getUnidadeVisitada()); // Verifica se o visitante está vinculado à unidade correta
	    }

	    @Test
	    public void testRegistroDeVisitanteDuplicado() {
	    	GerenciadorVisitante gerenciadorVisitante = new GerenciadorVisitante();
	    	Condomino condomino = new Condomino("João Silva", "12345678900", false);
	        Unidade unidade = new Unidade("Bloco A", 101, TipoUnidade.APARTAMENTO, condomino);
	        LocalDateTime horarioEntrada = LocalDateTime.of(2024, 9, 7, 10, 0);

	        gerenciadorVisitante.registrarVisitante("Carlos", "Silva", unidade, horarioEntrada);
	        boolean duplicado = gerenciadorVisitante.registrarVisitante("Carlos", "Silva", unidade, horarioEntrada);

	        assertFalse(duplicado); // O sistema não deve permitir o registro duplicado de um visitante
	    }
}
