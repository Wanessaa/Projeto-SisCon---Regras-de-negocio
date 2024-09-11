package entidade;

import java.util.ArrayList;
import java.util.List;

import domain.IncidentePatrimonial;

public class Condomino {
    private String nome;
    private String documentoIdentidade; // Pode ser CPF, RG, etc.
    private List<IncidentePatrimonial> incidentes;
    private boolean isProprietario;

    public Condomino(String nome, String documentoIdentidade, boolean isProprietario) {
        this.nome = nome;
        this.documentoIdentidade = documentoIdentidade;
        this.incidentes = new ArrayList<>();
        this.isProprietario = isProprietario;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumentoIdentidade() {
        return documentoIdentidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumentoIdentidade(String documentoIdentidade) {
        this.documentoIdentidade = documentoIdentidade;
    }
    
    public List<IncidentePatrimonial> getIncidentes() {
        return incidentes;
    }

    public void adicionarIncidente(IncidentePatrimonial incidente) {
        this.incidentes.add(incidente);
    }

    public boolean verificarReincidencia(String tipoIncidente) {
        for (IncidentePatrimonial incidente : incidentes) {
            if (incidente.getTipo().equals(tipoIncidente)) {
                return true; // Reincidência encontrada
            }
        }
        return false; // Não há reincidência
    }
    
    public boolean isProprietario() {
        return isProprietario;
    }

    public Proprietario toProprietario() {
        if (isProprietario) {
            return new Proprietario(nome);
        } else {
            throw new IllegalStateException("O condomíno não é proprietário.");
        }
    }

    public void setProprietario(boolean isProprietario) {
        this.isProprietario = isProprietario;
    }
}
