package bookTransactionSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View_EditBook extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtFPrice;
	
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
	JButton btnRegister;
	
	JComboBox<String> comboBox;
	
	public View_EditBook(JFrame frame) {
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
		
		lblISBN = new JLabel("ISBN");
		lblISBN.setBounds(96, 180, 57, 15);
		lblISBN.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 11));
		lblISBN.setForeground(Color.BLACK);
		panel_3.add(lblISBN);
		
		lblISBNCont = new JLabel();
		lblISBNCont.setBounds(96, 200, 116, 15);
		lblISBNCont.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 11));
		lblISBNCont.setVerticalAlignment(SwingConstants.CENTER);
		lblISBNCont.setForeground(Color.BLACK);
		panel_3.add(lblISBNCont);
		
		lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 11));
		lblTitle.setBounds(96, 230, 57, 15);
		lblTitle.setForeground(Color.BLACK);
		panel_3.add(lblTitle);

		lblTitleCont = new JLabel();
		lblTitleCont.setBounds(96, 250, 116, 15);
		lblTitleCont.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 11));
		lblTitleCont.setVerticalAlignment(SwingConstants.CENTER);
		lblTitleCont.setForeground(Color.BLACK);
		panel_3.add(lblTitleCont);
		
		lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 11));
		lblAuthor.setBounds(96, 280, 57, 15);
		lblAuthor.setForeground(Color.BLACK);
		panel_3.add(lblAuthor);

		lblAuthorCont = new JLabel();
		lblAuthorCont.setBounds(96, 300, 116, 15);
		lblAuthorCont.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 11));
		lblAuthorCont.setVerticalAlignment(SwingConstants.CENTER);
		lblAuthorCont.setForeground(Color.BLACK);
		panel_3.add(lblAuthorCont);
		
		lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 11));
		lblPublisher.setBounds(232, 180, 57, 15);
		lblPublisher.setForeground(Color.BLACK);
		panel_3.add(lblPublisher);
		
		lblPublisherCont = new JLabel();
		lblPublisherCont.setBounds(232, 200, 116, 15);
		lblPublisherCont.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 11));
		lblPublisherCont.setVerticalAlignment(SwingConstants.CENTER);
		lblPublisherCont.setForeground(Color.BLACK);
		panel_3.add(lblPublisherCont);
		
		lblDate = new JLabel("Date");
		lblDate.setBounds(232, 230, 57, 15);
		lblDate.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 11));
		lblDate.setForeground(Color.BLACK);
		panel_3.add(lblDate);
		
		lblDateCont = new JLabel();
		lblDateCont.setBounds(232, 250, 116, 15);
		lblDateCont.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 11));
		lblDateCont.setVerticalAlignment(SwingConstants.CENTER);
		lblDateCont.setForeground(Color.BLACK);
		panel_3.add(lblDateCont);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 11));
		lblPrice.setBounds(368, 180, 57, 15);
		lblPrice.setForeground(Color.BLACK);
		panel_3.add(lblPrice);
		
		JLabel lblQuality = new JLabel("Quality");
		lblQuality.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 11));
		lblQuality.setBounds(368, 230, 57, 15);
		lblQuality.setForeground(Color.BLACK);
		panel_3.add(lblQuality);
		
		txtFPrice = new JTextField();
		txtFPrice.setColumns(10);
		txtFPrice.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 11));
		txtFPrice.setBounds(368, 200, 116, 21);
		panel_3.add(txtFPrice);

		String quality[] = {"Excellent", "Good", "Fair"};
		
		comboBox = new JComboBox<String>(quality);
		comboBox.setBounds(368, 250, 116, 23);
		comboBox.setFont(new Font("210 ∏«πﬂ¿«√ª√· L", Font.PLAIN, 11));
		panel_3.add(comboBox);
		
		JLabel lblTitle = new JLabel("√• ¡§∫∏ ºˆ¡§");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("210 ∏«πﬂ¿«√ª√· B", Font.PLAIN, 38));
		lblTitle.setBounds(12, 10, 200, 60);
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

	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getNewValue() != null){
			Book book = (Book)evt.getNewValue();
			Metadata metadata = book.getMetadata();
			
			lblISBNCont.setText(metadata.getISBN());
			lblTitleCont.setText(metadata.getTitle());
			lblAuthorCont.setText(metadata.getAuthor());
			lblPublisherCont.setText(metadata.getPublisher());
			lblDateCont.setText(metadata.getDate());
			txtFPrice.setText(String.valueOf(book.getPrice()));
			comboBox.getModel().setSelectedItem(book.getQuality());
		}
	}
	
	public void setPrice(String price) {
		txtFPrice.setText(price);
	}
	public void setQuality(String quality) {
		comboBox.setName(quality);
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
}
