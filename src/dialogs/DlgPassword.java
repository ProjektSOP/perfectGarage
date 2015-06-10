package dialogs;

/**
 * @author treichert
 *
 */

import interfaces.DlgInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import objects.Nutzer;

public class DlgPassword implements DlgInterface {
	
	private JDialog dialog = new JDialog();
	private JPanel panel;
	private Nutzer user;
	

	public DlgPassword(Nutzer user){
		this.user = user;
		this.dialog.setTitle("Passwort ändern");
		
		this.createPanel(this.user);
		this.dialog.add(this.panel);
		
		this.dialog.pack();
		this.dialog.setLocationRelativeTo(null);
		this.dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.dialog.setModal(true);
	}
	
	private void createPanel(Nutzer user){
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createTitledBorder("Informationen zum Nutzer"));
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		
		JLabel lblOldPassword = new JLabel("Altes Passwort");
		lblOldPassword.setPreferredSize(new Dimension(80, 20));
		JPasswordField txtOldPassword = new JPasswordField();
		txtOldPassword.setPreferredSize(new Dimension(150, 20));
		panelCenter.add(lblOldPassword);
		panelCenter.add(txtOldPassword);
		
		JLabel lblNewPassword1 = new JLabel("Neues Passwort");
		lblNewPassword1.setPreferredSize(new Dimension(80, 20));
		JPasswordField txtNewPassword1 = new JPasswordField();
		txtNewPassword1.setPreferredSize(new Dimension(150, 20));
		panelCenter.add(lblNewPassword1);
		panelCenter.add(txtNewPassword1);
		
		JLabel lblOldPassword2 = new JLabel("Neues Passwort wiederholen");
		lblOldPassword2.setPreferredSize(new Dimension(80, 20));
		JPasswordField txtOldPassword2 = new JPasswordField();
		txtOldPassword2.setPreferredSize(new Dimension(150, 20));
		panelCenter.add(lblOldPassword2);
		panelCenter.add(txtOldPassword2);
		
		JButton btnChange = new JButton("Ändern");
		btnChange.addActionListener(new CtrlPassword(this.dialog, user, txtOldPassword, txtNewPassword1, txtOldPassword2));
		this.showDialog(false);
		
		JButton btnAbort = new JButton("Abbrechen");
		btnAbort.addActionListener(new CtrlPassword(this.dialog));
		this.showDialog(false);
		
		JPanel panelBottom = new JPanel();
		panelBottom.add(btnChange);
		panelBottom.add(btnAbort);
		
		this.panel = new JPanel();
		this.panel.setLayout(new BorderLayout());
		this.panel.add(panelCenter, BorderLayout.CENTER);
		this.panel.add(panelBottom, BorderLayout.SOUTH);
		
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
