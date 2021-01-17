package rs.ac.bg.fon.silab.ZelezniceSrbije.domen.compositeKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RezervacijaCompositeKey implements Serializable{
	
    private static final long serialVersionUID = 1234567L;
    
    @Column(name = "klijentid")
    private int klijentID;
    
    @Column(name = "polazakid")
    private int polazakID;

    public RezervacijaCompositeKey() {
    }

    public RezervacijaCompositeKey(int klijentID, int polazakID) {
        this.klijentID = klijentID;
        this.polazakID = polazakID;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public int getPolazakID() {
        return polazakID;
    }

    public void setPolazakID(int polazakID) {
        this.polazakID = polazakID;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RezervacijaCompositeKey other = (RezervacijaCompositeKey) obj;
        if (this.klijentID != other.klijentID) {
            return false;
        }
        if (this.polazakID != other.polazakID) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "RezervacijaCompositeKey [klijentID=" + klijentID + ", polazakID=" + polazakID + "]";
	}
    

	
}
