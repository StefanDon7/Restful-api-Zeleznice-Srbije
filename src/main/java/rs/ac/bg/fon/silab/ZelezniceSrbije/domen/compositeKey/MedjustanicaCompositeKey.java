package rs.ac.bg.fon.silab.ZelezniceSrbije.domen.compositeKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MedjustanicaCompositeKey implements Serializable {

	private static final long serialVersionUID = 1234567L;

	@Column(name = "linijaid")
	private int linijaID;

	@Column(name = "stanicaID")
	private int stanicaID;
	
	public MedjustanicaCompositeKey() {

	}
	
	public MedjustanicaCompositeKey(int linijaID, int stanicaID) {
		this.linijaID = linijaID;
		this.stanicaID = stanicaID;
	}


	public int getLinijaID() {
		return linijaID;
	}

	public void setLinijaID(int linijaID) {
		this.linijaID = linijaID;
	}

	public int getStanicaID() {
		return stanicaID;
	}

	public void setStanicaID(int stanicaID) {
		this.stanicaID = stanicaID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + linijaID;
		result = prime * result + stanicaID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedjustanicaCompositeKey other = (MedjustanicaCompositeKey) obj;
		if (linijaID != other.linijaID)
			return false;
		if (stanicaID != other.stanicaID)
			return false;
		return true;
	}
	
	
	
	
}
