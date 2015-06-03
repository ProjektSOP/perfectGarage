package dialogs;

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
import javax.swing.JTextField;

import objects.Nutzer;

public class DlgNutzer implements DlgInterface {
	
	JDialog dialog = new JDialog();
	JPanel panel;
	
	public DlgNutzer(){
		this.dialog.setTitle("DlgNutzer");
		
		this.createPanel("", "", "", "", "");
		this.dialog.add(this.panel);
		
		this.dialog.pack();
		this.dialog.setLocationRelativeTo(null);
		this.dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.dialog.setModal(true);
	}
	
	public void newNutzer() {
		this.dialog.setTitle("Neuen Nutzer anlegen");
		this.dialog.remove(this.panel);
		this.createPanel("", "", "", "", "");
		this.dialog.add(this.panel);
		this.showDialog(true);
	}
	
	public void editNutzer(Nutzer user) {
		this.dialog.setTitle("Nutzer bearbeiten");
		this.dialog.remove(this.panel);
		this.createPanel(user.getUsername(), "p@ssw0rd", user.getNachname(), user.getVorname(), user.getGruppe());
		this.dialog.add(this.panel);
		this.showDialog(true);
	}
	
	private void createPanel(String username, String password, String nachname, String vorname, String rolle){
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createTitledBorder("Informationen zum Nutzer"));
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setPreferredSize(new Dimension(80, 20));
		JTextField txtUsername = new JTextField();
		txtUsername.setPreferredSize(new Dimension(150, 20));
		txtUsername.setText(username);
		panelCenter.add(lblUsername);
		panelCenter.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setPreferredSize(new Dimension(80, 20));
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setPreferredSize(new Dimension(150, 20));
		txtPassword.setText(password);
		panelCenter.add(lblPassword);
		panelCenter.add(txtPassword);
		
		JLabel lblNachname = new JLabel("Name");
		lblNachname.setPreferredSize(new Dimension(80, 20));
		JTextField txtNachname = new JTextField();
		txtNachname.setPreferredSize(new Dimension(150, 20));
		txtNachname.setText(nachname);
		panelCenter.add(lblNachname);
		panelCenter.add(txtNachname);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setPreferredSize(new Dimension(80, 20));
		JTextField txtVorname = new JTextField();
		txtVorname.setPreferredSize(new Dimension(150, 20));
		txtVorname.setText(vorname);
		panelCenter.add(lblVorname);
		panelCenter.add(txtVorname);
		
		JLabel lblGruppe = new JLabel("Nutzerrolle");
		lblGruppe.setPreferredSize(new Dimension(80, 20));
		JTextField txtGruppe = new JTextField();
		txtGruppe.setPreferredSize(new Dimension(150, 20));
		txtGruppe.setText(rolle);
		panelCenter.add(lblGruppe);
		panelCenter.add(txtGruppe);
				
		JButton btnSave = new JButton("Speichern");
		btnSave.addActionListener(new CtrlNutzer(this.dialog));
		
		JButton btnAbort = new JButton("Abbrechen");
		btnAbort.addActionListener(new CtrlNutzer(this.dialog));
		
		JPanel panelBottom = new JPanel();
		panelBottom.add(btnSave);
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
