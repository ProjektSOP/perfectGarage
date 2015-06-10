package dialogs;

/**
 * 
 * @author treichert
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import DAO.DAONutzer;
import objects.Nutzer;

public class CtrlPassword implements ActionListener {
	
	private JDialog dialog;
	private Nutzer user;
	
	private JPasswordField txtOldPassword;
	private JPasswordField txtNewPassword1;
	private JPasswordField txtNewPassword2;
	
	public CtrlPassword(JDialog dialog){
		this.dialog = dialog;
	}
	
	public CtrlPassword(JDialog dialog, Nutzer user, JPasswordField txtOldPassword, JPasswordField txtNewPassword1, JPasswordField txtNewPassword2){
		this.dialog = dialog;
		this.user = user;
		
		this.txtOldPassword = txtOldPassword;
		this.txtNewPassword1 = txtNewPassword1;
		this.txtNewPassword2 = txtNewPassword2;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent event) {
		// Login auswerten
		if (event.getActionCommand().equals("Abbrechen")) {
			this.dialog.show(false);
		}
		else if (event.getActionCommand().equals("Ändern")) {
					
			if(DAONutzer.pruefungPasswort(user.getUsername(), this.txtOldPassword.getText())){
				if(txtNewPassword1.getText().equals(txtNewPassword2.getText())){
					user.setPassword(this.txtNewPassword1.getText());
					DAONutzer.updateNutzerPw(user);
					this.dialog.show(false);
				}else{
					JOptionPane.showMessageDialog(null,
						    "Neues Passwort stimmt nicht mit der Wiederholung überein!",
						    "Meldung",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}else{
				JOptionPane.showMessageDialog(null,
					    "Das alte Passwort stimmt nicht mit dem aktuellen Passwort überein!",
					    "Meldung",
					    JOptionPane.ERROR_MESSAGE);
			}

		}
		
	}
	
	
	
}
