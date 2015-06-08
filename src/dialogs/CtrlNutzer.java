package dialogs;

/**
 * @author treichert
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class CtrlNutzer implements ActionListener {

	JDialog dialog;
	
	public CtrlNutzer(JDialog dialog){
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("Abbrechen")) {
			this.dialog.setVisible(false);
		}
		
		else if (event.getActionCommand().equals("Speichern")) {
			this.dialog.setVisible(false);
			// Hier Aktion einfügen
		}
		
	}

}
