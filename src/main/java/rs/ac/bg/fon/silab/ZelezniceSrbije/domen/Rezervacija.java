package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name = "rezervacija")
public class Rezervacija {

    @Id
    @Column(name = "rezervacijaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rezervacijaID;

    @ManyToOne
    @JoinColumn(name = "klijentid")
    private Klijent klijent;

    @ManyToOne
    @JoinColumn(name = "polazakid")
    private Polazak polazak;

    @Column(name = "date")
    private Date date;

    public Rezervacija() {
    }

    public Rezervacija(int rezervacijaID, Klijent klijent, Polazak polazak, Date date) {
        this.rezervacijaID = rezervacijaID;
        this.klijent = klijent;
        this.polazak = polazak;
        this.date = date;
    }

    public int getRezervacijaID() {
        return rezervacijaID;
    }

    public void setRezervacijaID(int rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }
    

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;

    }

    public Polazak getPolazak() {
        return polazak;
    }

    public void setPolazak(Polazak polazak) {
        this.polazak = polazak;

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "rezervacijaID=" + rezervacijaID + ", klijent=" + klijent + ", polazak=" + polazak + ", date=" + date + '}';
    }

    

}
