package objects;

public class Nutzer implements Comparable<Nutzer>{
	
	private String username;
	private String password;
	private String nachname;
	private String vorname;
	private String gruppe;
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setNutzerInfo(String username, String password, String nachname, String vorname, String gruppe){
		this.username = username;
		this.password = password;
		this.nachname = nachname;
		this.vorname = vorname;
		this.gruppe = gruppe;
	}
	
	public String[] getNutzerInfo(){
		String[] userdata = new String[4];
		userdata[0] = this.username;
		userdata[1] = this.nachname;
		userdata[2] = this.vorname;
		userdata[3] = this.gruppe;
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

	@Override
	public int compareTo(Nutzer o) {
		return 0;
	}

}
