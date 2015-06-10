package generators;

/**
 * @author treichert
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import DAO.DAOJTable;
import DAO.DAONutzer;
import objects.Nutzer;
import dialogs.DlgNutzer;

public class CtrlAdminContent implements ActionListener {
	
	private JTable tableUsers;
	private ArrayList<Nutzer> users;
	private int i;
	
	
	public CtrlAdminContent(JTable tableUsers){
		this.tableUsers = tableUsers;
	}
	
	public CtrlAdminContent(JTable tableUsers, int i){
		this.tableUsers = tableUsers;
		this.i = i;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		DlgNutzer dlgNutzer = new DlgNutzer();
		this.users = DAONutzer.returnAllNutzerWithoutAdmin();
		this.tableUsers.setModel( DAOJTable.fillTableUsers(users) );
		
		if (event.getActionCommand().equals("Neuer Benutzer")) {
			dlgNutzer.newNutzer(tableUsers, new Nutzer());
		}
		else if (event.getActionCommand().equals("Benutzer editieren")) {
			dlgNutzer.editNutzer(tableUsers, users.get(i));
		}
		else if (event.getActionCommand().equals("Benutzer löschen")) {
			int eingabe = JOptionPane.showOptionDialog(null, "Sind Sie sich sicher, diesen Benutzer zu löschen?", "Benutzer löschen", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			
			if(eingabe == 0){
				DAONutzer.deleteNutzer(users.get(i));
			}
			else if(eingabe == 1){
				System.out.println("Nicht löschen");
			}
		}
		else if (event.getActionCommand().equals("Benutzerstatus ändern")) {
			if(users.get(i).getStatus().equals("Aktiviert")){
				DAONutzer.updateStatus(users.get(i), "Deaktiviert");
			}else{
				DAONutzer.updateStatus(users.get(i), "Aktiviert");
			}
		}
		
		this.users = DAONutzer.returnAllNutzerWithoutAdmin();
		this.tableUsers.setModel( DAOJTable.fillTableUsers(users) );
		
	}

}
