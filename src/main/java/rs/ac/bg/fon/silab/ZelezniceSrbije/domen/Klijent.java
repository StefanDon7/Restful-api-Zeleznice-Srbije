package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "klijent")
@Entity
@Table(name = "klijent")
public class Klijent {

    @Id
    @Column(name = "klijentid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int klijentID;

    @Email(message = "Email adresa mora biti validna!")
    @NotBlank(message = "Email is mandatory")
    @NotNull(message = "Email ne sme biti null")
    @Column(name = "email")
    private String email;

    @Column(name = "korisnickoime")
    @Size(min = 2, message = "Korisnicko ime mora imati barem 2 karaktera!")
    private String korisnickoIme;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "lozinka")
    private String lozinka;

    public Klijent() {
    }

    public Klijent(int klijentID, String email, String korisnickoIme, String ime, String prezime, String lozinka) {
        this.klijentID = klijentID;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
    }

    public Klijent(int klijentID) {
        this.klijentID = klijentID;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
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
        return "Klijent{" + "klijentID=" + klijentID + ", email=" + email + ", korisnickoIme=" + korisnickoIme + ", ime=" + ime + ", prezime=" + prezime + ", lozinka=" + lozinka + '}';
    }

}
