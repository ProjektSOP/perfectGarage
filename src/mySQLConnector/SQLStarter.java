package mySQLConnector;

import DAO.DAO_Nutzer;

public class SQLStarter {
	
	public static void main(String[] args)  {
	    // Abfrage aller vorhandenen Namen
	    
		new DAO_Nutzer().returnAllNutzer();
		
		
		
	 
/**
	    // Neuen Datensatz hinzufügen
	    MySQLConnection.insertName("Simon", "Michel");
	 
	    // Datensatz mit der ID 1 ändern
	    MySQLConnection.updateName("Peter", "Pan", 1);
	  }
	}
*/
	  }
}
