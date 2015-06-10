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
		this.users = DAONutzer.returnAllNutzerWithoutAdmin();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		DlgNutzer dlgNutzer = new DlgNutzer();
		this.i = this.tableUsers.getSelectedRow();
		
		if(this.i ==-1 ){
			this.i = 0;
		}
		
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
			
			if(!users.get(i).getStatus().equals("Geloescht am")){
				if(users.get(i).getStatus().equals("Aktiviert")){
					users.get(i).setStatus("Deaktiviert");
					DAONutzer.updateNutzer(users.get(i), users.get(i).getUsername());
				}else{
					users.get(i).setStatus("Aktiviert");
					DAONutzer.updateNutzer(users.get(i), users.get(i).getUsername());
				}
			}
		}
		else if (event.getActionCommand().equals("Benutzerpasswort zurücksetzen")) {
			users.get(i).setPassword("p@ssw0rd");
			DAONutzer.updateNutzerPw(users.get(i));
			JOptionPane.showMessageDialog(null,
				    "Das Passwort wurde auf   p@ssw0rd   zurückgesetzt!",
				    "Meldung",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		
		this.users = DAONutzer.returnAllNutzerWithoutAdmin();
		this.tableUsers.setModel( DAOJTable.fillTableUsers(users) );
		this.tableUsers.setRowSelectionInterval(i, i);
		
	}

}
