package objects;

import java.sql.Date;

/**
 * 
 * @author mrothe
 *
 */

public class Arbeitsteilauftrag {
	
	public Arbeitsteilauftrag(String ataBezeichnung, String kndLesbareForm,
			Date erstellungsdatum, String ataStatus, Date abnahmedatum,
			String fremdvergabe, String kosten, String ataPriorit�t) {
		
		this.ataBezeichnung = ataBezeichnung;
		this.kndLesbareForm = kndLesbareForm;
		this.erstellungsdatum = erstellungsdatum;
		this.ataStatus = ataStatus;
		this.abnahmedatum = abnahmedatum;
		this.fremdvergabe = fremdvergabe;
		this.kosten = kosten;
		this.ataPriorit�t = ataPriorit�t;
	}
	
	private int ataNummer;
	private String ataBezeichnung;
	private String kndLesbareForm;
	private Date erstellungsdatum;
	private String ataStatus;
	private Date abnahmedatum;
	private String fremdvergabe;
	private String kosten;
	private String ataPriorit�t;
	private int auftragsNr;
	
	
	
	public int getAtaNummer() {
		return ataNummer;
	}
	public void setAtaNummer(int ataNummer) {
		this.ataNummer = ataNummer;
	}
	public String getAtaBezeichnung() {
		return ataBezeichnung;
	}
	public void setAtaBezeichnung(String ataBezeichnung) {
		this.ataBezeichnung = ataBezeichnung;
	}
	public String getKndLesbareForm() {
		return kndLesbareForm;
	}
	public void setKndLesbareForm(String kndLesbareForm) {
		this.kndLesbareForm = kndLesbareForm;
	}
	public Date getErstellungsdatum() {
		return erstellungsdatum;
	}
	public void setErstellungsdatum(Date erstellungsdatum) {
		this.erstellungsdatum = erstellungsdatum;
	}
	public String getAtaStatus() {
		return ataStatus;
	}
	public void setAtaStatus(String ataStatus) {
		this.ataStatus = ataStatus;
	}
	public Date getAbnahmedatum() {
		return abnahmedatum;
	}
	public void setAbnahmedatum(Date abnahmedatum) {
		this.abnahmedatum = abnahmedatum;
	}
	public String getFremdvergabe() {
		return fremdvergabe;
	}
	public void setFremdvergabe(String fremdvergabe) {
		this.fremdvergabe = fremdvergabe;
	}
	public String getKosten() {
		return kosten;
	}
	public void setKosten(String kosten) {
		this.kosten = kosten;
	}
	public String getAtaPriorit�t() {
		return ataPriorit�t;
	}
	public void setAtaPriorit�t(String ataPriorit�t) {
		this.ataPriorit�t = ataPriorit�t;
	}
	public int getAuftragsNr() {
		return auftragsNr;
	}
	public void setAuftragsNr(int auftragsNr) {
		this.auftragsNr = auftragsNr;
	}
	
	
}
