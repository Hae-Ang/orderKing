package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Model.DTO;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ex08bom_img {

	private JFrame frame;
	private DTO result;
	private DTO result1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex08bom_img window = new ex08bom_img();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ex08bom_img() {
		initialize();
	}
	
	public ex08bom_img(DTO result) {
		this.result = result;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.setBounds(400, 250, 940,672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btn_outer = new JButton("");
		btn_outer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ex09mgm(result);
				frame.dispose();
			}
		});
		btn_outer.setBackground(Color.GRAY);
		btn_outer.setBounds(149, 106, 195, 195);
		frame.getContentPane().add(btn_outer);
		
		//이미지 넣는 방법(사이즈 조절)
		String url = getClass().getResource("").getPath();
		System.out.println(url);
		
String realUrl= url + "img/outer.jpg";
		
		//사이즈 조절할 수 있게끔 이미지 변환
		Image temp = new ImageIcon(realUrl).getImage();
		//사이즈 조절(넓이,높이,픽셀값)
		//gif--Image.SCALE_DEFAULT
		//멈춰있는 이미지 -- Image.SCALE_SMOOTH
		ImageIcon outer = new ImageIcon(temp.getScaledInstance(195, 195, Image.SCALE_SMOOTH));
		
		btn_outer.setIcon(outer);
//	---------------------------------------------------------------------------------------------
			JButton btn_img2 = new JButton("");
			btn_img2.addMouseListener(new MouseAdapter() {
			});
		btn_img2.setBackground(Color.GRAY);
		btn_img2.setBounds(361, 106, 195, 195);
		frame.getContentPane().add(btn_img2);
		
		String url2 = getClass().getResource("").getPath();
		System.out.println(url2);
		String realUrl2= url2 + "img/img2.jpg";
		Image temp2 = new ImageIcon(realUrl2).getImage();
		ImageIcon img2 = new ImageIcon(temp2.getScaledInstance(195, 195, Image.SCALE_SMOOTH));
		btn_img2.setIcon(img2);
		
//------------------------------------------------------------------------------------------------------		
		JButton btn_img3 = new JButton("");
		btn_img3.setBackground(Color.WHITE);
		btn_img3.setBounds(573, 106, 195, 195);
		frame.getContentPane().add(btn_img3);
		
		String url3 = getClass().getResource("").getPath();
		System.out.println(url3);
		String realUrl3= url3 + "img/img3.jpg";
		Image temp3 = new ImageIcon(realUrl3).getImage();
		ImageIcon img3 = new ImageIcon(temp3.getScaledInstance(195, 195, Image.SCALE_SMOOTH));
		btn_img3.setIcon(img3);
		
		
		
		
//----------------------------------------------------------------------------------------------		
		JButton btn_img4 = new JButton("");
		btn_img4.setBackground(Color.WHITE);
		btn_img4.setBounds(149, 318, 195, 195);
		frame.getContentPane().add(btn_img4);
		
		String url4 = getClass().getResource("").getPath();
		System.out.println(url4);
		String realUrl4= url4 + "img/img4.jpg";
		Image temp4 = new ImageIcon(realUrl4).getImage();
		ImageIcon img4 = new ImageIcon(temp4.getScaledInstance(195, 195, Image.SCALE_SMOOTH));
		btn_img4.setIcon(img4);
		
//-------------------------------------------------------------------------------------------------		
		
		JButton btn_img5 = new JButton("");
		btn_img5.setBackground(Color.WHITE);
		btn_img5.setBounds(361, 318, 195, 195);
		frame.getContentPane().add(btn_img5);
		
		String url5 = getClass().getResource("").getPath();
		System.out.println(url5);
		String realUrl5= url5 + "img/img5.jpg";
		Image temp5 = new ImageIcon(realUrl5).getImage();
		ImageIcon img5 = new ImageIcon(temp5.getScaledInstance(195, 195, Image.SCALE_SMOOTH));
		btn_img5.setIcon(img5);
		
//=====---------------------------------------------------------------------------------------------------		
		
		JButton btn_img6 = new JButton("");
		btn_img6.setBackground(Color.WHITE);
		btn_img6.setBounds(573, 318, 195, 195);
		frame.getContentPane().add(btn_img6);
		
	
		String url6 = getClass().getResource("").getPath();
		System.out.println(url6);
		String realUrl6= url6 + "img/img6.jpg";
		Image temp6 = new ImageIcon(realUrl6).getImage();
		ImageIcon img6 = new ImageIcon(temp6.getScaledInstance(195, 195, Image.SCALE_SMOOTH));
		btn_img6.setIcon(img6);
		
		JButton btn_add = new JButton("\uCD94\uAC00\uD558\uAE30");
		btn_add.setForeground(new Color(0, 0, 0));
		btn_add.setBackground(new Color(220, 220, 220));
		btn_add.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_add.setBounds(261, 530, 190, 50);
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ex10Bom_add(result);
				
			}
		});
		frame.getContentPane().add(btn_add);
		
		JButton btn_m = new JButton("\uCC98\uC74C\uC73C\uB85C");
		btn_m.setForeground(new Color(0, 0, 0));
		btn_m.setBackground(new Color(220, 220, 220));
		btn_m.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_m.setBounds(468, 530, 190, 50);
		btn_m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ex03mmain(result1);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_m);
		
		JLabel lblNewLabel = new JLabel("BOM \uAD00\uB9AC");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 23));
		lblNewLabel.setBounds(35, 25, 200, 51);		
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
		
	}
}
