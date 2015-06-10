package frames;

/**
 * @author treichert
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import mySQLConnector.MySQLConnection;
import objects.Nutzer;
import dialogs.DlgInfo;
import dialogs.DlgPassword;

public class CtrlMain implements ActionListener {
	
	private Nutzer user;
	
	public CtrlMain(){
		
	}
	
	public CtrlMain(JFrame frame, Nutzer user){
		this.user = user;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("Beenden")) {
			MySQLConnection.schliesseVerbindung();
			
			System.exit(0);
			
		}
		else if (event.getActionCommand().equals("Passwort ändern")) {
			DlgPassword dlgPwd = new DlgPassword(user);
			dlgPwd.showDialog(true);			
		}
		else if (event.getActionCommand().equals("Info")) {
			DlgInfo dlgInfo = new DlgInfo();
			dlgInfo.showDialog(true);
		}
		
	}

}
