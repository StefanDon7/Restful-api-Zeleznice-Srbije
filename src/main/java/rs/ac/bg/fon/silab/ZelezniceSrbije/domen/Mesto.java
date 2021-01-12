package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mesto")
public class Mesto {
    @Id
    @Column(name = "mestoid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mestoID;
    
    @Column(name = "nazivmesta")
    private String nazivMesta;
   

    public Mesto() {
    }

    public Mesto(int mestoID, String nazivMesta) {
        this.mestoID = mestoID;
        this.nazivMesta = nazivMesta;
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public String getNazivMesta() {
        return nazivMesta;
    }

    public void setNazivMesta(String nazivMesta) {
        this.nazivMesta = nazivMesta;
    }

    @Override
    public String toString() {
        return "Mesto{" + "mestoID=" + mestoID + ", nazivMesta=" + nazivMesta + '}';
    }

}
