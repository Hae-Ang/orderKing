package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.DTO;
import java.awt.Color;

public class ex02Main {

	private JFrame frame;
	private DTO result = null;
	private DTO result1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex02Main window = new ex02Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ex02Main() {
		initialize();
		frame.setVisible(true);
	}

	public ex02Main(DTO result) {
		this.result = result;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.setBounds(500, 300, 940, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_img = new JLabel("");
		lbl_img.setBounds(203, 31, 614, 259);
		frame.getContentPane().add(lbl_img);

		// ÀÌ¹ÌÁö ³Ö´Â ¹æ¹ý(»çÀÌÁî Á¶Àý)
		// ÇöÀç ³» Å¬·¡½º°¡ ÀúÀåµÇ¾îÀÖ´Â °æ·Î¸¦ °¡Áö°í ¿À´Â ¹æ¹ý
		String url = getClass().getResource("").getPath();
		System.out.println(url);
		String realUrl = url + "img/img.png";

		// »çÀÌÁî Á¶ÀýÇÒ ¼ö ÀÖ°Ô²û ÀÌ¹ÌÁö º¯È¯
		Image temp = new ImageIcon(realUrl).getImage();
		// »çÀÌÁî Á¶Àý(³ÐÀÌ, ³ôÀÌ, ÇÈ¼¿°ª)
		// gif -> Image.SCALE_DEFAULT
		// ¸ØÃçÀÖ´Â ÀÌ¹ÌÁö -> Image.SCALE_SMOOTH
		ImageIcon img = new ImageIcon(temp.getScaledInstance(534, 167, Image.SCALE_SMOOTH));
		lbl_img.setIcon(img);

		JButton btn_order = new JButton("\uBC1C\uC8FC\uD558\uAE30");
		btn_order.setForeground(new Color(0, 0, 0));
		btn_order.setBackground(new Color(220, 220, 220));
		btn_order.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 17));
		btn_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ex04Auto(result);
				frame.dispose();
			}
		});
		btn_order.setBounds(128, 315, 180, 70);
		frame.getContentPane().add(btn_order);
		btn_order.setVisible(false);

		JButton btn_status = new JButton("\uC8FC\uBB38\uD604\uD669");
		btn_status.setForeground(new Color(0, 0, 0));
		btn_status.setBackground(new Color(220, 220, 220));
		btn_status.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 17));
		btn_status.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ex05order_status(result);
				frame.dispose();
			}
		});
		btn_status.setBounds(375, 317, 180, 70);
		frame.getContentPane().add(btn_status);
		btn_status.setVisible(false);

		JButton btn_login = new JButton("\uB85C\uADF8\uC778");
		btn_login.setForeground(new Color(0, 0, 0));
		btn_login.setBackground(new Color(220, 220, 220));
		btn_login.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 17));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ex01Login(result);
				frame.dispose();
			}
		});
		btn_login.setBounds(375, 427, 180, 70);
		frame.getContentPane().add(btn_login);

		JButton btn_company = new JButton("\uAC70\uB798\uCC98\uAD00\uB9AC");
		btn_company.setForeground(new Color(0, 0, 0));
		btn_company.setBackground(new Color(220, 220, 220));
		btn_company.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 17));
		btn_company.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ex06SupplyManagement(result);
				frame.dispose();
				
			}
		});
		btn_company.setBounds(619, 317, 180, 70);
		frame.getContentPane().add(btn_company);
		btn_company.setVisible(false);

		JButton btn_bom = new JButton("BOM \uAD00\uB9AC");
		btn_bom.setForeground(new Color(0, 0, 0));
		btn_bom.setBackground(new Color(220, 220, 220));
		btn_bom.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 17));
		btn_bom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ex08bom_img(result);
				frame.dispose();

			}
		});
		btn_bom.setBounds(128, 427, 180, 70);
		frame.getContentPane().add(btn_bom);
		btn_bom.setVisible(false);

		JButton btn_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_logout.setForeground(new Color(0, 0, 0));
		btn_logout.setBackground(new Color(220, 220, 220));
		btn_logout.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 17));
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ex01Login(result);
				frame.dispose();

			}
		});
		btn_logout.setBounds(375, 427, 180, 70);
		frame.getContentPane().add(btn_logout);
		JButton btn_stock = new JButton("\uC7AC\uACE0 \uAD00\uB9AC");
		btn_stock.setForeground(new Color(0, 0, 0));
		btn_stock.setBackground(new Color(220, 220, 220));
		btn_stock.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 17));
		btn_stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ex11stock_status(result);
				frame.dispose();
			}
		});
		btn_stock.setBounds(619, 427, 180, 70);
		frame.getContentPane().add(btn_stock);
		btn_stock.setVisible(false);
		
		btn_logout.setVisible(false);

		if (result != null) {
			btn_order.setVisible(true);
			btn_status.setVisible(true);
			btn_login.setVisible(false);
			btn_logout.setVisible(true);
			btn_company.setVisible(true);
			btn_bom.setVisible(true);
			btn_stock.setVisible(true);
//			lbl_title.setText(result.getName()+"´Ô È¯¿µÇÕ´Ï´Ù~");

		}
	}
}
