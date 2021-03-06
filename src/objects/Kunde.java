package objects;

import java.util.Date;

public class Kunde {
	private int kundennr;
	private String nachname;
	private String vorname;
	private String strasse;
	private int plz;
	private String ort;
	private Date kundeseit;
	private String telefon;
	private String telefax;
	private String handy;
	private String email;
	
	public Kunde(int kundennr, String nachname, String vorname, String strasse,
			int plz, String ort, Date kundeseit, String telefon, String telefax,
			String handy, String email) {
		
		this.kundennr = kundennr;
		this.nachname = nachname;
		this.vorname = vorname;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.kundeseit = kundeseit;
		this.telefon = telefon;
		this.telefax = telefax;
		this.handy = handy;
		this.email = email;
	}
	
	public String[] getKundeInfo(){
		String[] customerdata = new String[11];
		customerdata[0] = "" + this.kundennr;
		customerdata[1] = this.nachname;
		customerdata[2] = this.vorname;
		customerdata[3] = this.strasse;
		customerdata[4] = "" + this.plz;
		customerdata[5] = this.ort;
		customerdata[6] = "" + this.kundeseit;
		customerdata[7] = this.telefon;
		customerdata[8] = this.telefax;
		customerdata[9] = this.handy;
		customerdata[10] = this.email;
		return customerdata;
	}

	public int getKundennr() {
		return kundennr;
	}

	public String getNachname() {
		return nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public String getStrasse() {
		return strasse;
	}

	public int getPlz() {
		return plz;
	}

	public String getOrt() {
		return ort;
	}

	public Date getKundeseit() {
		return kundeseit;
	}

	public String getTelefon() {
		return telefon;
	}

	public String getTelefax() {
		return telefax;
	}

	public String getHandy() {
		return handy;
	}

	public String getEmail() {
		return email;
	}
	
}
