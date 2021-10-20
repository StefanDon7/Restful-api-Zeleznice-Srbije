package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.compositeKey.RezervacijaCompositeKey;


@Entity
@Table(name = "rezervacija")
public class Rezervacija {
	
	@JsonIgnore
    @EmbeddedId
    RezervacijaCompositeKey key;
    
    @ManyToOne
    @JoinColumn(name = "klijentid", insertable = false, updatable = false)
    private Klijent klijent;
    
    @ManyToOne
    @JoinColumn(name = "polazakid", insertable = false, updatable = false)
    private Polazak polazak;
    
    @Column(name = "date")
    private Date date;

    public Rezervacija() {
    }
    

    public Rezervacija(RezervacijaCompositeKey key, Klijent klijent, Polazak polazak, Date date) {
		super();
		this.key = key;
		this.klijent = klijent;
		this.polazak = polazak;
		this.date = date;
	}


	public Rezervacija(Klijent klijent, Polazak polazak, Date date) {
        this.klijent = klijent;
        this.polazak = polazak;
        this.date = date;
        this.key = new RezervacijaCompositeKey(klijent.getKlijentID(), polazak.getPolazakID());
    }
    
    public RezervacijaCompositeKey getKey() {
        return key;
    }

    public void setKey(RezervacijaCompositeKey key) {
        this.key = key;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
        if(this.key == null)
            this.key = new RezervacijaCompositeKey();
        this.key.setKlijentID(klijent.getKlijentID());
    }

    public Polazak getPolazak() {
        return polazak;
    }

    public void setPolazak(Polazak polazak) {
        this.polazak = polazak;
        if(this.key == null)
            this.key = new RezervacijaCompositeKey();
        this.key.setPolazakID(polazak.getPolazakID());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


	@Override
	public String toString() {
		return "Rezervacija: "+key;
	}

    
}