package bookTransactionSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class View_ManageUser extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnPrevious;
	
	private JLabel lblUserName;
	
	private ArrayList<JPanel> list_panelBookInfo;
	private ArrayList<JButton> list_btnDelete;
	private ArrayList<JButton> list_btnChangeUserStatus;
	
	private JPanel panelLeft;
	private JPanel panelList;
	
	View_ManageUser(JFrame frame){
		list_panelBookInfo = new ArrayList<JPanel>();
		list_btnChangeUserStatus = new ArrayList<JButton>();
		list_btnDelete = new ArrayList<JButton>();
		
		setBounds(0, 0, 800, 500);
		setLayout(null);
	
		panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 580, 490);
		panelLeft.setBackground(new Color(250, 250, 250, 245));
		add(panelLeft);
		panelLeft.setLayout(null);
		
		panelList = new JPanel();
		panelList.setBounds(0, 70, 580, 400);
		panelList.setBackground(new Color(250, 250, 250, 0));
		panelLeft.add(panelList);
		panelList.setLayout(null);
		
		JLabel lblTitle = new JLabel("À¯Àú °ü¸®");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("210 ¸Ç¹ßÀÇÃ»Ãá B", Font.PLAIN, 38));
		lblTitle.setBounds(12, 10, 230, 60);
		panelLeft.add(lblTitle);
		
		btnPrevious = new JButton("\u25C0");
		btnPrevious.setBackground(new Color(255, 255, 255));
		btnPrevious.setBorder(new LineBorder(new Color(220, 220, 220)));
		btnPrevious.setBounds(391, 420, 45, 41);
		panelLeft.add(btnPrevious);
		
		btnNext = new JButton("\u25B6");
		btnNext.setBackground(new Color(255, 255, 255));
		btnNext.setBorder(new LineBorder(new Color(220, 220, 220)));
		btnNext.setBounds(513, 420, 45, 41);
		panelLeft.add(btnNext);
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(580, 0, 214, 490);
		panelRight.setOpaque(false);
		add(panelRight);
		panelRight.setLayout(null);
		
		JPanel panel_shadow = new JPanel();
		panel_shadow.setBounds(580, 0, 214, 490);
		panel_shadow.setBackground(new Color(0, 0, 0, 130));
		add(panel_shadow);
		
		btnBack = new JButton();
		btnBack.setOpaque( false );
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		Image imgBack = new ImageIcon(this.getClass().getResource("/undo.png")).getImage();
		btnBack.setIcon(new ImageIcon(imgBack));
		btnBack.setBounds(115, 390, 64, 64);
		panelRight.add(btnBack);
		
		lblUserName = new JLabel("");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("210 ¸Ç¹ßÀÇÃ»Ãá L", Font.PLAIN, 12));
		lblUserName.setBounds(120, 10, 57, 15);
		panelRight.add(lblUserName);
		
		JLabel lblBGI = new JLabel("");
		lblBGI.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/loginBGI.jpg")).getImage();
		lblBGI.setIcon(new ImageIcon(img));
		lblBGI.setBounds(0, 0, 800, 500);
		add(lblBGI);
		
		setVisible(true);
	}

	@SuppressWarnings("unchecked")
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("login")) {
			lblUserName.setText(((Login_Info)evt.getNewValue()).getUser().getName() + " ´Ô");
		}
		else if(evt.getPropertyName().equals("userList_partial")){
			makeUserList(((ArrayList<User>)evt.getNewValue()));
		}
	}
	private void makeUserList(ArrayList<User> userList) {
		panelList.removeAll();
		list_panelBookInfo.clear();
		list_btnChangeUserStatus.clear();
		list_btnDelete.clear();
		for(User user : userList) {
			JPanel innerPanel;
			JButton btnDelete;
			JButton btnChangeUserStatus;
			
			String ID = user.getID();
			String status = user.getStatus()==true ? "Activated" : "Deactivated";
			
			JLabel lblID = new JLabel(ID);
			JLabel lblStatus = new JLabel(status);
			
			btnDelete = new JButton();
			btnChangeUserStatus = new JButton();
			innerPanel = new JPanel();
			
			innerPanel.setBackground(new Color(255, 255, 255));
			innerPanel.setBounds(20, 35 * list_panelBookInfo.size(), 540, 30);
			innerPanel.setLayout(null);

			lblID.setBounds(5, 5, 120, 20);
			lblID.setVerticalAlignment(SwingConstants.CENTER);
			
			lblStatus.setBounds(100, 5, 120, 20);
			lblStatus.setVerticalAlignment(SwingConstants.CENTER);
			
			innerPanel.add(lblStatus);
			innerPanel.add(lblID);
			
			btnChangeUserStatus.setBackground(new Color(255, 255, 255));
			btnChangeUserStatus.setBorder(null);
			Image img = new ImageIcon(this.getClass().getResource("/change.png")).getImage();
			btnChangeUserStatus.setIcon(new ImageIcon(img));
			btnChangeUserStatus.setBounds(420, 3, 25, 25);
			innerPanel.add(btnChangeUserStatus);
			
			btnDelete.setBackground(new Color(255, 255, 255));
			btnDelete.setBorder(null);
			Image img2 = new ImageIcon(this.getClass().getResource("/trash_small.png")).getImage();
			btnDelete.setIcon(new ImageIcon(img2));
			btnDelete.setBounds(480, 3, 25, 25);
			btnDelete.setVisible(!user.getStatus());
			innerPanel.add(btnDelete);
			
			panelList.add(innerPanel);
			list_btnDelete.add(btnDelete);
			list_btnChangeUserStatus.add(btnChangeUserStatus);
			
			list_panelBookInfo.add(innerPanel);
		}
	}

	public void addBackBtnListener(ActionListener e){
		btnBack.addActionListener(e);
	}
	public void addChangeUserStatusBtnListener(ActionListener e){
		int i = 0;
		for(JButton btnChangeUserStatus : list_btnChangeUserStatus) {
			btnChangeUserStatus.setActionCommand(String.valueOf(i++));
			btnChangeUserStatus.addActionListener(e);
		}
	}
	public void addDeleteBtnListener(ActionListener e) {
		int i = 0;
		for(JButton btnDelete : list_btnDelete) {
			btnDelete.setActionCommand(String.valueOf(i++));		
			btnDelete.addActionListener(e);
		}
	}
	public void addPreviousBtnListener(ActionListener e){
		btnPrevious.addActionListener(e);
	}
	public void addNextBtnListener(ActionListener e){
		btnNext.addActionListener(e);
	}
}
