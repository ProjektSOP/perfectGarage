package dialogs;

/**
 * @author treichert
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.DAONutzer;

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
		
		// DAO-Objekt erzeugen
		DAONutzer daoNutzer = new DAONutzer();

		// Liste der Benutzer erzeugen
		ArrayList<Nutzer> users = daoNutzer.returnAllNutzer();
		
		// Login auswerten
		if (event.getActionCommand().equals("Abbrechen")) {
			System.exit(0);
		}
		else if (event.getActionCommand().equals("Anmelden")) {
			
			/*
			 * 
			 * ACHTUNG!!!
			 * Diese Testuser bei Fertigstellung wieder löschen
			 * 
			 * 
			 */
						
			if(this.txtUser.getText().equals("Admin")){
				users.get(0).setNutzerInfo("Admin", "", "", "", "Admin","");
				this.dialog.setVisible(false);
				this.login = true;
				
		}
			else if(this.txtUser.getText().equals("Service")){
				users.get(0).setNutzerInfo("Service", "", "", "", "Service","");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Meister")){
				users.get(0).setNutzerInfo("Meister", "", "", "", "Meister","");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Werkstatt")){
				users.get(0).setNutzerInfo("Werkstatt", "", "", "", "Werkstatt","");
				this.dialog.setVisible(false);
				this.login = true;
			}
			
			
			
			@SuppressWarnings("deprecation")
			String password = this.txtPassword.getText();
			String username = this.txtUser.getText();
			
			int i = 0;
			int u = -1;
			
			// Überprüfen ob Username und Password gültig
			while (i<=users.size()-1){
				if(users.get(i).getUsername().equals(username)){
					if(users.get(i).getPassword().equals(password)){
						this.dialog.setVisible(false);
						this.login = true;
						u=i;
					}
				}
				i++;
			}
			
			// Gruppenzugehörigkeit auswerten
			if(login==true && u!=-1){
				if(users.get(u).getGruppe().equals("Admin")){
					FrmMain frmMain = new FrmMain("Admin");
					frmMain.showFrame(true);
				}
				else if(users.get(u).getGruppe().equals("Service")){
					FrmMain frmMain = new FrmMain("Service");
					frmMain.showFrame(true);
				}
				else if(users.get(u).getGruppe().equals("Meister")){
					FrmMain frmMain = new FrmMain("Meister");
					frmMain.showFrame(true);
				}
				else if(users.get(u).getGruppe().equals("Werkstatt")){
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
