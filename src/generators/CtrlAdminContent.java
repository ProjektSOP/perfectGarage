package generators;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import objects.Nutzer;
import dialogs.DlgNutzer;

public class CtrlAdminContent implements ActionListener {

	Nutzer user;
	
	public CtrlAdminContent(Nutzer user){
		this.user = user;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Neuer Benutzer")) {
			DlgNutzer dlgNutzer = new DlgNutzer();
			dlgNutzer.showDialog(true);
		}
		else if (event.getActionCommand().equals("Benutzer editieren")) {
			DlgNutzer dlgNutzer = new DlgNutzer();
			dlgNutzer.editNutzer(user);
		}
	}

}
