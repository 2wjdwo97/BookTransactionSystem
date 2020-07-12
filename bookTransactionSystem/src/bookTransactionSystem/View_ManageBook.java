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

public class View_ManageBook extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnRegisterBook;
	
	private JLabel lblUserName;
	
	private ArrayList<JPanel> list_panelBookInfo;
	private ArrayList<JButton> list_btnDelete;
	private ArrayList<JButton> list_btnEdit;
	
	private JPanel panelLeft;
	private JPanel panelList;
	
	public View_ManageBook(JFrame frame) {
		list_panelBookInfo = new ArrayList<JPanel>();
		list_btnEdit = new ArrayList<JButton>();
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
		
		btnRegisterBook = new JButton("+");
		btnRegisterBook.setBackground(new Color(255, 255, 255));
		btnRegisterBook.setBorder(new LineBorder(new Color(220, 220, 220)));
		btnRegisterBook.setFont(new Font("210 ∏«πﬂ¿«√ª√· R", Font.PLAIN, 18));
		btnRegisterBook.setBounds(513, 26, 45, 35);
		panelLeft.add(btnRegisterBook);
		
		JLabel lblTitle = new JLabel("\uB098\uC758 \uB4F1\uB85D \uBAA9\uB85D");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 38));
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
		lblUserName.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 12));
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
			lblUserName.setText(((Login_Info)evt.getNewValue()).getUser().getName() + " ¥‘");
		}
		else if(evt.getPropertyName().equals("manageBookList_partial")){
			makeBookList(((ArrayList<Book>)evt.getNewValue()));
		}
	}

	public void addBackBtnListener(ActionListener e){
		btnBack.addActionListener(e);
	}
	private void makeBookList(ArrayList<Book> bookList) {
		panelList.removeAll();
		list_panelBookInfo.clear();
		list_btnEdit.clear();
		list_btnDelete.clear();
		for(Book book : bookList) {
			JPanel innerPanel;
			JButton btnDelete;
			JButton btnEdit;
			Metadata metadata = book.getMetadata();
			
			JLabel lblTitle = new JLabel(metadata.getTitle());
			JLabel lblAuthor = new JLabel(metadata.getAuthor());
			JLabel lblPublisher = new JLabel(metadata.getPublisher());
			JLabel lblPrice = new JLabel(String.valueOf(book.getPrice()) + "ø¯");
			JLabel lblQuality = new JLabel(book.getQuality());
			JLabel lblISBN = new JLabel(metadata.getISBN());
			JLabel lblDate = new JLabel(metadata.getDate());
			JLabel lblStatus = new JLabel("Sold Out");
			
			btnDelete = new JButton();
			btnEdit = new JButton();
			innerPanel = new JPanel();
			
			innerPanel.setBackground(new Color(255, 255, 255));
			innerPanel.setBounds(20, 85 * list_panelBookInfo.size(), 540, 75);
			innerPanel.setLayout(null);

			lblISBN.setBounds(5, 5, 120, 10);
			lblTitle.setBounds(5, 20, 120, 40);
			lblTitle.setFont(new Font("210 ∏«πﬂ¿«√ª√· R", Font.PLAIN, 15));
			lblAuthor.setBounds(150, 10, 80, 15);
			lblPublisher.setBounds(150, 30, 80, 15);
			lblDate.setBounds(150, 50, 80, 15);
			lblPrice.setBounds(280, 10, 120, 45);
			lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrice.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 25));
			lblQuality.setBounds(280, 60, 100, 10);
			lblQuality.setHorizontalAlignment(SwingConstants.CENTER);
			lblStatus.setBounds(405, 13, 80, 20);
			
			innerPanel.add(lblStatus);
			innerPanel.add(lblISBN);
			innerPanel.add(lblTitle);
			innerPanel.add(lblAuthor);
			innerPanel.add(lblPublisher);
			innerPanel.add(lblPrice);
			innerPanel.add(lblQuality);
			innerPanel.add(lblDate);
			
			btnEdit.setBackground(new Color(255, 255, 255));
			btnEdit.setBorder(null);
			Image img = new ImageIcon(this.getClass().getResource("/modify.png")).getImage();
			btnEdit.setIcon(new ImageIcon(img));
			btnEdit.setBounds(420, 13, 50, 50);
			innerPanel.add(btnEdit);
			btnEdit.setVisible(book.getStatus());
			lblStatus.setVisible(!book.getStatus());
			
			btnDelete.setBackground(new Color(255, 255, 255));
			btnDelete.setBorder(null);
			Image img2 = new ImageIcon(this.getClass().getResource("/trash.png")).getImage();
			btnDelete.setIcon(new ImageIcon(img2));
			btnDelete.setBounds(480, 13, 50, 50);
			innerPanel.add(btnDelete);
			
			panelList.add(innerPanel);
			list_btnDelete.add(btnDelete);
			list_btnEdit.add(btnEdit);
			
			list_panelBookInfo.add(innerPanel);
		}
	}
	
	public void addEditBtnListener(ActionListener e){
		int i = 0;
		for(JButton btnEdit : list_btnEdit) {
			btnEdit.setActionCommand(String.valueOf(i++));
			btnEdit.addActionListener(e);
		}
	}
	public void addDeleteBtnListener(ActionListener e) {
		int i = 0;
		for(JButton btnDelete : list_btnDelete) {
			btnDelete.setActionCommand(String.valueOf(i++));		
			btnDelete.addActionListener(e);
		}
	}
	public void addRegisterBookBtnListener(ActionListener e){
		btnRegisterBook.addActionListener(e);
	}
	public void addPreviousBtnListener(ActionListener e){
		btnPrevious.addActionListener(e);
	}
	public void addNextBtnListener(ActionListener e){
		btnNext.addActionListener(e);
	}
}
