package bookTransactionSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class View_SearchResult extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private ArrayList<JPanel> list_panelBookInfo;
	private ArrayList<JButton> list_btnPurchase;
	private ArrayList<JButton> list_btnDelete;
	private JButton btnSearch;
	private JButton btnBack;
	private JButton btnPrevious;
	private JButton btnNext;
	private JLabel lblUserName;
	private JPanel panelList;
	private JTextField txtFSearchBar;
	private boolean isAdmin;
	
	public View_SearchResult(JFrame frame) {
		list_panelBookInfo = new ArrayList<JPanel>();
		list_btnPurchase = new ArrayList<JButton>();
		list_btnDelete = new ArrayList<JButton>();
		
		setBounds(0, 0, 800, 500);
		setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 800, 100);
		titlePanel.setOpaque(false);
		add(titlePanel);
		titlePanel.setLayout(null);
		
		panelList = new JPanel();
		panelList.setBackground(new Color(250, 250, 250, 245));
		panelList.setBounds(0, 100, 794, 350);
		add(panelList);
		panelList.setLayout(null);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 450, 794, 50);
		add(buttonPanel);
		buttonPanel.setLayout(null);
		
		txtFSearchBar = new JTextField();
		txtFSearchBar.setToolTipText("search book......");
		txtFSearchBar.setBounds(199, 40, 300, 27);
		titlePanel.add(txtFSearchBar);
		txtFSearchBar.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(80, 170, 255, 255));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBounds(500, 40, 94, 27);
		titlePanel.add(btnSearch);
		
		btnBack = new JButton();
		btnBack.setOpaque( false );
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		Image img = new ImageIcon(this.getClass().getResource("/home-run.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.setBounds(20, 10, 64, 64);
		titlePanel.add(btnBack);
		
		btnPrevious = new JButton("\u25C0");
		btnPrevious.setBackground(new Color(255, 255, 255));
		btnPrevious.setBorder(new LineBorder(new Color(220, 220, 220)));
		btnPrevious.setBounds(374, 0, 45, 40);
		buttonPanel.add(btnPrevious);
		
		btnNext = new JButton("\u25B6");
		btnNext.setBackground(new Color(255, 255, 255));
		btnNext.setBorder(new LineBorder(new Color(220, 220, 220)));
		btnNext.setBounds(424, 0, 45, 40);
		buttonPanel.add(btnNext);
		
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
		rdbtnTitle.setBounds(199, 5, 49, 23);
		titlePanel.add(rdbtnTitle);
		
		JRadioButton rdbtnISBN = new JRadioButton("ISBN");
		rdbtnISBN.setActionCommand("ISBN");
		rdbtnISBN.setOpaque( false );
		rdbtnISBN.setContentAreaFilled(false);
		rdbtnISBN.setBorderPainted(false);
		rdbtnISBN.setForeground(Color.WHITE);
		buttonGroup.add(rdbtnISBN);
		rdbtnISBN.setBounds(252, 5, 57, 23);
		titlePanel.add(rdbtnISBN);
		
		JRadioButton rdbtnAuthor = new JRadioButton("Author");
		rdbtnAuthor.setActionCommand("Author");
		rdbtnAuthor.setOpaque( false );
		rdbtnAuthor.setContentAreaFilled(false);
		rdbtnAuthor.setBorderPainted(false);
		rdbtnAuthor.setForeground(Color.WHITE);
		buttonGroup.add(rdbtnAuthor);
		rdbtnAuthor.setBounds(313, 5, 63, 23);
		titlePanel.add(rdbtnAuthor);
		
		JRadioButton rdbtnSellerID = new JRadioButton("Seller ID");
		rdbtnSellerID.setActionCommand("ID");
		rdbtnSellerID.setOpaque( false );
		rdbtnSellerID.setContentAreaFilled(false);
		rdbtnSellerID.setBorderPainted(false);
		rdbtnSellerID.setForeground(Color.WHITE);
		
		buttonGroup.add(rdbtnSellerID);
		rdbtnSellerID.setBounds(380, 5, 73, 23);
		titlePanel.add(rdbtnSellerID);
		
		JPanel titlePanel_shadow = new JPanel();
		titlePanel_shadow.setBounds(0, 0, 800, 100);
		titlePanel_shadow.setBackground(new Color(0, 0, 0, 130));
		add(titlePanel_shadow);
		
		JLabel lblBGI = new JLabel("");
		lblBGI.setForeground(Color.WHITE);
		Image img2 = new ImageIcon(this.getClass().getResource("/loginBGI.jpg")).getImage();
		lblBGI.setIcon(new ImageIcon(img2));
		lblBGI.setBounds(0, 0, 800, 500);
		add(lblBGI);

		setVisible(true);
	}
	
	public ArrayList<JButton> getList_btnPurchase() {
		return list_btnPurchase;
	}
	
	public void addPurchaseBtnListener(ActionListener e){
		int i = 0;
		for(JButton btnPurchase : list_btnPurchase) {
			btnPurchase.setActionCommand(String.valueOf(i++));
			btnPurchase.addActionListener(e);
		}
	}
	public void addDeleteBtnListener(ActionListener e){
		int i = 0;
		for(JButton btnDelete : list_btnDelete) {
			btnDelete.setActionCommand(String.valueOf(i++));
			btnDelete.addActionListener(e);
		}
	}

	@SuppressWarnings("unchecked")
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("login")) {
			lblUserName.setText(((Login_Info)evt.getNewValue()).getUser().getName() + " 님");
			isAdmin = ((Login_Info)evt.getNewValue()).getIsAdmin();
		}
		else if(evt.getPropertyName().equals("searchedBookList_partial"))
			makeSearchList((ArrayList<Book>) evt.getNewValue());
	}
	
	private void makeSearchList(ArrayList<Book> bookList) {
		panelList.removeAll();
		list_panelBookInfo.clear();
		list_btnPurchase.clear();
		list_btnDelete.clear();
		
		for(Book book : bookList) {
			JPanel innerPanel;
			JButton btnPurchase;
			JButton btnDelete;
			Metadata metadata = book.getMetadata();
			btnPurchase = new JButton();
			btnDelete = new JButton();
			innerPanel = new JPanel();
			
			innerPanel.setBackground(Color.WHITE);
			innerPanel.setBounds(20, 85 * list_panelBookInfo.size() + 10, 750, 75);
			innerPanel.setLayout(null);

			JLabel lblISBN = new JLabel(metadata.getISBN());
			lblISBN.setBounds(5, 10, 200, 10);
			
			JLabel lblTitle = new JLabel(metadata.getTitle());
			lblTitle.setBounds(7, 20, 180, 45);
			lblTitle.setFont(new Font("210 맨발의청춘 R", Font.PLAIN, 25));
			
			JLabel lblAuthorTitle = new JLabel("저자");
			lblAuthorTitle.setHorizontalAlignment(4);
			lblAuthorTitle.setBounds(200, 12, 40, 15);
			lblAuthorTitle.setFont(new Font("210 맨발의청춘 B", Font.PLAIN, 12));
			
			JLabel lblAuthor = new JLabel(metadata.getAuthor());
			lblAuthor.setBounds(250, 12, 100, 15);
			lblAuthor.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 11));
			
			JLabel lblPublisherTitle = new JLabel("출판사");
			lblPublisherTitle.setHorizontalAlignment(4);
			lblPublisherTitle.setBounds(200, 32, 40, 15);
			lblPublisherTitle.setFont(new Font("210 맨발의청춘 B", Font.PLAIN, 12));
			
			JLabel lblPublisher = new JLabel(metadata.getPublisher());
			lblPublisher.setBounds(250, 32, 100, 15);
			lblPublisher.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 11));
			
			JLabel lblDateTitle = new JLabel("출판일");
			lblDateTitle.setHorizontalAlignment(4);
			lblDateTitle.setBounds(200, 52, 40, 15);
			lblDateTitle.setFont(new Font("210 맨발의청춘 B", Font.PLAIN, 12));
			
			JLabel lblDate = new JLabel(metadata.getDate());
			lblDate.setBounds(250, 52, 100, 15);
			lblDate.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 11));
			
			JLabel lblPrice = new JLabel(String.valueOf(book.getPrice()) + "원");
			lblPrice.setBounds(550, 12, 120, 45);
			lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrice.setFont(new Font("210 맨발의청춘 B", Font.PLAIN, 25));
			
			JLabel lblQuality = new JLabel(book.getQuality());
			lblQuality.setBounds(550, 55, 120, 10);
			lblQuality.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel lblSellerIDTitle = new JLabel("판매자");
			lblSellerIDTitle.setHorizontalAlignment(4);
			lblSellerIDTitle.setBounds(370, 12, 40, 15);
			lblSellerIDTitle.setFont(new Font("210 맨발의청춘 B", Font.PLAIN, 12));
			
			JLabel lblSellerID = new JLabel(book.getUser().getID());
			lblSellerID.setBounds(420, 12, 120, 15);
			lblSellerID.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 11));
			
			JLabel lblSellerEmailTitle = new JLabel("이메일");
			lblSellerEmailTitle.setHorizontalAlignment(4);
			lblSellerEmailTitle.setBounds(370, 32, 40, 15);
			lblSellerEmailTitle.setFont(new Font("210 맨발의청춘 B", Font.PLAIN, 12));
			
			JLabel lblSellerEmail = new JLabel(book.getUser().getEmailAddress());
			lblSellerEmail.setBounds(420, 32, 120, 15);
			lblSellerEmail.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 11));

			innerPanel.add(lblSellerIDTitle);
			innerPanel.add(lblSellerID);
			innerPanel.add(lblSellerEmailTitle);
			innerPanel.add(lblSellerEmail);
			innerPanel.add(lblISBN);
			innerPanel.add(lblTitle);
			innerPanel.add(lblAuthor);
			innerPanel.add(lblPublisher);
			innerPanel.add(lblPrice);
			innerPanel.add(lblQuality);
			innerPanel.add(lblDate);
			innerPanel.add(lblAuthorTitle);
			innerPanel.add(lblPublisherTitle);
			innerPanel.add(lblDateTitle);
			
			btnPurchase.setBackground(new Color(255, 255, 255));
			btnPurchase.setBorder(null);
			Image img = new ImageIcon(this.getClass().getResource("/supermarket.png")).getImage();
			btnPurchase.setIcon(new ImageIcon(img));
			btnPurchase.setBounds(680, 13, 50, 50);
			innerPanel.add(btnPurchase);
			btnPurchase.setVisible(!isAdmin);
			
			btnDelete.setBackground(new Color(255, 255, 255));
			btnDelete.setBorder(null);
			Image imgDelete = new ImageIcon(this.getClass().getResource("/trash.png")).getImage();
			btnDelete.setIcon(new ImageIcon(imgDelete));
			btnDelete.setBounds(680, 13, 50, 50);
			innerPanel.add(btnDelete);
			btnDelete.setVisible(isAdmin);
			
			panelList.add(innerPanel);
			list_btnPurchase.add(btnPurchase);
			list_btnDelete.add(btnDelete);
			list_panelBookInfo.add(innerPanel);
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
	
	public void addSearchBtnListener(ActionListener e) {
		btnSearch.addActionListener(e);
	}

	public void addBackBtnListener(ActionListener e){
		btnBack.addActionListener(e);
	}
	
	public void addPreviousBtnListener(ActionListener e){
		btnPrevious.addActionListener(e);
	}
	public void addNextBtnListener(ActionListener e){
		btnNext.addActionListener(e);
	}
}
