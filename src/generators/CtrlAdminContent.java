package generators;

/**
 * @author treichert
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import objects.Nutzer;
import dialogs.DlgNutzer;

public class CtrlAdminContent implements ActionListener {
	
	JTable tableUsers;
	Nutzer user;
	
	public CtrlAdminContent(JTable tableUsers, Nutzer user){
		this.tableUsers = tableUsers;
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
			}
			else if(eingabe == 1){
				System.out.println("Nicht löschen");
			}
		}
		else if (event.getActionCommand().equals("Benutzer deaktivieren")) {
			System.out.println("Deaktiviern");
		}
	}

}
