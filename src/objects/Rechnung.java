/**
 * @author mrothe
 */

package objects;

import java.sql.Date;

public class Rechnung {

	public Rechnung(int rechnungsnr, Date rechnungsdatum, Date zahltag,
			String rechnungsstatus) {
		
		this.rechnungsnr = rechnungsnr;
		this.rechnungsdatum = rechnungsdatum;
		this.zahltag = zahltag;
		this.rechnungsstatus = rechnungsstatus;
	}

	public int getRechnungsnr() {
		return rechnungsnr;
	}

	public void setRechnungsnr(int rechnungsnr) {
		this.rechnungsnr = rechnungsnr;
	}

	public Date getRechnungsdatum() {
		return rechnungsdatum;
	}

	public void setRechnungsdatum(Date rechnungsdatum) {
		this.rechnungsdatum = rechnungsdatum;
	}

	public Date getZahltag() {
		return zahltag;
	}

	public void setZahltag(Date zahltag) {
		this.zahltag = zahltag;
	}

	public String getRechnungsstatus() {
		return rechnungsstatus;
	}

	public void setRechnungsstatus(String rechnungsstatus) {
		this.rechnungsstatus = rechnungsstatus;
	}

	private int rechnungsnr;
	private Date rechnungsdatum;
	private Date zahltag;
	private String rechnungsstatus;

	public String[] getRechnungsInfo() {
		
		/**
		 * @return Gibt ein StringArray mit allen Rechnungsinfos zurück
		 */
		
		String[] rechnungsdata = new String[4];
		rechnungsdata[0] = "" + this.rechnungsnr;
		rechnungsdata[1] = "" + this.rechnungsdatum;
		rechnungsdata[2] = "" + this.zahltag;
		rechnungsdata[3] = rechnungsstatus;
		return rechnungsdata;

	}

}
