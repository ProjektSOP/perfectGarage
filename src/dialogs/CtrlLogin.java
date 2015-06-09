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
	
	private JDialog dialog;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private Boolean login = false;
	
	
	public CtrlLogin(JDialog dialog, JTextField txtUser, JPasswordField txtPassword){
		this.dialog = dialog;
		this.txtUser = txtUser;
		this.txtPassword = txtPassword;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		// Liste der Benutzer erzeugen
		ArrayList<Nutzer> users = DAONutzer.returnAllNutzer();
		
		
		// Login auswerten
		if (event.getActionCommand().equals("Abbrechen")) {
			System.exit(0);
		}
		else if (event.getActionCommand().equals("Anmelden")) {
			
			/*
			 * 
			 * ACHTUNG!!!
			 * Diese Testuser bei Fertigstellung wieder l�schen
			 * 
			 * 
			 */
			
			
			
			if(this.txtUser.getText().equals("Admin")){
				users.get(0).setNutzerInfo("Admin", "", "", "", "Admin", "Aktiviert");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Service")){
				users.get(0).setNutzerInfo("Service", "", "", "", "Service", "Aktiviert");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Meister")){
				users.get(0).setNutzerInfo("Meister", "", "", "", "Meister", "Aktiviert");
				this.dialog.setVisible(false);
				this.login = true;
			}
			else if(this.txtUser.getText().equals("Werkstatt")){
				users.get(0).setNutzerInfo("Werkstatt", "", "", "", "Werkstatt", "Aktiviert");
				this.dialog.setVisible(false);
				this.login = true;
			}
			
			
			
			
			@SuppressWarnings("deprecation")
			String password = this.txtPassword.getText();
			String username = this.txtUser.getText();
			
			int i = 0;
			int u = -1;
			
			// �berpr�fen ob Username und Password g�ltig
			while (i<=users.size()-1){
				if(users.get(i).getUsername().equals(username)){
					if(users.get(i).getPassword().equals(password)){
						if(users.get(i).getStatus().equals("Aktiviert")){
							this.dialog.setVisible(false);
							this.login = true;
							u=i;							
						}
					}
				}
				i++;
			}
			
			// Gruppenzugeh�rigkeit auswerten
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
