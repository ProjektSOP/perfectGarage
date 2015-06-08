package DAO;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import objects.Nutzer;

public class DAOJTable {
	
	public JTable createTableUsers(ArrayList<Nutzer> users){
		
		// DefaultTableModel erzeugen
        DefaultTableModel modelUsers = new DefaultTableModel();
        modelUsers.addColumn("Username");
        modelUsers.addColumn("Name");
        modelUsers.addColumn("Vorname");
        modelUsers.addColumn("Nutzerrolle");
        modelUsers.addColumn("Status");
		
		if(users.size() >= 1){
			modelUsers = createUserTable(users, modelUsers);			
		}
        
		// JTable erzeugen 
		JTable tableUsers = new JTable(modelUsers) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int x, int y) {
                return false;
            }
        };
        
        return tableUsers;
	}
	
	private DefaultTableModel createUserTable(ArrayList<Nutzer> users, DefaultTableModel modelUsers){
		
		for( Nutzer n : users ){
			modelUsers.addRow(n.getNutzerInfo());
        }
		
		return modelUsers;
	}
	
}
