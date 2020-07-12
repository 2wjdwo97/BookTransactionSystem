package bookTransactionSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class View_Main extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JButton btnLogout;
	private JButton btnManageBook;
	private JButton btnManageUser;
	private JButton btnSearch;
	
	private JLabel lblUserName;
	
	private JTextField txtFSearchBar;
	
	public View_Main(JFrame frame) {		
		setBounds(0, 0, 800, 529);
		setLayout(null);
		
		JPanel subPanel = new JPanel();
		subPanel.setBounds(0, 140, 800, 360);
		subPanel.setBackground(new Color(250, 250, 250, 245));
		add(subPanel);
		subPanel.setLayout(null);	
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 800, 140);
		titlePanel.setOpaque(false);
		add(titlePanel);
		titlePanel.setLayout(null);
		
		btnManageBook = new JButton("등록 관리");
		btnManageBook.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 23));
		btnManageBook.setBackground(Color.WHITE);
		btnManageBook.setBorder(new LineBorder(new Color(220, 220, 220)));
		btnManageBook.setBounds(220, 65, 150, 150);
		subPanel.add(btnManageBook);
		
		btnManageUser = new JButton("유저 관리");
		btnManageUser.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 23));
		btnManageUser.setBackground(Color.WHITE);
		btnManageUser.setBorder(new LineBorder(new Color(220, 220, 220)));
		btnManageUser.setBounds(220, 65, 150, 150);
		subPanel.add(btnManageUser);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBorder(new LineBorder(new Color(220, 220, 220)));
		btnLogout.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 23));
		btnLogout.setBounds(420, 65, 150, 150);
		subPanel.add(btnLogout);
		
		txtFSearchBar = new JTextField();
		txtFSearchBar.setToolTipText("search book......");
		txtFSearchBar.setBounds(199, 70, 300, 27);
		titlePanel.add(txtFSearchBar);
		txtFSearchBar.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(80, 170, 255, 255));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBounds(500, 70, 94, 27);
		titlePanel.add(btnSearch);
		
		lblUserName = new JLabel("");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 12));
		lblUserName.setBounds(700, 10, 57, 15);
		titlePanel.add(lblUserName);
		
		JRadioButton rdbtnTitle = new JRadioButton("Title");
		rdbtnTitle.setActionCommand("Title");
		rdbtnTitle.setOpaque( false );
		rdbtnTitle.setContentAreaFilled(false);
		rdbtnTitle.setBorderPainted(false);
		rdbtnTitle.setSelected(true);
		rdbtnTitle.setForeground(Color.WHITE);
		buttonGroup.add(rdbtnTitle);
		rdbtnTitle.setBounds(199, 33, 49, 23);
		titlePanel.add(rdbtnTitle);
		
		JRadioButton rdbtnISBN = new JRadioButton("ISBN");
		rdbtnISBN.setActionCommand("ISBN");
		rdbtnISBN.setOpaque( false );
		rdbtnISBN.setContentAreaFilled(false);
		rdbtnISBN.setBorderPainted(false);
		rdbtnISBN.setForeground(Color.WHITE);
		buttonGroup.add(rdbtnISBN);
		rdbtnISBN.setBounds(252, 33, 57, 23);
		titlePanel.add(rdbtnISBN);
		
		JRadioButton rdbtnAuthor = new JRadioButton("Author");
		rdbtnAuthor.setActionCommand("Author");
		rdbtnAuthor.setOpaque( false );
		rdbtnAuthor.setContentAreaFilled(false);
		rdbtnAuthor.setBorderPainted(false);
		rdbtnAuthor.setForeground(Color.WHITE);
		buttonGroup.add(rdbtnAuthor);
		rdbtnAuthor.setBounds(313, 33, 63, 23);
		titlePanel.add(rdbtnAuthor);
		
		JRadioButton rdbtnSellerID = new JRadioButton("Seller ID");
		rdbtnSellerID.setActionCommand("ID");
		rdbtnSellerID.setOpaque( false );
		rdbtnSellerID.setContentAreaFilled(false);
		rdbtnSellerID.setBorderPainted(false);
		rdbtnSellerID.setForeground(Color.WHITE);
		buttonGroup.add(rdbtnSellerID);
		rdbtnSellerID.setBounds(380, 33, 73, 23);
		titlePanel.add(rdbtnSellerID);
		
		JPanel titlePanel_shadow = new JPanel();
		titlePanel_shadow.setBounds(0, 0, 800, 140);
		titlePanel_shadow.setBackground(new Color(0, 0, 0, 130));
		add(titlePanel_shadow);	
		
		JLabel lblBGI = new JLabel("");
		lblBGI.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/loginBGI.jpg")).getImage();
		lblBGI.setIcon(new ImageIcon(img));
		lblBGI.setBounds(0, 0, 800, 500);
		add(lblBGI);
		
		setVisible(true);
	}

	public void propertyChange(PropertyChangeEvent evt) {
		lblUserName.setText(((Login_Info)evt.getNewValue()).getUser().getName() + " 님");
		if(((Login_Info)evt.getNewValue()).getIsAdmin()) {
			btnManageBook.setVisible(false);
			btnManageUser.setVisible(true);
		}
		else {
			btnManageBook.setVisible(true);
			btnManageUser.setVisible(false);
		}
	}
	
	public String getSelectedRadio() {
		return buttonGroup.getSelection().getActionCommand();
	}
	public void setSearchBar(String newText) {
		txtFSearchBar.setText(newText);
	}
	public String getSearchBar() {
		return txtFSearchBar.getText();
	}
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public void addLogoutBtnListener(ActionListener e){
		btnLogout.addActionListener(e);
	}
	public void addManageBookBtnListener(ActionListener e){
		btnManageBook.addActionListener(e);
	}
	public void addManageUserBtnListener(ActionListener e){
		btnManageUser.addActionListener(e);
	}
	public void addSearchBtnListener(ActionListener e){
		btnSearch.addActionListener(e);
	}
}
