package objects;

public class Nutzer implements Comparable<Nutzer>{
	
	private String username;
	private String password;
	private String nachname;
	private String vorname;
	private String gruppe;
	private String status;
	
		
	public Nutzer(String username, String password, String nachname,
			String vorname, String gruppe, String status) {
		
		this.username = username;
		this.password = password;
		this.nachname = nachname;
		this.vorname = vorname;
		this.gruppe = gruppe;
		this.status = status;
	}
	
	public void setNutzerInfo(String username, String password, String nachname, String vorname, String gruppe, String status){
		this.username = username;
		this.password = password;
		this.nachname = nachname;
		this.vorname = vorname;
		this.gruppe = gruppe;
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

	public String[] getNutzerInfo(){
		String[] userdata = new String[5];
		userdata[0] = this.username;
		userdata[1] = this.nachname;
		userdata[2] = this.vorname;
		userdata[3] = this.gruppe;
		userdata[4] = this.status;
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

	@Override
	public int compareTo(Nutzer o) {
		return 0;
	}

}
