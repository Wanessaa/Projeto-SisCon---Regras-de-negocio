package entidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.Veiculo;
import entidade.Proprietario;

class ProprietarioTest {

	@Test
    public void devePermitirApenasUmVeiculoPorProprietario() {
        Proprietario proprietario = new Proprietario("João");
      
        Veiculo carro1 = new Veiculo("ABC-1234", "Carro");
        proprietario.adicionarVeiculo(carro1);
        
        // Adiciona um segundo veículo - deve falhar
        Veiculo carro2 = new Veiculo("DEF-5678", "Moto");
        Exception excecao = assertThrows(RuntimeException.class, () -> {
            proprietario.adicionarVeiculo(carro2);
        });
        
        assertEquals("O proprietário já possui um veículo registrado.", excecao.getMessage());
    }
	
	
	 @Test
	    public void devePermitirAdicionarNovoVeiculoAposRemocao() {
	        Proprietario proprietario = new Proprietario("Ana");
	        Veiculo carro1 = new Veiculo("LMN-7890", "Carro");
	        Veiculo carro2 = new Veiculo("OPQ-1234", "Carro");

	        proprietario.adicionarVeiculo(carro1);

	        // Simula a remoção
	        proprietario.removerVeiculo();

	        // Adiciona um novo veículo
	        proprietario.adicionarVeiculo(carro2);

	        assertNotNull(proprietario.getVeiculo());
	        assertEquals("OPQ-1234", proprietario.getVeiculo().getPlaca());
	    }

	    
}


