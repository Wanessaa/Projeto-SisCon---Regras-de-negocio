package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidade.Condomino;
import entidade.Proprietario;

public class ReceitaCondominioTest {

	private ReceitaCondominio receitaCondominio;
    private Proprietario proprietario1;
    private Proprietario proprietario2;
    private Condomino condominoProprietario;
    private Condomino condominoNaoProprietario;
    private Proprietario condominoEProprietario;

    @BeforeEach
    public void setUp() {
        receitaCondominio = new ReceitaCondominio("Receita de R$ 50.000");
        proprietario1 = new Proprietario("João");
        proprietario2 = new Proprietario("Maria");
        
        condominoProprietario = new Condomino("Lucas", "111223344", true);
        condominoEProprietario = condominoProprietario.toProprietario();
        condominoNaoProprietario = new Condomino("Carlos", "555667788", false);
        
        receitaCondominio.adicionarProprietario(proprietario1);
        receitaCondominio.adicionarProprietario(proprietario2);
        receitaCondominio.adicionarProprietario(condominoEProprietario);
    }

    @Test
    public void testAcessoAutorizado() {
        assertEquals("Receita de R$ 50.000", receitaCondominio.acessarReceita(proprietario1));
        assertEquals("Receita de R$ 50.000", receitaCondominio.acessarReceita(proprietario2));
        assertEquals("Receita de R$ 50.000", receitaCondominio.acessarReceita(condominoEProprietario));
    }

    @Test
    public void testAcessoNegado() {
    	// Criar um Proprietario válido
        Proprietario validProprietario = new Proprietario("João");

        // Adicionar um proprietário válido ao ReceitaCondominio
        receitaCondominio.adicionarProprietario(validProprietario);

        // Tentar acessar a receita com um Condomino que não é um proprietário
        assertThrows(SecurityException.class, () -> {
            receitaCondominio.acessarReceita(new Proprietario("Carlos"));
        });
    	
       // assertThrows(SecurityException.class, () -> receitaCondominio.acessarReceita(condominoNaoProprietario.toProprietario()));
    }

    @Test
    public void testAdicionarProprietario() {
        Proprietario novoProprietario = new Proprietario("Ana");
        receitaCondominio.adicionarProprietario(novoProprietario);
        assertEquals("Receita de R$ 50.000", receitaCondominio.acessarReceita(novoProprietario));
    }

}
