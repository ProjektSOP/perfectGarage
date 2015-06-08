package generators;

/**
 * @author treichert
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import objects.Nutzer;
import dialogs.DlgNutzer;

public class CtrlAdminContent implements ActionListener {
	
	Nutzer user;
	
	public CtrlAdminContent(Nutzer user){
		this.user = user;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		DlgNutzer dlgNutzer = new DlgNutzer();
		
		if (event.getActionCommand().equals("Neuer Benutzer")) {
			dlgNutzer.newNutzer(user);
		}
		else if (event.getActionCommand().equals("Benutzer editieren")) {
			dlgNutzer.editNutzer(user);
		}
		else if (event.getActionCommand().equals("Benutzer l�schen")) {
			// Erzeugen eines vorgefertigten Optionsdialoges.
			int eingabe = JOptionPane.showOptionDialog(null, "Sind Sie sich sicher, diesen Benutzer zu l�schen?", "Benutzer l�schen", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			
			if(eingabe == 0){
				System.out.println("L�schen");
			}
			else if(eingabe == 1){
				System.out.println("Nicht l�schen");
			}
		}
		else if (event.getActionCommand().equals("Benutzer deaktivieren")) {
			System.out.println("Deaktiviern");
		}
	}

}
