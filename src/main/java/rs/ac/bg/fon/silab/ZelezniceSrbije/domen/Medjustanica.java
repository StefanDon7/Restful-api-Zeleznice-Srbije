package rs.ac.bg.fon.silab.ZelezniceSrbije.domen;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.compositeKey.MedjustanicaCompositeKey;

@Entity
@Table(name = "medjustanica")
public class Medjustanica {

	
	@EmbeddedId
	MedjustanicaCompositeKey key;

	
	@ManyToOne
	@JoinColumn(name = "linijaid", insertable = false, updatable = false)
	private Linija linija;
	
	@ManyToOne
	@JoinColumn(name = "stanicaid", insertable = false, updatable = false)
	private Stanica stanica;
	
	@Column(name="rednibroj")
	private int redniBroj;
	
	public Medjustanica() {

	}

	public Medjustanica(MedjustanicaCompositeKey key, Linija linija, Stanica stanica, int redniBroj) {
		super();
		this.key = key;
		this.linija = linija;
		this.stanica = stanica;
		this.redniBroj = redniBroj;
	}

	public MedjustanicaCompositeKey getKey() {
		return key;
	}

	public void setKey(MedjustanicaCompositeKey key) {
		this.key = key;
	}

	public Linija getLinija() {
		return linija;
	}

	public void setLinija(Linija linija) {
		this.linija = linija;
		if(this.key==null) {
			this.key=new MedjustanicaCompositeKey();
		}
		this.key.setLinijaID(linija.getLinijaID());
	}

	public Stanica getStanica() {
		return stanica;
	}

	public void setStanica(Stanica stanica) {
		this.stanica = stanica;
		if(this.key==null) {
			this.key=new MedjustanicaCompositeKey();
		}
		this.key.setStanicaID(stanica.getStanicaID());
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	@Override
	public String toString() {
		return "Medjustanica [key=" + key + ", linija=" + linija + ", stanica=" + stanica + ", redniBroj=" + redniBroj
				+ "]";
	}
	
	
}
