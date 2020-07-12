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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class View_RegisterBook extends JPanel implements PropertyChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	JPanel panelList;
	
	JTextField txtFPrice;
	JTextField txtFSearchBar;
	
	JLabel lblISBN;
	JLabel lblTitle;
	JLabel lblAuthor;
	JLabel lblPublisher;
	JLabel lblDate;
	
	JLabel lblISBNCont;
	JLabel lblTitleCont;
	JLabel lblAuthorCont;
	JLabel lblPublisherCont;
	JLabel lblDateCont;
	
	JButton btnBack;
	JButton btnSearch;
	JButton btnRegister;
	JButton btnPrevious;
	JButton btnNext;
	
	JComboBox<String> comboBox;
	
	private ArrayList<JPanel> list_panelBookInfo;
	private ArrayList<JButton> list_btnSelect;
	
	public View_RegisterBook(JFrame frame) {
		list_panelBookInfo = new ArrayList<JPanel>();
		list_btnSelect = new ArrayList<JButton>();
		setBounds(0, 0, 800, 500);
		setLayout(null);
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(580, 0, 214, 490);
		panelRight.setOpaque(false);
		add(panelRight);
		panelRight.setLayout(null);
		
		JPanel panel_shadow = new JPanel();
		panel_shadow.setBounds(580, 0, 214, 490);
		panel_shadow.setBackground(new Color(0, 0, 0, 130));
		add(panel_shadow);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 580, 490);
		panel_3.setBackground(new Color(250, 250, 250, 245));
		add(panel_3);
		panel_3.setLayout(null);
		
		JRadioButton rdbtnISBN = new JRadioButton("ISBN");
		rdbtnISBN.setActionCommand("ISBN");
		rdbtnISBN.setOpaque( false );
		rdbtnISBN.setContentAreaFilled(false);
		rdbtnISBN.setBorderPainted(false);
		rdbtnISBN.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnISBN);
		rdbtnISBN.setBounds(135, 70, 63, 12);
		panel_3.add(rdbtnISBN);
		
		JRadioButton rdbtnTitle= new JRadioButton("Title");
		rdbtnTitle.setActionCommand("Title");
		rdbtnTitle.setSelected(true);
		rdbtnTitle.setOpaque( false );
		rdbtnTitle.setContentAreaFilled(false);
		rdbtnTitle.setBorderPainted(false);
		rdbtnTitle.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnTitle);
		rdbtnTitle.setBounds(200, 70, 73, 12);
		panel_3.add(rdbtnTitle);
		
		txtFSearchBar = new JTextField();
		txtFSearchBar.setBounds(135, 90, 230, 27);
		txtFSearchBar.setForeground(Color.BLACK);
		panel_3.add(txtFSearchBar);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(80, 170, 255, 255));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBounds(365, 90, 80, 27);
		panel_3.add(btnSearch);
		
		panelList = new JPanel();
		panelList.setBounds(90, 130, 400, 130);
		panel_3.add(panelList);
		panelList.setLayout(null);
		
		btnPrevious = new JButton("\u25C0");
		btnPrevious.setBackground(new Color(255, 255, 255));
		btnPrevious.setBorder(new LineBorder(new Color(220, 220, 220)));
		btnPrevious.setBounds(440, 265, 20, 20);
		panel_3.add(btnPrevious);
		
		btnNext = new JButton("\u25B6");
		btnNext.setBackground(new Color(255, 255, 255));
		btnNext.setBorder(new LineBorder(new Color(220, 220, 220)));
		btnNext.setBounds(470, 265, 20, 20);
		panel_3.add(btnNext);
		
		lblISBN = new JLabel("ISBN");
		lblISBN.setBounds(96, 280, 57, 15);
		lblISBN.setForeground(Color.BLACK);
		panel_3.add(lblISBN);
		
		lblISBNCont = new JLabel();
		lblISBNCont.setBounds(96, 300, 116, 15);
		lblISBNCont.setForeground(Color.BLACK);
		panel_3.add(lblISBNCont);
		
		lblTitle = new JLabel("Title");
		lblTitle.setBounds(96, 330, 57, 15);
		lblTitle.setForeground(Color.BLACK);
		panel_3.add(lblTitle);

		lblTitleCont = new JLabel();
		lblTitleCont.setBounds(96, 350, 116, 15);
		lblTitleCont.setForeground(Color.BLACK);
		panel_3.add(lblTitleCont);
		
		lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(96, 380, 57, 15);
		lblAuthor.setForeground(Color.BLACK);
		panel_3.add(lblAuthor);

		lblAuthorCont = new JLabel();
		lblAuthorCont.setBounds(96, 400, 116, 15);
		lblAuthorCont.setForeground(Color.BLACK);
		panel_3.add(lblAuthorCont);
		
		lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(232, 280, 57, 15);
		lblPublisher.setForeground(Color.BLACK);
		panel_3.add(lblPublisher);
		
		lblPublisherCont = new JLabel();
		lblPublisherCont.setBounds(232, 300, 116, 15);
		lblPublisherCont.setForeground(Color.BLACK);
		panel_3.add(lblPublisherCont);
		
		lblDate = new JLabel("Date");
		lblDate.setBounds(232, 330, 57, 15);
		lblDate.setForeground(Color.BLACK);
		panel_3.add(lblDate);
		
		lblDateCont = new JLabel();
		lblDateCont.setBounds(232, 350, 116, 15);
		lblDateCont.setForeground(Color.BLACK);
		panel_3.add(lblDateCont);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(368, 280, 57, 15);
		lblPrice.setForeground(Color.BLACK);
		panel_3.add(lblPrice);
		
		JLabel lblQuality = new JLabel("Quality");
		lblQuality.setBounds(368, 330, 57, 15);
		lblQuality.setForeground(Color.BLACK);
		panel_3.add(lblQuality);
		
		txtFPrice = new JTextField();
		txtFPrice.setColumns(10);
		txtFPrice.setBounds(368, 300, 116, 21);
		panel_3.add(txtFPrice);

		String quality[] = {"Excellent", "Good", "Fair"};
		
		comboBox = new JComboBox<String>(quality);
		comboBox.setBounds(368, 350, 116, 23);
		panel_3.add(comboBox);
		
		JLabel lblTitle = new JLabel("\uCC45 \uB4F1\uB85D");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 38));
		lblTitle.setBounds(12, 10, 127, 60);
		panel_3.add(lblTitle);
		
		btnBack = new JButton();
		btnBack.setOpaque( false );
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		Image imgBack = new ImageIcon(this.getClass().getResource("/undo.png")).getImage();
		btnBack.setIcon(new ImageIcon(imgBack));
		btnBack.setBounds(115, 390, 64, 64);
		panelRight.add(btnBack);
		
		btnRegister = new JButton();
		btnRegister.setOpaque( false );
		btnRegister.setContentAreaFilled(false);
		btnRegister.setBorderPainted(false);
		Image imgReg = new ImageIcon(this.getClass().getResource("/register.png")).getImage();
		btnRegister.setIcon(new ImageIcon(imgReg));
		btnRegister.setBounds(35, 390, 64, 64);
		panelRight.add(btnRegister);
		
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
		if(evt.getPropertyName().equals("metadataList_partial")) {
			makeMetadataList(((ArrayList<Metadata>)evt.getNewValue()));
		}
		else if(evt.getPropertyName().equals("focusBook")){
			if(evt.getNewValue() != null) {
				Book newBook = (Book)evt.getNewValue();
				Metadata metadata = newBook.getMetadata();
				
				lblISBNCont.setText(metadata.getISBN());
				lblTitleCont.setText(metadata.getTitle());
				lblAuthorCont.setText(metadata.getAuthor());
				lblPublisherCont.setText(metadata.getPublisher());
				lblDateCont.setText(metadata.getDate());
			}
			else {
				txtFSearchBar.setText("");
				lblISBNCont.setText("");
				lblTitleCont.setText("");
				lblAuthorCont.setText("");
				lblPublisherCont.setText("");
				lblDateCont.setText("");
				txtFPrice.setText("");
				comboBox.getModel().setSelectedItem("Excellent");
				panelList.removeAll();
			}
		}
	}
	
	private void makeMetadataList(ArrayList<Metadata> metadataList) {
		panelList.removeAll();
		list_panelBookInfo.clear();
		list_btnSelect.clear();
		for(Metadata metadata : metadataList) {
			JPanel innerPanel;
			JButton btnSelect;
			
			JLabel lblTitle = new JLabel(metadata.getTitle());
			JLabel lblAuthor = new JLabel(metadata.getAuthor());
			JLabel lblPublisher = new JLabel(metadata.getPublisher());
			JLabel lblISBN = new JLabel(metadata.getISBN());
			JLabel lblDate = new JLabel(metadata.getDate());
			
			btnSelect = new JButton();
			innerPanel = new JPanel();
			
			innerPanel.setBackground(new Color(255, 255, 255));
			innerPanel.setBounds(0, 16 * list_panelBookInfo.size(), 400, 15);
			innerPanel.setLayout(null);

			lblISBN.setBounds(5, 0, 90, 15);
			lblISBN.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 9));
			lblTitle.setBounds(95, 0, 90, 15);
			lblTitle.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 9));
			lblAuthor.setBounds(190, 0, 40, 15);
			lblAuthor.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 9));
			lblPublisher.setBounds(235, 0, 50, 15);
			lblPublisher.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 9));
			lblDate.setBounds(290, 0, 40, 15);
			lblDate.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 9));
			
			innerPanel.add(lblISBN);
			innerPanel.add(lblTitle);
			innerPanel.add(lblAuthor);
			innerPanel.add(lblPublisher);
			innerPanel.add(lblDate);
			
			btnSelect.setBackground(new Color(255, 255, 255));
			btnSelect.setBorder(null);
			btnSelect.setBounds(370, 0, 20, 15);
			Image img = new ImageIcon(this.getClass().getResource("/select.png")).getImage();
			btnSelect.setIcon(new ImageIcon(img));
			innerPanel.add(btnSelect);
			
			panelList.add(innerPanel);
			list_btnSelect.add(btnSelect);
			
			list_panelBookInfo.add(innerPanel);
		}
	}
	
	public void setPrice(String price) {
		txtFPrice.setText(price);
	}
	public void setQuality(String quality) {
		comboBox.setName(quality);
	}
	
	public String getSearchBar() {
		return txtFSearchBar.getText();
	}
	public String getPrice() {
		return txtFPrice.getText();
	}
	public String getQuality() {
		return String.valueOf(comboBox.getSelectedItem());
	}
	
	public void addRegisterBtnListener(ActionListener e){
		btnRegister.addActionListener(e);
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
	public void addSearchBtnListener(ActionListener e){
		btnSearch.addActionListener(e);
	}

	public void addSelectBtnListener(ActionListener e) {
		int i = 0;
		for(JButton btnSelect : list_btnSelect) {
			btnSelect.setActionCommand(String.valueOf(i++));		
			btnSelect.addActionListener(e);
		}	
	}

	public String getSelectedRadio() {
		return buttonGroup.getSelection().getActionCommand();
	}
}