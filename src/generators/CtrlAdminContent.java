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
	private Nutzer user;
	private ArrayList<Nutzer> users;
	
	public CtrlAdminContent(JTable tableUsers, Nutzer user){
		this.tableUsers = tableUsers;
		this.user = user;
	}
	
	public CtrlAdminContent(JTable tableUsers, ArrayList<Nutzer> users, Nutzer user){
		this.tableUsers = tableUsers;
		this.users = users;
		this.user = user;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		DlgNutzer dlgNutzer = new DlgNutzer();
		
		if (event.getActionCommand().equals("Neuer Benutzer")) {
			dlgNutzer.newNutzer(tableUsers, user);
		}
		else if (event.getActionCommand().equals("Benutzer editieren")) {
			dlgNutzer.editNutzer(tableUsers, user);
		}
		else if (event.getActionCommand().equals("Benutzer löschen")) {
			// Erzeugen eines vorgefertigten Optionsdialoges.
			int eingabe = JOptionPane.showOptionDialog(null, "Sind Sie sich sicher, diesen Benutzer zu löschen?", "Benutzer löschen", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			
			if(eingabe == 0){
				System.out.println("Löschen");
				DAONutzer.deleteNutzer(user);
				this.users = DAONutzer.returnAllNutzerWithoutAdmin();
				
				this.tableUsers.setModel( DAOJTable.fillTableUsers(users) );
			}
			else if(eingabe == 1){
				System.out.println("Nicht löschen");
			}
		}
		else if (event.getActionCommand().equals("Benutzerstatus ändern")) {
			System.out.println("Deaktiviern");
		}
		
	}

}
