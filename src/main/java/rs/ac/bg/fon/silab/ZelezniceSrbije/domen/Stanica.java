package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stanica")
public class Stanica {
    @Id
    @Column(name = "stanicaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stanicaID;
    
    @NotBlank(message = "Naziv stanice je obavezno polje!")
    @Size(min = 2, message = "Naziv stanice mora imati najmanje 2 karaktera!")
    @Column(name="nazivstanice")
    private String naziv;
    
    @ManyToOne
    @JoinColumn(name = "mestoid")
    private Mesto mesto;

//    
//    @ManyToMany(mappedBy = "stanicaID",targetEntity = Linija.class)
//    private List<Linija> linije;
//    
    
    public Stanica() {
    }
    


    public Stanica(int stanicaID) {
	super();
	this.stanicaID = stanicaID;
}



	public int getStanicaID() {
        return stanicaID;
    }

    public void setStanicaID(int stanicaID) {
        this.stanicaID = stanicaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
   
    

    

    
    

}
