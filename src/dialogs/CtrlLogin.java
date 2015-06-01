package dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import objects.Nutzer;
import frames.FrmMain;

public class CtrlLogin implements ActionListener {
	
	JDialog message;
	JDialog dialog;
	
	JTextField txtUser;
	JPasswordField txtPassword;
	
	Boolean login = false;
	
	public CtrlLogin(JDialog dialog, JTextField txtUser, JPasswordField txtPassword){
		this.dialog = dialog;
		this.txtUser = txtUser;
		this.txtPassword = txtPassword;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		Nutzer user = new Nutzer();
		
		if (event.getActionCommand().equals("Abbrechen")) {
			System.exit(0);
		}
		else if (event.getActionCommand().equals("Anmelden")) {
			
			if(this.txtUser.getText().equals("Admin")){
				user.createNutzer("Admin", "", "", "", "Admin");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Service")){
				user.createNutzer("Service", "", "", "", "Service");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Meister")){
				user.createNutzer("Meister", "", "", "", "Meister");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Werkstatt")){
				user.createNutzer("Werkstatt", "", "", "", "Werkstatt");
				this.dialog.setVisible(false);
				this.login = true;
			}
			
			/*
			 * 
			 *	Hier überprüfen, ob Benutzername vorhanden und Passwort korrekt
			 *	Anschließnd Loginstatus setzen
			 *
			 */
			
			// Loginstatus auswerten
			if(login==true){
				if(user.getGruppe().equals("Admin")){
					FrmMain frmMain = new FrmMain("Admin");
					frmMain.showFrame(true);
				}
				else if(user.getGruppe().equals("Service")){
					FrmMain frmMain = new FrmMain("Service");
					frmMain.showFrame(true);
				}
				else if(user.getGruppe().equals("Meister")){
					FrmMain frmMain = new FrmMain("Meister");
					frmMain.showFrame(true);
				}
				else if(user.getGruppe().equals("Werkstatt")){
					FrmMain frmMain = new FrmMain("Werkstatt");
					frmMain.showFrame(true);
				}
			}else{
				JOptionPane.showMessageDialog(message,
					    "Der Benutzer konnte nicht angemeldet werden",
					    "Anmeldung fehlgeschlagen",
					    JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

}
