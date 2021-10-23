package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "medjustanica")
public class Medjustanica {


    @Id
    @Column(name = "medjustanicaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medjustanicaID;

    @ManyToOne
    @JoinColumn(name = "linijaid")
    private Linija linija;

    @ManyToOne
    @JoinColumn(name = "stanicaid")
    private Stanica stanica;

    @Column(name = "rednibroj")
    private int redniBroj;

    public Medjustanica() {

    }

    public Medjustanica(int medjustanicaID, Linija linija, Stanica stanica, int redniBroj) {
       this.medjustanicaID=medjustanicaID;
        this.linija = linija;
        this.stanica = stanica;
        this.redniBroj = redniBroj;
    }

    public int getMedjustanicaID() {
        return medjustanicaID;
    }

    public void setMedjustanicaID(int medjustanicaID) {
        this.medjustanicaID = medjustanicaID;
    }

    public Linija getLinija() {
        return linija;
    }

    public void setLinija(Linija linija) {
        this.linija = linija;
    }

    public Stanica getStanica() {
        return stanica;
    }

    public void setStanica(Stanica stanica) {
        this.stanica = stanica;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    @Override
    public String toString() {
        return "Medjustanica{" + "medjustanicaID=" + medjustanicaID + ", linija=" + linija + ", stanica=" + stanica + ", redniBroj=" + redniBroj + '}';
    }

   

}
