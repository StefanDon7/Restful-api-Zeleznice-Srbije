package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tiplinije")
public class TipLinije  {

    @Id
    @Column(name = "tiplinijeid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipLinijeID;
    
    @Column(name = "naziv")
    private String naziv;

    public TipLinije() {
    }

    public TipLinije(int tipID) {
        this.tipLinijeID = tipID;
    }

    public TipLinije(int tipID, String naziv) {
        this.tipLinijeID = tipID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTipLinijeID() {
        return tipLinijeID;
    }

    public void setTipLinijeID(int tipLinijeID) {
        this.tipLinijeID = tipLinijeID;
    }

    @Override
    public String toString() {
        return naziv;
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
        final TipLinije other = (TipLinije) obj;
        if (this.tipLinijeID != other.tipLinijeID) {
            return false;
        }
        return true;
    }
    
    
}
