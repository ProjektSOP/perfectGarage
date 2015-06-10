package dialogs;

/**
 * @author treichert
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.DAOJTable;
import DAO.DAONutzer;
import objects.Nutzer;

public class CtrlNutzer implements ActionListener {

	private JDialog dialog;
	private JTable tableUsers;
	private ArrayList<Nutzer> users;
	private Nutzer user;
	
	private JTextField username;
	private JTextField nachname;
	private JTextField vorname;
	private JComboBox<String> gruppe;
	
	public CtrlNutzer(JTable tableUsers, JDialog dialog) {
		this.dialog = dialog;
		this.tableUsers = tableUsers;
	}
	
	public CtrlNutzer(JTable tableUsers, JDialog dialog, Nutzer user, JTextField username, JTextField nachname, JTextField vorname, JComboBox<String> gruppe){
		this.dialog = dialog;
		this.tableUsers = tableUsers;
		this.user = user;
				
		this.username = username;
		this.nachname = nachname;
		this.vorname = vorname;
		this.gruppe = gruppe;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("Abbrechen")) {
			this.dialog.setVisible(false);
		}
		
		else if (event.getActionCommand().equals("Speichern")) {
			
			//String oldUsername = this.user.getUsername();
			this.user.setUsername(this.username.getText());
			this.user.setNachname(this.nachname.getText());
			this.user.setVorname(this.vorname.getText());
			this.user.setGruppe(gruppe.getSelectedItem().toString());
			this.dialog.setVisible(false);
			
			if(this.dialog.getTitle().equals("Neuen Nutzer anlegen")){
				this.user.setPassword("p@ssw0rd");
				this.user.setStatus("Aktiviert");
				DAONutzer.insertNutzer(user);
			}
			else if(this.dialog.getTitle().equals("Nutzer bearbeiten")){
				//DAONutzer.updateNutzer(user, oldUsername);
				DAONutzer.updateNutzerRolle(user);
			}
			
			this.users = DAONutzer.returnAllNutzerWithoutAdmin();
			this.tableUsers.setModel( DAOJTable.fillTableUsers(this.users) );
						
		}
		
	}

}
