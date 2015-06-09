package objects;

/**
 * @author treichert
 *
 */

public class Fahrzeug {
	
    private int fin;
    private String hersteller;
    private String modell;
    private String farbe;
    
    public Fahrzeug(int fin, String hersteller, String modell, String farbe){
    	this.fin = fin;
    	this.hersteller = hersteller;
    	this.modell = modell;
    	this.farbe = farbe;
    }
    
    public String[] getFahrzeugInfo(){
		String[] cardata = new String[4];
		cardata[0] = ""+this.fin;
		cardata[1] = this.hersteller;
		cardata[2] = this.modell;
		cardata[3] = this.farbe;
		
		return cardata;
	}
    
    public int getFIN(){
    	return this.fin;
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
}
