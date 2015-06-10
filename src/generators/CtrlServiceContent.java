package generators;

/**
 * 
 * @author treichert
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CtrlServiceContent implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("Neuer Kunde")) {
			JOptionPane.showMessageDialog(null,
				    "This function is under construction!",
				    "Meldung",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		else if (event.getActionCommand().equals("Kunde editieren")) {
			JOptionPane.showMessageDialog(null,
				    "This function is under construction!",
				    "Meldung",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		else if (event.getActionCommand().equals("Kunde löschen")) {
			JOptionPane.showMessageDialog(null,
				    "This function is under construction!",
				    "Meldung",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		else if (event.getActionCommand().equals("Kunde suchen")) {
			JOptionPane.showMessageDialog(null,
				    "This function is under construction!",
				    "Meldung",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
}
