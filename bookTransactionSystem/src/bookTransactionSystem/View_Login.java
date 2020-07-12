package bookTransactionSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View_Login extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnLogin;
	private JButton btnRegister;
	
	private JTextField txtFID;
	private JPasswordField passwordField;


	public View_Login(JFrame frame) {
		setBounds(0, 0, 800, 500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(250, 50, 300, 400);
		panel.setBackground(new Color(0,0,0,150));
		panel.setLayout(null);
		add(panel);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.BOLD, 16));
		btnLogin.setBackground(new Color(80, 150, 255, 255));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(40, 220, 220, 40);
		panel.add(btnLogin);
		
		btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(80, 150, 255, 255));
		btnRegister.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.BOLD, 16));
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBounds(40, 320, 220, 40);
		panel.add(btnRegister);
		
		txtFID = new JTextField();
		txtFID.setBounds(40, 120, 220, 40);
		txtFID.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		panel.add(txtFID);
		txtFID.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(40, 170, 220, 40);
		panel.add(passwordField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 38));
		lblLogin.setBounds(40, 22, 220, 48);
		panel.add(lblLogin);
		
		JLabel lblBGI = new JLabel("");
		lblBGI.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/loginBGI.jpg")).getImage();
		lblBGI.setIcon(new ImageIcon(img));
		lblBGI.setBounds(0, 0, 800, 500);
		add(lblBGI);
		
		setVisible(true);
	}
	
	public String getID() {
		return txtFID.getText();
	}
	public char[] getPW() {
		return passwordField.getPassword();
	}
	
	public void setID(String newText) {
		txtFID.setText(newText);
	}
	public void setPW(String newText) {
		passwordField.setText(newText);
	}
	
	public void addLoginBtnListener(ActionListener e){
		btnLogin.addActionListener(e);
	}
	public void addRegisterBtnListener(ActionListener e){
		btnRegister.addActionListener(e);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}
}
