package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.DAO;
import Model.DTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ex05order_status {

	private JFrame frame;
	private JTextField txt_Search;
	private JTable table;
	private DTO dto;
	private DTO result;
	private DTO result1;
	private String search = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex05order_status window = new ex05order_status();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ex05order_status() {
		initialize();
	}
	
	public ex05order_status(DTO result) {
	      
	      this.result = result; //반드시 initialize 전에 코드 쓸것
	      initialize();
	      frame.setVisible(true);
	   }
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 940,610); // 16 39
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 924, 571);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txt_Search = new JTextField();
		txt_Search.setFont(new Font("굴림", Font.PLAIN, 15));
		txt_Search.setBounds(147, 105, 115, 38);
		panel.add(txt_Search);
		txt_Search.setColumns(10);

		JLabel lbl_title = new JLabel("\uC8FC\uBB38\uD604\uD669");
		lbl_title.setForeground(new Color(0, 0, 0));
		lbl_title.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 23));
		lbl_title.setBounds(35, 25, 200, 51);
		panel.add(lbl_title);

		JLabel lbl_pdNo = new JLabel("\uD488   \uBC88");
		lbl_pdNo.setForeground(new Color(0, 0, 0));
		lbl_pdNo.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lbl_pdNo.setBounds(98, 98, 57, 51);
		panel.add(lbl_pdNo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 153, 746, 289);
		panel.add(scrollPane);

		table = new JTable();

		DAO dao = new DAO();
		ArrayList<DTO> result = dao.orderStatus();

		String[] columns = { "품번", "발주날짜", "거래처명", "물품번호", "물품명", "수량", "총가격", "납기일" };

		Object[][] data = new Object[result.size()][columns.length];
		for (int i = 0; i < result.size(); i++) {

			data[i][0] = result.get(i).getPdNo();
			data[i][1] = result.get(i).getOrderDate();
			data[i][2] = result.get(i).getSupplyName();
			data[i][3] = result.get(i).getItemNo();
			data[i][4] = result.get(i).getItemName();
			data[i][5] = result.get(i).getItemQty();
			data[i][6] = result.get(i).getTotalPrice();
			data[i][7] = result.get(i).getShipped();

		}

		DefaultTableModel model = new DefaultTableModel(data, columns);

		table.setModel(model);

		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(55);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(110);

		scrollPane.setViewportView(table);

		// order_status 검색기능
	      JButton btn_ok = new JButton("\uC870\uD68C");
	      btn_ok.setForeground(new Color(0, 0, 0));
			btn_ok.setBackground(new Color(220, 220, 220));
			btn_ok.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			btn_ok.setBounds(274, 104, 79, 38);	
	      btn_ok.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	            
	            // 검색어 txt_Search에서 getText를 하여 search에 저장
	            search = txt_Search.getText();
	            // DTO에 있는 search 생성자를 불러오고
	            DTO sch = new DTO(search);
	            // dao를 부러오고
	            DAO dao = new DAO();
	            // list는 dao의 search클래스를(아까 저장된 search를 불러옴)
	            ArrayList<DTO> list = dao.order_search(sch);
	            String[] columns = { "품번", "발주날짜", "업체명", "아이템No", "아이템이름", "수량", "총가격", "납기일" };
	            Object[][] data = new Object[list.size()][columns.length];

	            for (int i = 0; i < list.size(); i++) {
	               
	               data[i][0] = list.get(i).getPdNo();
	               data[i][1] = list.get(i).getOrderDate();
	               data[i][2] = list.get(i).getSupplyName();
	               data[i][3] = list.get(i).getItemNo();
	               data[i][4] = list.get(i).getItemName();
	               data[i][5] = list.get(i).getItemQty();
	               data[i][6] = list.get(i).getTotalPrice();
	               data[i][7] = list.get(i).getShipped();
	               
	            }
	            
	            DefaultTableModel model = new DefaultTableModel(data, columns);
	               table.setModel(model);
	            
	         }
	      });
	     
	      panel.add(btn_ok);
	      
	      JButton btn_allok = new JButton("\uC804\uCCB4\uC870\uD68C");
	      btn_allok.setForeground(new Color(0, 0, 0));
			btn_allok.setBackground(new Color(220, 220, 220));
			btn_allok.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			btn_allok.setBounds(365, 104, 104, 38);
	      btn_allok.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		
	      		DAO dao = new DAO();
	    		ArrayList<DTO> result = dao.orderStatus();

	    		String[] columns = { "품번", "발주날짜", "업체명", "아이템No", "아이템이름", "수량", "총가격", "납기일" };

	    		Object[][] data = new Object[result.size()][columns.length];
	    		for (int i = 0; i < result.size(); i++) {

	    			data[i][0] = result.get(i).getPdNo();
	    			data[i][1] = result.get(i).getOrderDate();
	    			data[i][2] = result.get(i).getSupplyName();
	    			data[i][3] = result.get(i).getItemNo();
	    			data[i][4] = result.get(i).getItemName();
	    			data[i][5] = result.get(i).getItemQty();
	    			data[i][6] = result.get(i).getTotalPrice();
	    			data[i][7] = result.get(i).getShipped();

	    		}

	    		DefaultTableModel model = new DefaultTableModel(data, columns);

	    		table.setModel(model);

	    		scrollPane.setViewportView(table);
	      		
	      	}
	      });
	     
	      panel.add(btn_allok);
	      
	      JButton btn_m = new JButton("\uCC98\uC74C\uC73C\uB85C");
	      btn_m.setForeground(new Color(0, 0, 0));
			btn_m.setBackground(new Color(220, 220, 220));
			btn_m.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			btn_m.setBounds(365, 466, 190, 50);
	      btn_m.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		
	      		new ex03mmain (result1);
	      		frame.dispose();
	      	}
	      });
	      panel.add(btn_m);
	}
}
