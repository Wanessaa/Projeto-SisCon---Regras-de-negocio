package domain;

import java.util.ArrayList;
import java.util.List;

import entidade.Condomino;

public class Conselho {
	private List<Condomino> membrosPrincipais;
    private List<Condomino> suplentes;
    private boolean registrado;

    public Conselho() {
        this.membrosPrincipais = new ArrayList<>();
        this.suplentes = new ArrayList<>();
        this.registrado = false;
    }

    public void adicionarMembro(Condomino membro) {
        if (membrosPrincipais.size() < 5) {
            membrosPrincipais.add(membro);
        } else {
            throw new IllegalStateException("O conselho já possui 5 membros principais.");
        }
    }

    public void adicionarSuplente(Condomino suplente) {
        if (suplentes.size() < 2) {
            suplentes.add(suplente);
        } else {
            throw new IllegalStateException("O conselho já possui 2 suplentes.");
        }
    }

    public int getQuantidadeMembrosPrincipais() {
        return membrosPrincipais.size();
    }

    public int getQuantidadeSuplentes() {
        return suplentes.size();
    }

    public List<Condomino> getMembrosPrincipais() {
        return membrosPrincipais;
    }

    public List<Condomino> getSuplentes() {
        return suplentes;
    }
    
    public void registrarConselho() {
        if (membrosPrincipais.size() >= 3 && suplentes.size() == 2) {
            this.registrado = true;
        } else {
            throw new IllegalStateException("O conselho não pode ser registrado sem pelo menos 3 membros principais e 2 suplentes.");
        }
    }
    
    public boolean isRegistrado() {
        return registrado;
    }

    public void tomarDecisao(String decisao) {
        if (!registrado) {
            throw new IllegalStateException("O conselho não está registrado e não pode tomar decisões.");
        }
   
    }
}
