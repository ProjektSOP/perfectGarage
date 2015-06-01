package perfectGarage;

import interfaces.DlgInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DlgLogin implements DlgInterface {
	
	JDialog dialog = new JDialog();
	JPanel panel = new JPanel();
	
	public DlgLogin(){
		this.dialog.setTitle("Anmeldung");
		
		this.createPanel();
		this.dialog.add(this.panel);
		
		this.dialog.pack();
		this.dialog.setLocationRelativeTo(null);
		this.dialog.setModal(true);
	}
	
	private void createPanel(){
		// Logo
		JLabel lblLogo = new JLabel(new ImageIcon("project.jpg"));
		
		// User
		JLabel lblUser = new JLabel("Benutzer");
		lblUser.setPreferredSize(new Dimension(80, 20));
		
		JTextField txtUser = new JTextField();
		txtUser.setPreferredSize(new Dimension(150, 20));
		
		JPanel panelUser = new JPanel();
		panelUser.add(lblUser);
		panelUser.add(txtUser);
		
		// Password
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setPreferredSize(new Dimension(80, 20));
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setPreferredSize(new Dimension(150, 20));
		
		JPanel panelPassword = new JPanel();
		panelPassword.add(lblPassword);
		panelPassword.add(txtPassword);
		
		// Buttons
		JButton btnLogin = new JButton("Anmelden");
		btnLogin.addActionListener(new CtrlLogin(this.dialog, txtUser, txtPassword));
		JButton btnCancel = new JButton("Abbrechen");
		btnCancel.addActionListener(new CtrlLogin(this.dialog, txtUser, txtPassword));
		
		// Zusammenbau
		JPanel panelLogo = new JPanel();
		panelLogo.add(lblLogo);
		
		JPanel panelContent = new JPanel();
		panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
		panelContent.add(panelLogo);
		panelContent.add(panelUser);
		panelContent.add(panelPassword);
		
		JPanel panelButtons = new JPanel();
		panelButtons.add(btnLogin);
		panelButtons.add(btnCancel);
		
		this.panel.setLayout(new BorderLayout());
		this.panel.add(panelContent, BorderLayout.CENTER);
		this.panel.add(panelButtons, BorderLayout.SOUTH);
	}

	@Override
	public void showDialog(boolean b) {
		if(b==true){
			this.dialog.setVisible(true);
		}else if(b==false){
			this.dialog.setVisible(false);
		}
	}
	
}
