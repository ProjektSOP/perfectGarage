package objects;

import java.sql.Date;


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
	
	public Kunde(){
		this.nachname = "";
		this.vorname = "";
		this.strasse = "";
		this.plz = 00000;
		this.ort = "";
		this.telefon = "";
		this.telefax = "";
		this.handy = "";
		this.email = "";
	}
	
	public Kunde(String nachname, String vorname, String strasse,
			int plz, String ort, String telefon, String telefax,
			String handy, String email) {
		
		this.nachname = nachname;
		this.vorname = vorname;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
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
	
	/**
	 * 
	 * Extra Methode, um bei Übernahme der Daten aus der Datenbank diese Daten in das Kundenobjekt zu schreiben
	 * Diese werden nicht im Konstruktor angelegt, um die Eindeutigkeit der Daten zu wahren!
	 */
	
	public void setKundennr(int kundennr) {
		this.kundennr = kundennr;
	}
	
	public void setKundeseit(Date kundeseit) {
		this.kundeseit = kundeseit;
	}
	
	
	/**
	 * 
	 * Updater der Kundendaten für das Verändern der Kundendaten
	 *
	 */
	
	public void updateNachname(String nachname) {
		this.nachname = nachname;
	}

	public void updateVorname(String vorname) {
		this.vorname = vorname;
	}

	public void updateStrasse(String strasse) {
		this.strasse = strasse;
	}

	public void updatePlz(int plz) {
		this.plz = plz;
	}

	public void updateOrt(String ort) {
		this.ort = ort;
	}

	public void updateTelefon(String telefon) {
		this.telefon = telefon;
	}

	public void updateTelefax(String telefax) {
		this.telefax = telefax;
	}

	public void updateHandy(String handy) {
		this.handy = handy;
	}

	public void updateEmail(String email) {
		this.email = email;
	}
	
}
	