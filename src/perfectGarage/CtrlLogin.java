package perfectGarage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
				//FrmAdmin frmAdmin = new FrmAdmin();
				//frmAdmin.showFrame(true);
			}
			else if(this.txtUser.getText().equals("Service")){
				this.dialog.setVisible(false);				
				//FrmService frmService = new FrmService();
				//frmService.showFrame(true);
			}
			else{
				System.exit(0);
			}
			
		}
	}

}
