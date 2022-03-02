package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "linija")
public class Linija {

    @Id
    @Column(name = "linijaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int linijaID;

    @NotBlank(message = "Naziv linije je obavezno polje!")
    @Size(min = 2, message = "Naziv linije mora imati najmanje 2 karaktera!")
    @Column(name = "nazivlinije")
    private String nazivLinije;

//    @NotBlank(message = "Polje minutaža je obavezno polje!")
//    @Min(value = 1, message = "Polje minutaža mora biti pozitivan broj!")
    @Column(name = "minutaza")
    private int minutaza;

//    @NotBlank(message = "Polje kilometraža je  obavezno polje!")
//    @Min(value = 1, message = "Polje kilometraža mora biti pozitivan broj!")
    @Column(name = "kilometraza")
    private double kilometraza;

    @ManyToOne
    @JoinColumn(name = "stanicaidpolazna")
    private Stanica stanicaPocetna;

    @ManyToOne
    @JoinColumn(name = "stanicaidkrajnja")
    private Stanica stanicaKrajnja;

    @ManyToOne
    @JoinColumn(name = "tiplinijeid")
    private TipLinije tipLinije;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "medjustanica",
//            joinColumns = @JoinColumn(name = "linijaid"),
//            inverseJoinColumns = @JoinColumn(name = "stanicaid"))
//    private List<Stanica> medjustanice;
    public Linija() {
    }

    public Linija(int linijaID) {
        this.linijaID = linijaID;
    }

    public int getLinijaID() {
        return linijaID;
    }

    public void setLinijaID(int LinijaID) {
        this.linijaID = LinijaID;
    }

    public String getNazivLinije() {
        return nazivLinije;
    }

    public void setNazivLinije(String nazivLinije) {
        this.nazivLinije = nazivLinije;
    }

    public int getMinutaza() {
        return minutaza;
    }

    public void setMinutaza(int minutaza) {
        this.minutaza = minutaza;
    }

    public double getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(double kilometraza) {
        this.kilometraza = kilometraza;
    }

    public Stanica getStanicaPocetna() {
        return stanicaPocetna;
    }

    public void setStanicaPocetna(Stanica stanicaPocetna) {
        this.stanicaPocetna = stanicaPocetna;
    }

    public Stanica getStanicaKrajnja() {
        return stanicaKrajnja;
    }

    public void setStanicaKrajnja(Stanica stanicaKrajnja) {
        this.stanicaKrajnja = stanicaKrajnja;
    }

    public TipLinije getTipLinije() {
        return tipLinije;
    }

    public void setTipLinije(TipLinije tipLinije) {
        this.tipLinije = tipLinije;
    }

//    public List<Stanica> getListaMedjustanica() {
//        return medjustanice;
//    }
//
//    public void setListaMedjustanica(List<Stanica> listaMedjustanica) {
//        this.medjustanice = listaMedjustanica;
//    }
    @Override
    public String toString() {
        return "Linija{" + "linijaID=" + linijaID + ", nazivLinije=" + nazivLinije + ", minutaza=" + minutaza + ", kilometraza=" + kilometraza + ", stanicaPocetna=" + stanicaPocetna + ", stanicaKrajnja=" + stanicaKrajnja + ", tipLinije=" + tipLinije + '}';
    }

}
