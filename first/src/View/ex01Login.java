package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.DAO;
import Model.DTO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ex01Login {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pw;
	private DTO result;

	public ex01Login() {
		initialize();
	}
	
	public ex01Login(DTO result) {
		this.result = result;
		initialize();
		frame.setVisible(true);
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex01Login window = new ex01Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(800, 300, 432,451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 416, 412);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbl_login = new JLabel("\uB85C\uADF8\uC778");
		lbl_login.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 23));
		lbl_login.setForeground(new Color(0, 0, 0));
		lbl_login.setBounds(176, 61, 114, 51);
		panel.add(lbl_login);

		JLabel lbl_id = new JLabel("  \uC544\uC774\uB514");
		lbl_id.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_id.setForeground(new Color(0, 0, 0));
		lbl_id.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_id.setBounds(44, 147, 77, 36);
		panel.add(lbl_id);

		JLabel lbl_pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl_pw.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pw.setForeground(new Color(0, 0, 0));
		lbl_pw.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lbl_pw.setBounds(36, 205, 85, 36);
		panel.add(lbl_pw);

		txt_id = new JTextField();
		txt_id.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		txt_id.setBounds(140, 148, 182, 36);
		panel.add(txt_id);
		txt_id.setColumns(10);

//		txt_pw = new JTextField();
		txt_pw = new JPasswordField();
		txt_pw.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		txt_pw.setColumns(10);
		txt_pw.setBounds(140, 206, 182, 36);
		panel.add(txt_pw);

		JButton btn_ok = new JButton("\uD655\uC778");
		btn_ok.setForeground(new Color(0, 0, 0));
		btn_ok.setBackground(new Color(220, 220, 220));
		btn_ok.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = txt_id.getText();
				String pw = txt_pw.getText();

				DAO dao = new DAO();
				DTO result = dao.login(new DTO(id, pw));
				if (result != null) {
					new ex02Main(result);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "·Î±×ÀÎ ½ÇÆÐ! ºñ¹Ð¹øÈ£ ºÐ½Ç½Ã °ü¸®ÀÚ¿¡°Ô ¹®ÀÇÇÏ¼¼¿ä.", "·Î±×ÀÎ ½ÇÆÐ",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_ok.setBounds(140, 294, 174, 36);
		panel.add(btn_ok);
	}
}
