package sp1;

public class elist {
	String enm = null;
	String email = null;
	String etitle = null;
	String econ = null;
	
	public elist(String data1, String data2, String data3, String data4) {
		this.enm = data1;
		this.email = data2;
		this.etitle = data3;
		this.econ = data4;
	}

	public String getEnm() {
		return enm;
	}
	public String getEmail() {
		return email;
	}
	public String getEtitle() {
		return etitle;
	}
	public String getEcon() {
		return econ;
	}
}
