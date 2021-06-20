package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DAO;
import Model.DTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ex09mgm {

	private JFrame frame;
	private JTable table;
	private DTO result;
	private DTO result1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex09mgm window = new ex09mgm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ex09mgm() {
		initialize();
	}

	public ex09mgm(DTO result) {

		this.result = result; // 반드시 initialize 전에 코드 쓸것
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0,0,924,571);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("BOM \uAD00\uB9AC");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 23));
		lblNewLabel.setBounds(35, 25, 200, 51);	
		panel.add(lblNewLabel);

		JButton btn_delete = new JButton("\uC0AD\uC81C\uD558\uAE30");
		btn_delete.setForeground(new Color(0, 0, 0));
		btn_delete.setBackground(new Color(220, 220, 220));
		btn_delete.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_delete.setBounds(209, 465, 190, 50);
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				
				DefaultTableModel tm = (DefaultTableModel)table.getModel();
                if(row >= 0 && row <table.getRowCount()) {
                	tm.removeRow(row);
                }
				
			}
		});
		panel.add(btn_delete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 87, 761, 355);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println(table.getSelectedRow());
			}
		});
		scrollPane.setViewportView(table);
		frame.setBounds(500, 250, 940, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DAO dao = new DAO();
		ArrayList<DTO> result = dao.bomManagement();

		String[] columns = { "품번", "물품번호", "물품명", "거래처명", "가격", "재고" };
		Object[][] data = new Object[result.size()][columns.length];

		for (int i = 0; i < data.length; i++) {
			data[i][0] = result.get(i).getPdNo();
			data[i][1] = result.get(i).getItemNo();
			data[i][2] = result.get(i).getItemName();
			data[i][3] = result.get(i).getSupplyName();
			data[i][4] = result.get(i).getPrice();
			data[i][5] = result.get(i).getStock();
		}

		DefaultTableModel model = new DefaultTableModel(data, columns);

		table.setModel(model);
		
		JButton btn_back = new JButton("\uC774\uC804\uC73C\uB85C");
		btn_back.setForeground(new Color(0, 0, 0));
		btn_back.setBackground(new Color(220, 220, 220));
		btn_back.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_back.setBounds(443, 465, 190, 50);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ex08bom_img(result1);
				frame.dispose();
			}
		});
		panel.add(btn_back);

	}
}
