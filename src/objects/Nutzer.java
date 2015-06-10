package objects;

/**
 * 
 * @author treichert
 */

public class Nutzer implements Comparable<Nutzer>{
	
	private String username;
	private String password;
	private String nachname;
	private String vorname;
	private String gruppe;
	private String status;
	private String delete;
	
	
	public Nutzer(){
		this.username = "";
		this.password = "";
		this.nachname = "";
		this.vorname = "";
		this.gruppe = "";
		this.status = "";
		this.delete = "";
	}
	
	public Nutzer(String username, String password, String nachname,
			String vorname, String gruppe, String status, String delete) {
		
		this.username = username;
		this.password = password;
		this.nachname = nachname;
		this.vorname = vorname;
		this.gruppe = gruppe;
		this.status = status;
		this.delete = delete;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setNachname(String nachname){
		this.nachname = nachname;
	}
	
	public void setVorname(String vorname){
		this.vorname = vorname;
	}
	
	public void setGruppe(String gruppe){
		this.gruppe = gruppe;
	}

	public void setPassword(String password){
		this.password = password;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public void setNutzerInfo(String username, String password, String nachname, String vorname, String gruppe, String status){
		this.username = username;
		this.password = password;
		this.nachname = nachname;
		this.vorname = vorname;
		this.gruppe = gruppe;
		this.status = status;
	}
	
	public String[] getNutzerInfo(){
		String[] userdata = new String[6];
		userdata[0] = this.username;
		userdata[1] = this.nachname;
		userdata[2] = this.vorname;
		userdata[3] = this.gruppe;
		userdata[4] = this.status;
		userdata[5] = this.delete;
		
		return userdata;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getNachname(){
		return this.nachname;
	}
	
	public String getVorname(){
		return this.vorname;
	}
	
	public String getGruppe(){
		return this.gruppe;
		
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public String getDelete(){
		return this.status;
	}
	
	
	/**
	 * 	 Zum Update der Nutzerdaten
	 */
	/*
	public void updateUsername(String username) {
		this.username = username;
	}

	public void updateNachname(String nachname) {
		this.nachname = nachname;
	}

	public void updateVorname(String vorname) {
		this.vorname = vorname;
	}

	public void updateGruppe(String gruppe) {
		this.gruppe = gruppe;
	}
	
	public void updateStatus(String status) {
		this.status = status;
	}
	
	*/
	
	@Override
	public int compareTo(Nutzer o) {
		return 0;
	}
}
