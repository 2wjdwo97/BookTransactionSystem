package bookTransactionSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View_Registration extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnRegister;
	private JButton btnBack;
	private JButton btnCheck;
	private JPasswordField passwordField;
	private JTextField txtFID;
	private JTextField txtFPhone;
	private JTextField txtFName;
	private JTextField txtFEmail;

	public View_Registration(JFrame frame) {
		setBounds(0, 0, 800, 500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(340, 50, 414, 400);
		panel.setBackground(new Color(0,0,0,150));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 38));
		lblRegister.setBounds(20, 22, 220, 48);
		panel.add(lblRegister);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(40, 90, 57, 15);
		lblID.setForeground(Color.WHITE);
		panel.add(lblID);
		
		JLabel lblPW = new JLabel("PW");
		lblPW.setBounds(40, 145, 57, 15);
		lblPW.setForeground(Color.WHITE);
		panel.add(lblPW);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(40, 200, 57, 15);
		lblName.setForeground(Color.WHITE);
		panel.add(lblName);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(40, 255, 57, 15);
		lblPhone.setForeground(Color.WHITE);
		panel.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(190, 255, 57, 15);
		lblEmail.setForeground(Color.WHITE);
		panel.add(lblEmail);
		
		txtFID = new JTextField();
		txtFID.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		txtFID.setBounds(40, 110, 120, 25);
		panel.add(txtFID);
		txtFID.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(40, 165, 120, 25);
		panel.add(passwordField);
		
		txtFName = new JTextField();
		txtFName.setBounds(40, 220, 120, 25);
		panel.add(txtFName);
		txtFName.setColumns(10);
		
		txtFPhone = new JTextField();
		txtFPhone.setBounds(40, 275, 120, 25);
		panel.add(txtFPhone);
		txtFPhone.setColumns(10);
		
		txtFEmail = new JTextField();
		txtFEmail.setBounds(190, 275, 120, 25);
		panel.add(txtFEmail);
		txtFEmail.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.BOLD, 16));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(80, 150, 255, 255));
		btnBack.setBounds(301, 336, 101, 40);
		panel.add(btnBack);
		
		btnCheck = new JButton("°Ó");
		btnCheck.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.BOLD, 15));
		btnCheck.setBackground(new Color(80, 150, 255, 255));
		btnCheck.setForeground(Color.WHITE);
		btnCheck.setBounds(190, 111, 55, 25);
		panel.add(btnCheck);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.BOLD, 15));
		btnRegister.setBackground(new Color(80, 150, 255, 255));
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBounds(188, 336, 101, 40);
		panel.add(btnRegister);
		
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
	public String getName() {
		return txtFName.getText();
	}
	public String getPhone() throws NumberFormatException {
		return txtFPhone.getText();
	}
	public String getEmail() {
		return txtFEmail.getText();
	}
	public void setID(String newText) {
		txtFID.setText(newText);
	}
	public void setPW(String newText) {
		passwordField.setText(newText);
	}
	public void setName(String newText) {
		txtFName.setText(newText);
	}
	public void setPhone(String newText){
		txtFPhone.setText(newText);
	}
	public void setEmail(String newText) {
		txtFEmail.setText(newText);
	}	
	public void addCheckBtnListener(ActionListener e){
		btnCheck.addActionListener(e);
	}
	public void addBackBtnListener(ActionListener e){
		btnBack.addActionListener(e);
	}
	public void addRegisterBtnListener(ActionListener e){
		btnRegister.addActionListener(e);
	}
}
