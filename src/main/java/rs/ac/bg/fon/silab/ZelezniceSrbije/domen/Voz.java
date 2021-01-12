package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "voz")
public class Voz  {

    @Id
    @Column(name = "vozid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vozID;
    
    @Column(name = "naziv")
    private String naziv;
    
    @Column(name = "brojmesta")
    private int brojMesta;

    public Voz() {
    }

    public Voz(int vozID) {
        this.vozID = vozID;
    }

    public Voz(int vozID, String naziv, int brojMesta) {
        this.vozID = vozID;
        this.naziv = naziv;
        this.brojMesta = brojMesta;
    }

    public int getVozID() {
        return vozID;
    }

    public void setVozID(int vozID) {
        this.vozID = vozID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojSedista() {
        return brojMesta;
    }

    public void setBrojSedista(int brojMesta) {
        this.brojMesta = brojMesta;
    }

    @Override
    public String toString() {
        return naziv + "(" + brojMesta + ")";
    }


}
