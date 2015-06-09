package objects;

/**
 * @author mrothe
 *
 */

public class Fahrzeug {
	
    private String fin;
    private int kundennr;
    private String hersteller;
    private String modell;
    private String farbe;
    
    /**
     * Optional kann auch ein Kundenname für ein Fahrzeug gesetzt werden
     */
    
    private String kundenname;
    
    public Fahrzeug(int kundennr, String fin, String hersteller, String modell, String farbe){
    	this.kundennr = kundennr;
    	this.fin = fin;
    	this.hersteller = hersteller;
    	this.modell = modell;
    	this.farbe = farbe;
    }
    
    public String[] getFahrzeugInfo(){
		String[] cardata = new String[4];
		cardata[0] = ""+this.kundennr;
		cardata[1] = ""+this.fin;
		cardata[2] = this.hersteller;
		cardata[3] = this.modell;
		cardata[4] = this.farbe;
		
		return cardata;
	}
    
    public String getFIN(){
    	return this.fin;
    }
    
    public int getKundenNr(){
    	return this.kundennr;
    }
        
    public String getHersteller(){
    	return this.hersteller;
    }
    
    public String getModell(){
    	return this.modell;
    }
    
    public String getFarbe(){
    	return this.farbe;
    }

	public void setFin(String fin) {
		this.fin = fin;
	}

	public void setKundennr(int kundennr) {
		this.kundennr = kundennr;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public void setKundenname(String kundenname) {
		this.kundenname = kundenname;
	}

	public String getKundenname() {
		return kundenname;
	}
    
    
}
