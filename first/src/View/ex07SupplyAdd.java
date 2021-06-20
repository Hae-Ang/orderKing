package View;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;

import Controller.DAO;
import Model.DTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ex07SupplyAdd {

	private JFrame frame;
	private JTextField txt_scode;
	private JTextField txt_sname;
	private JTextField txt_admin;
	private JTextField txt_email;
	private JTextField txt_ph;
	private JTextField txt_address;
	private JTextField txt_crno;
	private JTextField txt_remark;
	private DTO result1;

	public ex07SupplyAdd() {
		initialize();
		frame.setVisible(true);
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 300, 708, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		frame.getContentPane().add(panel, "name_67693131949200");
		panel.setLayout(null);

		JLabel lbl_add = new JLabel("\uAC70\uB798\uCC98 \uCD94\uAC00");
		lbl_add.setForeground(new Color(0, 0, 0));
		lbl_add.setFont(new Font("³ª´®°íµñ ExtraBold", Font.BOLD, 23));
		lbl_add.setBounds(35, 25, 200, 51);
		panel.add(lbl_add);

		JLabel lbl_code = new JLabel("\uAC70\uB798\uCC98\uCF54\uB4DC");
		lbl_code.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_code.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_code.setForeground(new Color(0, 0, 0));
		
		lbl_code.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_code.setBounds(49, 113, 84, 51);
		panel.add(lbl_code);

		txt_scode = new JTextField();
		txt_scode.setBounds(145, 121, 167, 37);
		panel.add(txt_scode);
		txt_scode.setColumns(10);

		JLabel lbl_name = new JLabel("\uAC70\uB798\uCC98\uBA85");
		lbl_name.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_name.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_name.setBounds(49, 166, 84, 51);
		panel.add(lbl_name);

		txt_sname = new JTextField();
		txt_sname.setColumns(10);
		txt_sname.setBounds(145, 174, 167, 37);
		panel.add(txt_sname);

		JLabel lbl_admin = new JLabel("\uAD00\uB9AC\uC790");
		lbl_admin.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_admin.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_admin.setBounds(73, 230, 60, 29);
		panel.add(lbl_admin);

		txt_admin = new JTextField();
		txt_admin.setColumns(10);
		txt_admin.setBounds(145, 227, 167, 37);
		panel.add(txt_admin);

		JLabel lbl_email = new JLabel("\uC774\uBA54\uC77C");
		lbl_email.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_email.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_email.setBounds(73, 283, 60, 29);
		panel.add(lbl_email);

		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(145, 280, 167, 37);
		panel.add(txt_email);

		JLabel lbl_phone = new JLabel("\uC5F0\uB77D\uCC98 (-)\uD3EC\uD568");
		lbl_phone.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_phone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_phone.setBounds(346, 124, 109, 29);
		panel.add(lbl_phone);

		txt_ph = new JTextField();
		txt_ph.setColumns(10);
		txt_ph.setBounds(467, 121, 167, 37);
		panel.add(txt_ph);

		JLabel lbl_address = new JLabel("\uC8FC   \uC18C");
		lbl_address.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_address.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_address.setBounds(395, 177, 60, 29);
		panel.add(lbl_address);

		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(467, 174, 167, 37);
		panel.add(txt_address);

		JLabel lbl_crno = new JLabel("\uC0AC\uC5C5\uC790\uBC88\uD638 (-)\uD3EC\uD568");
		lbl_crno.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_crno.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_crno.setBounds(324, 232, 131, 25);
		panel.add(lbl_crno);

		txt_crno = new JTextField();
		txt_crno.setColumns(10);
		txt_crno.setBounds(467, 227, 167, 37);
		panel.add(txt_crno);

		txt_remark = new JTextField();
		txt_remark.setColumns(10);
		txt_remark.setBounds(467, 280, 167, 37);
		panel.add(txt_remark);

		JLabel lbl_remark = new JLabel("\uC801    \uC694");
		lbl_remark.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_remark.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_remark.setBounds(395, 283, 60, 29);
		panel.add(lbl_remark);

		JButton btn_add = new JButton("\uCD94\uAC00\uD558\uAE30");
		btn_add.setForeground(new Color(0, 0, 0));
		btn_add.setBackground(new Color(220, 220, 220));
		btn_add.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		btn_add.setBounds(145, 358, 190, 50);
		btn_add.addMouseListener(new MouseAdapter() {
			private DAO sup;

			@Override
			public void mouseClicked(MouseEvent e) {

				String supplyCode = txt_scode.getText();
				String supplyName = txt_sname.getText();
				String admin = txt_admin.getText();
				String email = txt_email.getText();
				String ph = txt_ph.getText();
				String address = txt_address.getText();
				String crno = txt_crno.getText();
				String remark = txt_remark.getText();
				DAO sup = new DAO();
				int result = sup.insert1(new DTO(supplyCode, supplyName, admin, email, ph, address, crno, remark));
			}
		});

		panel.add(btn_add);
		
		JButton btn_back = new JButton("\uC774\uC804\uC73C\uB85C");
		btn_back.setForeground(new Color(0, 0, 0));
		btn_back.setBackground(new Color(220, 220, 220));
		btn_back.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		btn_back.setBounds(370, 358, 190, 50);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ex06SupplyManagement(result1);
				frame.dispose();
			}
		});
		panel.add(btn_back);
	}
}
