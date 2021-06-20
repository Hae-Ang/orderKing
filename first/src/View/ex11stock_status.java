package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.Color;

public class ex11stock_status {

	private JFrame frame;
	private JTextField txt_Search;
	private JTable table;

	private String search = "";
	private DTO result;
	private DTO result1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex11stock_status window = new ex11stock_status();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ex11stock_status() {
		initialize();
	}
	
	public ex11stock_status(DTO result) {
		this.result = result;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 940,610); // 16 39
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 924, 571);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txt_Search = new JTextField();
		txt_Search.setFont(new Font("굴림", Font.PLAIN, 15));
		txt_Search.setBounds(151, 99, 106, 38);
		panel.add(txt_Search);
		txt_Search.setColumns(10);

		JLabel lbl_title = new JLabel("\uC7AC\uACE0 \uAD00\uB9AC");
		lbl_title.setForeground(new Color(0, 0, 0));
		lbl_title.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 23));
		lbl_title.setBounds(35, 25, 200, 51);	
		panel.add(lbl_title);

		JLabel lbl_btnName = new JLabel("\uD488     \uBC88");
		
		lbl_btnName.setForeground(new Color(0, 0, 0));
		lbl_btnName.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lbl_btnName.setBounds(79, 92, 57, 51);
		
		panel.add(lbl_btnName);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 153, 770, 291);
		panel.add(scrollPane);

		table = new JTable();
		DAO dao = new DAO();
		ArrayList<DTO> result = dao.stockStatus();

		String[] columns = { "물품번호", "물품명", "거래처명", "재고" };
		Object[][] data = new Object[result.size()][columns.length];
		
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getStock() > 0) {
				data[i][0] = result.get(i).getItemNo();
				data[i][1] = result.get(i).getItemName();
				data[i][2] = result.get(i).getSupplyName();
				data[i][3] = result.get(i).getStock();
			}

		}

		DefaultTableModel model = new DefaultTableModel(data, columns);

		table.setModel(model);
		scrollPane.setViewportView(table);

		// 검색 기능
		JButton btn_ok = new JButton("\uC870\uD68C");
		btn_ok.setForeground(new Color(0, 0, 0));
		btn_ok.setBackground(new Color(220, 220, 220));
		btn_ok.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_ok.setBounds(269, 98, 79, 38);	
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
				ArrayList<DTO> list = dao.search2(sch);
				String[] columns = { "물품번호", "물품이름", "거래처명", "재고" };
				Object[][] data = new Object[list.size()][columns.length];

				for (int i = 0; i < list.size(); i++) {
					data[i][0] = list.get(i).getItemNo();
					data[i][1] = list.get(i).getItemName();
					data[i][2] = list.get(i).getSupplyName();
					data[i][3] = list.get(i).getStock();
				}

				DefaultTableModel model = new DefaultTableModel(data, columns);
	            table.setModel(model);

			}
		});
		
		panel.add(btn_ok);
		
		JButton btn_m = new JButton("\uCC98\uC74C\uC73C\uB85C");
		btn_m.setForeground(new Color(0, 0, 0));
		btn_m.setBackground(new Color(220, 220, 220));
		btn_m.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_m.setBounds(340, 460, 190, 50);
		btn_m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			new ex03mmain(result1);
			frame.dispose();
			
			}
		});
		panel.add(btn_m);
	}

}
