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
		
		Nutzer user = new Nutzer("mrothe", "1234", "rothe", "martin", "Admin");
		
		if (event.getActionCommand().equals("Abbrechen")) {
			System.exit(0);
		}
		else if (event.getActionCommand().equals("Anmelden")) {
			
			if(this.txtUser.getText().equals("Admin")){
				user.setNutzerInfo("Admin", "", "", "", "Admin");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Service")){
				user.setNutzerInfo("Service", "", "", "", "Service");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Meister")){
				user.setNutzerInfo("Meister", "", "", "", "Meister");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Werkstatt")){
				user.setNutzerInfo("Werkstatt", "", "", "", "Werkstatt");
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
				JOptionPane.showMessageDialog(null,
					    "Der Benutzer konnte nicht angemeldet werden",
					    "Anmeldung fehlgeschlagen",
					    JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

}
