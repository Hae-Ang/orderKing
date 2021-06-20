package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.DAO;
import Model.DTO;
import javax.swing.SwingConstants;

public class ex10Bom_add {

	private JFrame frame;
	private JTextField txt_itemName;
	private JTextField txt_supplyName;
	private JTextField txt_price;
	private JTextField txt_itemQty;
	private JTextField txt_pdNo;
	private JTextField txt_stock;
	private JTextField txt_itemNo;
	private DTO result;
	private DTO result1;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex10Bom_add window = new ex10Bom_add();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ex10Bom_add() {
		initialize();
	}
	
	public ex10Bom_add(DTO result) {
		this.result = result;
		initialize();
		frame.setVisible(true);
	}


	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.setBounds(600, 200, 518, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_bom = new JLabel("BOM\uAD00\uB9AC \uCD94\uAC00\uD558\uAE30");
		lbl_bom.setForeground(new Color(0, 0, 0));
		lbl_bom.setFont(new Font("³ª´®°íµñ ExtraBold", Font.BOLD, 23));
		lbl_bom.setBounds(35, 25, 200, 51);	
		frame.getContentPane().add(lbl_bom);
		
		JLabel lbl_pdNo = new JLabel("\uD488      \uBC88");
		lbl_pdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pdNo.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_pdNo.setForeground(new Color(0, 0, 0));
		lbl_pdNo.setBounds(138, 85, 57, 51);
		frame.getContentPane().add(lbl_pdNo);
		
		JLabel lbl_itemName = new JLabel("\uBB3C \uD488 \uBA85");
		lbl_itemName.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_itemName.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_itemName.setForeground(new Color(0, 0, 0));
		lbl_itemName.setBounds(138, 197, 57, 51);
		frame.getContentPane().add(lbl_itemName);
		
		JLabel lbl_supplyName = new JLabel("\uAC70\uB798\uCC98\uBA85");
		lbl_supplyName.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_supplyName.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_supplyName.setForeground(new Color(0, 0, 0));
		lbl_supplyName.setBounds(138, 253, 57, 51);
		frame.getContentPane().add(lbl_supplyName);
		
		JLabel lbl_itemQty = new JLabel("\uC218     \uB7C9");
		lbl_itemQty.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_itemQty.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_itemQty.setForeground(new Color(0, 0, 0));
		lbl_itemQty.setBounds(138, 309, 57, 51);
		frame.getContentPane().add(lbl_itemQty);
		
		JLabel lbl_price = new JLabel("\uAC00     \uACA9");
		lbl_price.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_price.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_price.setForeground(new Color(0, 0, 0));
		lbl_price.setBounds(138, 365, 57, 51);
		frame.getContentPane().add(lbl_price);
		
		txt_itemName = new JTextField();
		txt_itemName.setBounds(215, 205, 160, 38);
		frame.getContentPane().add(txt_itemName);
		txt_itemName.setColumns(10);
		
		txt_supplyName = new JTextField();
		txt_supplyName.setColumns(10);
		txt_supplyName.setBounds(215, 261, 160, 38);
		frame.getContentPane().add(txt_supplyName);
		
		txt_price = new JTextField();
		txt_price.setColumns(10);
		txt_price.setBounds(215, 317, 160, 38);
		frame.getContentPane().add(txt_price);
		
		txt_itemQty = new JTextField();
		txt_itemQty.setColumns(10);
		txt_itemQty.setBounds(215, 373, 160, 38);
		frame.getContentPane().add(txt_itemQty);
		
		JButton btn_add = new JButton("\uCD94\uAC00\uD558\uAE30");
		btn_add.setForeground(new Color(0, 0, 0));
		btn_add.setBackground(new Color(220, 220, 220));
		btn_add.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		btn_add.setBounds(81, 492, 153, 50);
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pdNo = txt_pdNo.getText();
				String itemNo = txt_itemNo.getText();
				String itemName = txt_itemName.getText();
				String supplyName = txt_supplyName.getText();
				int price = Integer.parseInt(txt_price.getText());
				int itemQty = Integer.parseInt(txt_itemQty.getText());
				int stock = Integer.parseInt(txt_stock.getText());
				
				//2. µ¥ÀÌÅÍº£ÀÌ½º ¿¬°áÇØÁÖ´Â µµ±¸
				DAO dao = new DAO();
				int result = dao.insert(new DTO(pdNo, itemNo, itemName, supplyName, price, itemQty, stock));
				
				//3. ¼º°ø¿©ºÎ
				if (result >0 ) {
					System.out.println("Ãß°¡ ¿Ï·á");
				//4. ÆË¾÷Ã¢ ¶ç¿ì±â(¿Ü¿ì±â)
					JOptionPane.showMessageDialog(null, "Ãß°¡ ¿Ï·á!","Ãß°¡ ¿Ï·á", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					
				}
			}
		});
		frame.getContentPane().add(btn_add);
		
		txt_pdNo = new JTextField();
		txt_pdNo.setColumns(10);
		txt_pdNo.setBounds(215, 93, 160, 38);
		frame.getContentPane().add(txt_pdNo);
		
		JLabel lbl_stock = new JLabel("\uC7AC     \uACE0");
		lbl_stock.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_stock.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_stock.setForeground(new Color(0, 0, 0));
		lbl_stock.setBounds(138, 421, 57, 51);
		frame.getContentPane().add(lbl_stock);
		
		txt_stock = new JTextField();
		txt_stock.setColumns(10);
		txt_stock.setBounds(215, 429, 160, 38);
		frame.getContentPane().add(txt_stock);
		
		JLabel lbl_itemNo = new JLabel("\uBB3C\uD488\uBC88\uD638");
		lbl_itemNo.setForeground(new Color(0, 0, 0));
		lbl_itemNo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		lbl_itemNo.setBounds(138, 141, 66, 51);
		frame.getContentPane().add(lbl_itemNo);
		
		txt_itemNo = new JTextField();
		txt_itemNo.setColumns(10);
		txt_itemNo.setBounds(215, 149, 160, 38);
		frame.getContentPane().add(txt_itemNo);
		
		JButton btn_back = new JButton("\uC774\uC804\uC73C\uB85C");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ex08bom_img(result);
				frame.dispose();
			}
		});
		btn_back.setForeground(Color.BLACK);
		btn_back.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		btn_back.setBackground(new Color(220, 220, 220));
		btn_back.setBounds(256, 492, 153, 50);
		frame.getContentPane().add(btn_back);
	
	}
}
