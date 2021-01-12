package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "polazak")
public class Polazak  {

    @Id
    @Column(name = "polazakid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int polazakID;

    @Column(name = "naziv")
    private String naziv;
    
    @Column(name = "datumpolaska")
    private Date datumPolaska;
    
    @Column(name = "datumdolaska")
    private Date datumDolaska;
    
    @ManyToOne
    @JoinColumn(name = "linijaid")
    private Linija linija;
    
    @ManyToOne
    @JoinColumn(name = "vozid")
    private Voz voz;
    
    @Column(name = "napomena")
    private String napomena;
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rezervacija",
            joinColumns = @JoinColumn(name = "polazakid"),
            inverseJoinColumns = @JoinColumn(name = "klijentid"))
    private List<Klijent> klijenti;

    public Polazak() {
    }

    public Polazak(int polazakID) {
        this.polazakID = polazakID;
    }

    public Polazak(Date datumPolaska) {
        this.datumPolaska = datumPolaska;
    }
    

    public int getPolazakID() {
        return polazakID;
    }

    public void setPolazakID(int polazakID) {
        this.polazakID = polazakID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Linija getLinija() {
        return linija;
    }

    public void setLinija(Linija linija) {
        this.linija = linija;
    }

    public Voz getVoz() {
        return voz;
    }

    public void setVoz(Voz voz) {
        this.voz = voz;
    }

    public Date getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(Date datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    public Date getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(Date datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public List<Klijent> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(List<Klijent> klijenti) {
        this.klijenti = klijenti;
    }

    @Override
    public String toString() {
        return naziv;
    }
}

