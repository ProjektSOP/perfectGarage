package dialogs;

/**
 * @author treichert
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.DAOJTable;
import DAO.DAONutzer;
import objects.Nutzer;

public class CtrlNutzer implements ActionListener {

	JTable tableUsers;
	JDialog dialog;
	Nutzer user;
	
	JTextField username;
	JTextField nachname;
	JTextField vorname;
	JTextField gruppe;
	
	public CtrlNutzer(JTable tableUsers, JDialog dialog) {
		this.tableUsers = tableUsers;
		this.dialog = dialog;
	}
	
	public CtrlNutzer(JTable tableUsers, JDialog dialog, Nutzer user, JTextField username, JTextField nachname, JTextField vorname, JTextField gruppe){
		this.tableUsers = tableUsers;
		this.dialog = dialog;
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
			
			String oldUsername = this.user.getUsername();
			this.user.setUsername(this.username.getText());
			this.user.setNachname(this.nachname.getText());
			this.user.setVorname(this.vorname.getText());
			this.user.setGruppe(this.gruppe.getText());
			this.dialog.setVisible(false);
			
			if(this.dialog.getTitle().equals("Neuen Nutzer anlegen")){
				System.out.println("Neuen Nutzer anlegen:" + this.user.getUsername()+" "+user.getNachname()+" "+user.getVorname()+" "+user.getGruppe());
			}
			else if(this.dialog.getTitle().equals("Nutzer bearbeiten")){
				boolean done = new DAONutzer().updateNutzer(user, oldUsername);
				if(done){
					
				}
			}
			
			DAONutzer daoNutzer = new DAONutzer();
			ArrayList<Nutzer> users = daoNutzer.returnAllNutzerWithoutAdmin();
			
			
			this.tableUsers.setModel( DAOJTable.fillTableUsers( users) );
			
		}
		
	}

}
