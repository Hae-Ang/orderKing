package View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.DAO;
import Model.DTO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ex04Auto {

	private JFrame frame;
	private JLabel lbl_wantedQty;
	private JButton btn_ok;
	private JTextField txt_wantedQty;
	private JTextField txt_pdNo;
	private JTable table;
	private String search = "";
	private DTO result;
	private DTO result1;
    private int totalPrice;
    private int totalStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex04Auto window = new ex04Auto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ex04Auto() {
		initialize();
	}

	public ex04Auto(DTO result) {
	      
	      this.result = result; //반드시 initialize 전에 코드 쓸것
	      initialize();
	      frame.setVisible(true);
	   }
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.setBounds(500,300, 940, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_auto = new JLabel("\uBC1C\uC8FC\uD558\uAE30");
		lbl_auto.setForeground(new Color(0, 0, 0));
		lbl_auto.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 23));
		lbl_auto.setBounds(35, 25, 200, 51);
		frame.getContentPane().add(lbl_auto);
		
		JLabel lbl_pdNo = new JLabel("\uD488   \uBC88");
		lbl_pdNo.setForeground(new Color(0, 0, 0));
		lbl_pdNo.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lbl_pdNo.setBounds(103, 98, 57, 51);
		frame.getContentPane().add(lbl_pdNo);
		
		JButton btn_order = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btn_order.setForeground(new Color(0, 0, 0));
		btn_order.setBackground(new Color(220, 220, 220));
		btn_order.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_order.setBounds(282, 456, 190, 50);
		btn_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 팝업창 띄우기(외우기)
				JOptionPane.showMessageDialog(null, "주문 완료!","주문 완료", JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		frame.getContentPane().add(btn_order);
		
		JLabel lbl_totalPrice = new JLabel("");
		lbl_totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_totalPrice.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lbl_totalPrice.setForeground(new Color(0, 0, 0));
		lbl_totalPrice.setBounds(748, 98, 85, 51);
		frame.getContentPane().add(lbl_totalPrice);
		
		JLabel lbl_img = new JLabel("New label");
		lbl_img.setBounds(56, 153, 209, 289);
		frame.getContentPane().add(lbl_img);
		
		   // 이미지 넣는 방법(사이즈 조절)
					// 현재 내 클래스가 저장되어있는 경로를 가지고 오는 방법
					String url = getClass().getResource("").getPath();
					System.out.println(url);
					String realUrl = url + "img/outer.jpg";

					// 사이즈 조절할 수 있게끔 이미지 변환
					Image temp = new ImageIcon(realUrl).getImage();
					// 사이즈 조절(넓이, 높이, 픽셀값)
					// gif -> Image.SCALE_DEFAULT
					// 멈춰있는 이미지 -> Image.SCALE_SMOOTH
					ImageIcon img = new ImageIcon(temp.getScaledInstance(209, 289, Image.SCALE_SMOOTH));
					lbl_img.setIcon(img);
					lbl_img.setVisible(false);
					
//					if() {
//						조회를 눌렀을 때 lbl_img.setVisible(true);
//					}
					
		
		lbl_wantedQty = new JLabel("\uC218   \uB7C9");
		lbl_wantedQty.setForeground(new Color(0, 0, 0));
		lbl_wantedQty.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lbl_wantedQty.setBounds(382, 105, 57, 38);
		frame.getContentPane().add(lbl_wantedQty);
		
		JButton btn_ok = new JButton("\uC870\uD68C");
		btn_ok.setForeground(new Color(0, 0, 0));
		btn_ok.setBackground(new Color(220, 220, 220));
		btn_ok.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_ok.setBounds(278, 105, 79, 38);	
		btn_ok.addMouseListener(new MouseAdapter() {// -----------------------검색창 --------------------------
	  @Override
		  public void mouseClicked(MouseEvent e) { // -----------------------서치 --------------------------
		 search = txt_pdNo.getText();
		 DTO sch = new DTO(search);
		 DAO dao = new DAO();
				ArrayList<DTO> result = dao.search1(sch);
					
				int sum =0;
				int stock =0;
				String[] columns = {"품번","물품번호","물품명","거래처명","가격","수량","재고"};
				Object [][] data = new Object[result.size()][columns.length];		
					for (int i = 0; i < result.size(); i++) {
							data[i][0] = result.get(i).getPdNo();
							data[i][1] =result.get(i).getItemNo();
							data[i][2] = result.get(i).getItemName();
							data[i][3] = result.get(i).getSupplyName();
							data[i][4] = result.get(i).getPrice();
							data[i][5] = result.get(i).getItemQty();
							data[i][6] = result.get(i).getStock();
							
							sum += result.get(i).getPrice() * result.get(i).getItemQty();
							 stock = result.get(i).getStock();
						}	
					
					totalPrice = sum;
						DefaultTableModel model = new DefaultTableModel(data, columns);
						table.setModel(model);
						
					totalStock = stock;	
						//totalprice 문자열로 바꿈
		                  lbl_totalPrice.setText(""+sum);
		                  lbl_img.setVisible(true);
				
			}
		});
		frame.getContentPane().add(btn_ok);
		
		txt_wantedQty = new JTextField();
		txt_wantedQty.setBounds(432, 105, 115, 38);
		txt_wantedQty.setColumns(10);
		frame.getContentPane().add(txt_wantedQty);
		
		txt_pdNo = new JTextField();
		txt_pdNo.setFont(new Font("굴림", Font.PLAIN, 15));
		txt_pdNo.setBounds(151, 105, 115, 38);
		txt_pdNo.setColumns(10);
		frame.getContentPane().add(txt_pdNo);
		
		JButton btn_cal = new JButton("\uACC4\uC0B0");
		btn_cal.setForeground(new Color(0, 0, 0));
		btn_cal.setBackground(new Color(220, 220, 220));
		btn_cal.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_cal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int totalPrice = Integer.parseInt(lbl_totalPrice.getText());
	            int wantedQty = Integer.parseInt(txt_wantedQty.getText());
	           
	            
	            int sum = totalPrice* (wantedQty-totalStock);
	            lbl_totalPrice.setText(""+sum); //최종 합계
	            
			}
		});
		btn_cal.setBounds(563, 104, 83, 38);
		frame.getContentPane().add(btn_cal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 153, 581, 289);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	////1.데이터베이스에 접근해서 모든 회원정보 가져오기
				DAO dao = new DAO(); //도구생성
				ArrayList<DTO> result =dao.allSelect();
			
			
			//// 2.테이블에 데이터 넣어주기
			////테이블에 넣을수있는 데이터 타입
				String[] columns = {"품번","물품번호","물품이름","거래처","가격","수량","재고"};
				Object [][] data = new Object[result.size()][columns.length];		
				for (int i = 0; i < result.size(); i++) {
					data[i][0] = result.get(i).getPdNo();
					data[i][1] =result.get(i).getItemNo();
					data[i][2] = result.get(i).getItemName();
					data[i][3] = result.get(i).getSupplyName();
					data[i][4] = result.get(i).getPrice();
					data[i][5] = result.get(i).getItemQty();
					data[i][6] = result.get(i).getStock();
					
				}	
				DefaultTableModel model = new DefaultTableModel(data, columns);
				table.setModel(model);
				
				JLabel lblNewLabel = new JLabel("\uCD1D \uAE08 \uC561  : ");
				lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
				lblNewLabel.setForeground(new Color(0, 0, 0));
				lblNewLabel.setBounds(684, 98, 85, 51);
				frame.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("\uC6D0");
				lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
				lblNewLabel_1.setForeground(new Color(0, 0, 0));
				lblNewLabel_1.setBounds(842, 98, 85, 51);
				frame.getContentPane().add(lblNewLabel_1);
				
				JButton btn_m = new JButton("\uCC98\uC74C\uC73C\uB85C");
				btn_m.setForeground(new Color(0, 0, 0));
				btn_m.setBackground(new Color(220, 220, 220));
				btn_m.setFont(new Font("나눔고딕", Font.PLAIN, 15));
				btn_m.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ex03mmain(result1);
						frame.dispose();
						
					}
				});
				btn_m.setBounds(488, 456, 190, 50);
				frame.getContentPane().add(btn_m);
					
			}
}
