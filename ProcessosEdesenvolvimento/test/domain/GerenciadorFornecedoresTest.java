package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidade.Fornecedor;

public class GerenciadorFornecedoresTest {

	private GerenciadorFornecedores gerenciadorFornecedores;

	@BeforeEach
    public void setUp() {
        gerenciadorFornecedores = new GerenciadorFornecedores();
    }

    @Test
    public void testAdicionarFornecedorUnico() {
        Fornecedor fornecedor = new Fornecedor("João Silva", "Silva & Cia");
        fornecedor.adicionarServicoOuProduto("Serviços de limpeza");
        gerenciadorFornecedores.adicionarFornecedor(fornecedor);

        List<Fornecedor> fornecedores = gerenciadorFornecedores.listarFornecedores();
        assertEquals(1, fornecedores.size());
        assertEquals(fornecedor, fornecedores.get(0));
    }

    @Test
    public void testAdicionarFornecedorDuplicado() {
        Fornecedor fornecedor1 = new Fornecedor("João Silva", "Silva & Cia");
        fornecedor1.adicionarServicoOuProduto("Serviços de limpeza");
        gerenciadorFornecedores.adicionarFornecedor(fornecedor1);

        Fornecedor fornecedor2 = new Fornecedor("João Silva", "Silva & Cia");
        fornecedor2.adicionarServicoOuProduto("Serviços de limpeza");
        
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            gerenciadorFornecedores.adicionarFornecedor(fornecedor2);
        });

        String mensagemEsperada = "Fornecedor já cadastrado: Fornecedor{nome='João Silva', empresa='Silva & Cia', servicosOuProdutos=[Serviços de limpeza]}";
        assertEquals(mensagemEsperada, thrown.getMessage());
    }

    @Test
    public void testListarFornecedores() {
        Fornecedor fornecedor1 = new Fornecedor("João Silva", "Silva & Cia");
        fornecedor1.adicionarServicoOuProduto("Serviços de limpeza");
        Fornecedor fornecedor2 = new Fornecedor("Maria Oliveira", "Oliveira & Associados");
        fornecedor2.adicionarServicoOuProduto("Serviços de jardinagem");
        
        gerenciadorFornecedores.adicionarFornecedor(fornecedor1);
        gerenciadorFornecedores.adicionarFornecedor(fornecedor2);

        List<Fornecedor> fornecedores = gerenciadorFornecedores.listarFornecedores();
        
        // Verificar se a lista contém os fornecedores esperados
        assertTrue(fornecedores.contains(fornecedor1), "A lista deve conter o fornecedor João Silva.");
        assertTrue(fornecedores.contains(fornecedor2), "A lista deve conter o fornecedor Maria Oliveira.");
    }
    
    @Test
    public void testListarFornecedoresErro() {
        Fornecedor fornecedor1 = new Fornecedor("João Silva", "Silva & Cia");
        fornecedor1.adicionarServicoOuProduto("Serviços de limpeza");
        Fornecedor fornecedor2 = new Fornecedor("Maria Oliveira", "Oliveira & Associados");
        fornecedor2.adicionarServicoOuProduto("Serviços de jardinagem");
        
        Fornecedor fornecedorNaoAdicionado = new Fornecedor("José Batista", "Oliveira & Associados");
        
        gerenciadorFornecedores.adicionarFornecedor(fornecedor1);
        gerenciadorFornecedores.adicionarFornecedor(fornecedor2);

        List<Fornecedor> fornecedores = gerenciadorFornecedores.listarFornecedores();
        
        // Verificar que o fornecedor não adicionado não está na lista
        assertFalse(fornecedores.contains(fornecedorNaoAdicionado));
    }
}
