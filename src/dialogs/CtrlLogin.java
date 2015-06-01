package dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import frames.FrmMain;

public class CtrlLogin implements ActionListener {
	
	JDialog dialog;
	JTextField txtUser;
	JPasswordField txtPassword;
	
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
				FrmMain frmMain = new FrmMain();
				frmMain.showFrame(true);
			}
			else{
				System.exit(0);
			}
			
		}
	}

}
