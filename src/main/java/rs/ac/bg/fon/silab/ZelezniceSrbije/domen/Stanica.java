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
@Table(name = "stanica")
public class Stanica {
    @Id
    @Column(name = "stanicaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stanicaID;
    
    @Column(name="nazivstanice")
    private String nazivStanice;
    
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

    public String getNazivStanice() {
        return nazivStanice;
    }

    public void setNazivStanice(String nazivStanice) {
        this.nazivStanice = nazivStanice;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return nazivStanice;
    }
    
    
   
    

    

    
    

}
