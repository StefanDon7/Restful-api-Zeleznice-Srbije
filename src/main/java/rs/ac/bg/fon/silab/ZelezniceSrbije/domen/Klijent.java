package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "klijent")
@Entity
@Table(name = "klijent")
public class Klijent{
	
    @Id
    @Column(name = "klijentid", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int klijentID;
   
    @Email(message = "Email adresa mora biti validna!")
    @Size(min=2,message="Email mora imati barem 2 karaktera!")
    @Column(name = "email")
    private String email;
    
   @Column(name = "korisnickoime")
    private String korisnickoIme;
    
    @Column(name = "ime")
    private String ime;
    
    @Column(name = "prezime")
    private String prezime;
    
    @Column(name = "lozinka")
    private String lozinka;
    
    public Klijent() {
    }

    public Klijent(int klijentID, String korisnickoIme, String email, String ime, String prezime, String lozinka) {
        this.klijentID = klijentID;
        this.korisnickoIme = korisnickoIme;
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
    }
    
    public Klijent(int klijentID) {
        this.klijentID = klijentID;
    }

    public int getId() {
        return klijentID;
    }

    public void setId(int id) {
        this.klijentID = id;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    @Override
    public String toString() {
        return "Klijent{" + "klijentID=" + klijentID + ", korisnickoIme=" + korisnickoIme + ", email=" + email + ", ime=" + ime + ", prezime=" + prezime + ", lozinka=" + lozinka + '}';
    }

    
    

}
