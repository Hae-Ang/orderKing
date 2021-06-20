package View;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.DAO;
import Model.DTO;
import javax.swing.JScrollPane;
import java.awt.Color;

public class ex06SupplyManagement {

	JFrame frame;
	private DTO result1;
	private JTable table_sup;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private DTO result;

			public void run() {
				try {
					ex06SupplyManagement window = new ex06SupplyManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ex06SupplyManagement() {
		initialize();
	}

	public ex06SupplyManagement(DTO result1) {
		this.result1 = result1;
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 940, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		frame.getContentPane().add(panel, "name_61996335891700");
		panel.setLayout(null);
		
		JLabel lbl_sup = new JLabel("\uAC70\uB798\uCC98 \uAD00\uB9AC");
		lbl_sup.setForeground(new Color(0, 0, 0));
		lbl_sup.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 23));
		lbl_sup.setBounds(35, 25, 200, 51);
		panel.add(lbl_sup);
		
		JButton btn_add = new JButton("\uCD94\uAC00\uD558\uAE30");
		btn_add.setForeground(new Color(0, 0, 0));
		btn_add.setBackground(new Color(220, 220, 220));
		btn_add.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_add.setBounds(147, 456, 190, 50);
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ex07SupplyAdd();
				frame.dispose();
			}
		});
		panel.add(btn_add);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 106, 761, 336);
		panel.add(scrollPane);
		
		table_sup = new JTable();
		scrollPane.setViewportView(table_sup);

		DAO dao = new DAO();
		ArrayList<DTO> result = dao.allSelect1();
		String[] columns = {"거래처코드", "거래처명", "관리자", "이메일", "연락처", "주소", "사업자번호", "적요"};
		Object[][] data = new Object[result.size()][columns.length];
		for (int i = 0; i < result.size(); i++) {
			data[i][0] = result.get(i).getSupplyCode();
			data[i][1] = result.get(i).getSupplyName();
			data[i][2] = result.get(i).getAdmin();
			data[i][3] = result.get(i).getEmail();
			data[i][4] = result.get(i).getPh();
			data[i][5] = result.get(i).getAddress();
			data[i][6] = result.get(i).getCrno();
			data[i][7] = result.get(i).getRemark();
		}
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table_sup.setModel(model);

		table_sup.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_sup.getColumnModel().getColumn(3).setPreferredWidth(120);
		table_sup.getColumnModel().getColumn(5).setPreferredWidth(90);
		table_sup.getColumnModel().getColumn(7).setPreferredWidth(45);
		
		JButton btn_delete = new JButton("\uC0AD\uC81C\uD558\uAE30");
		btn_delete.setForeground(new Color(0, 0, 0));
		btn_delete.setBackground(new Color(220, 220, 220));
		btn_delete.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_delete.setBounds(349, 456, 190, 50);
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JTable jtable = table_sup;
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "데이터 삭제 경고", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					int row = jtable.getSelectedRow();      // 선택된 테이블의 행값
					int col = jtable.getSelectedColumn();   // 선택된 테이블의 열값
					DTO sup = new DTO((String)(model.getValueAt(row, col))); // 선택된 테이블값의 값을 불러옴
					dao.delete(sup);
					DefaultTableModel tm = (DefaultTableModel)table_sup.getModel();
					if(row >= 0 && row < table_sup.getRowCount()) {
						tm.removeRow(row);
					}
					JOptionPane.showMessageDialog(null, "삭제되었습니다.", "삭제 완료", JOptionPane.INFORMATION_MESSAGE);
				}
					else if(result == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "취소하셨습니다.", "삭제 취소", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		panel.add(btn_delete);
		
		JButton btn_m = new JButton("\uCC98\uC74C\uC73C\uB85C");
		btn_m.setForeground(new Color(0, 0, 0));
		btn_m.setBackground(new Color(220, 220, 220));
		btn_m.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_m.setBounds(551, 456, 190, 50);
		btn_m.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				new ex03mmain (result1);
	      		frame.dispose();
				
			}
		});
		panel.add(btn_m);
	}
		}

