package dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import frames.FrmMain;

public class CtrlLogin implements ActionListener {
	
	JDialog message;
	JDialog dialog;
	JTextField txtUser;
	JPasswordField txtPassword;
	String strGroup;
	Boolean bLogin = false;
	
	public CtrlLogin(JDialog dialog, JTextField txtUser, JPasswordField txtPassword){
		this.dialog = dialog;
		this.txtUser = txtUser;
		this.txtPassword = txtPassword;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Abbrechen")) {
			System.exit(0);
		}
		
		else if (event.getActionCommand().equals("Anmelden")) {
			
			if(this.txtUser.getText().equals("Admin")){
				this.dialog.setVisible(false);
				this.strGroup = "Admin";
				this.bLogin = true;
			}
			else if(this.txtUser.getText().equals("Service")){
				this.dialog.setVisible(false);
				this.strGroup = "Service";
				this.bLogin = true;
			}
			else if(this.txtUser.getText().equals("Meister")){
				this.dialog.setVisible(false);
				this.strGroup = "Meister";
				this.bLogin = true;
			}
			else if(this.txtUser.getText().equals("Werkstatt")){
				this.dialog.setVisible(false);
				this.strGroup = "Werkstatt";
				this.bLogin = true;
			}
			
			/*
			 * 
			 *	Hier überprüfen, ob Benutzername vorhanden und Passwort korrekt
			 *	Anschließnd Loginstatus setzen
			 *
			 */
			
			// Loginstatus auswerten
			if(bLogin==true){
				if(this.strGroup.equals("Admin")){
					FrmMain frmMain = new FrmMain("Admin");
					frmMain.showFrame(true);
				}
				else if(this.strGroup.equals("Service")){
					FrmMain frmMain = new FrmMain("Service");
					frmMain.showFrame(true);
				}
				else if(this.strGroup.equals("Meister")){
					FrmMain frmMain = new FrmMain("Meister");
					frmMain.showFrame(true);
				}
				else if(this.strGroup.equals("Werkstatt")){
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
