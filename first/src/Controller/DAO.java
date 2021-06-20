package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.DTO;

public class DAO {
	// MVV -> Controller 역할 담당
	// DataVase Access Object
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private DTO result = null;
	int result1 = 0;

	// 데이터베이스 연결하는 메소드
	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr2";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 데이터베이스 연결 해제 메소드
	private void getClose() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DTO login(DTO dto) {

		try {
			// 1.연결
			getConnection();

			// 2.Query문 작성, 전송
			String sql = "select * from login where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);

			// 물음표 인자 채우기
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			// SQL문 전송
			rs = psmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String cpName = rs.getString("cpname");
				String empName = rs.getString("empname");

				result = new DTO(id, pw, empName, cpName);
			}
			// 결과를 받아오는 작업

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return result;
	}

	// BOM관리 - 전체조회 => 바꿔야함 선택 조회로
	public ArrayList<DTO> bomManagement() {

		ArrayList<DTO> result = new ArrayList<DTO>();

		try {
			getConnection();

			String sql = "select pdNo, itemNo, itemName, supplyName, price, stock from item where pdno = 'no_1'";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String pdNo = rs.getString("pdNo");
				String itemNo = rs.getString("itemNo");
				String itemName = rs.getString("itemName");
				String supplyName = rs.getString("supplyName");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");

				result.add(new DTO(pdNo, itemNo, itemName, supplyName, price, stock));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return result;

	}

	// bom 선택조회

	public ArrayList<DTO> search(DTO sr) {
		ArrayList<DTO> list = new ArrayList<DTO>();
		try {
			getConnection();
			String sql = "select pdNo, itemNo, itemName, supplyname, price, stock from item where pdNo like ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + sr.getSearch() + "%");
//                psmt.setString(2, "%"+sch.getSearch()+"%");
			rs = psmt.executeQuery();

			while (rs.next()) {
				String pdNo = rs.getString(1);
				String itemNo = rs.getString(2);
				String itemName = rs.getString(3);
				String supplyName = rs.getString(4);
				int price = rs.getInt(5);
				int itemQty = rs.getInt(6);
				int stock = rs.getInt(7);
				DTO vo = new DTO(pdNo, itemNo, itemName, supplyName, price, stock);

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return list;
	}

	// BOM 관리 - 삭제하기 기능
	public int delete(DTO dto) {
		int result = 0;

		try {
			getConnection();
			// 2. Query문 작성, 전송
			String sql = "delete from item where pdno = ?";
			psmt = conn.prepareStatement(sql);

			// ? 인자 채우고 데이터 베이스에 전송하기
			// 닫는 작업까지 마무리
			//
			psmt.setString(1, dto.getPdNo());
			result = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();

		}
		return result;

	}

	// 자동발주
	public ArrayList<DTO> auto() {

		ArrayList<DTO> result = new ArrayList<DTO>();

		try {
			getConnection();

			String sql = "select pdNo, itemNo, itemName, supplyName, price, itemQty, stock from item";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String pdNo = rs.getString("pdNo");
				String itemNo = rs.getString("itemNo");
				String itemName = rs.getString("itemName");
				String supplyName = rs.getString("supplyName");
				int price = rs.getInt("price");
				int itemQty = rs.getInt("itemQty");
				int stock = rs.getInt("stock");

				result.add(new DTO(pdNo, itemNo, itemName, supplyName, price, itemQty, stock));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return result;

	}

	// 1. bom추가 메소드
	public int insert(DTO dto) {
		int result = 0;
		try {
			// 1.데이터 베이스 연결
			getConnection();

			// 2. Query문 작성, 전송
			String sql = "insert into item(pdNo,itemNo, itemName, supplyName, price, itemQty, stock) values(?,?,?,?,?,?,?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPdNo());
			psmt.setString(2, dto.getItemNo());
			psmt.setString(3, dto.getItemName());
			psmt.setString(4, dto.getSupplyName());
			psmt.setInt(5, dto.getPrice());
			psmt.setInt(6, dto.getItemQty());
			psmt.setInt(7, dto.getStock());

			// 행에 영향을 끼치는 insert,update,delete -> executeUpdate
			result = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return result;

	}

//allselect
	public ArrayList<DTO> allSelect() {
		ArrayList<DTO> result = new ArrayList<DTO>();

		try {
			// 데이터베이스 연결
			getConnection();
			// Sql문장 준비, 전송
			String sql = "select *from item";
			// sql문장 담아줘야합니다.
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			// rs는 테이블(행과 열을 갖는)과 같은 형태를 띄운다.
			while (rs.next()) {

				String pdNo = rs.getString("pdNo");
				String itemNo = rs.getString("itemNo");
				String itemName = rs.getString("itemName");
				String supplyName = rs.getString("supplyName");
				int price = rs.getInt("price");
				int itemQty = rs.getInt("itemQty");
				int stock = rs.getInt("stock");
				result.add(new DTO(pdNo, itemNo, itemName, supplyName, price, itemQty, stock));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return result;

	}
//search

	public ArrayList<DTO> search1(DTO srr) {
		ArrayList<DTO> list = new ArrayList<DTO>();
		try {
			getConnection();
			String sql = "select pdNo, itemNo, itemName, supplyname, price, itemQty, stock from item where pdNo like ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + srr.getSearch() + "%");
//			         psmt.setString(2, "%"+sch.getSearch()+"%");
			rs = psmt.executeQuery();

			while (rs.next()) {
				String pdNo = rs.getString(1);
				String itemNo = rs.getString(2);
				String itemName = rs.getString(3);
				String supplyName = rs.getString(4);
				int price = rs.getInt(5);
				int itemQty = rs.getInt(6);
				int stock = rs.getInt(7);
				DTO vo = new DTO(pdNo, itemNo, itemName, supplyName, price, itemQty, stock);

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return list;
	}
	// 주문
	public ArrayList<DTO> orderStatus() {

		ArrayList<DTO> result = new ArrayList<DTO>();

		try {
			getConnection();

			String sql = "select o.pdno, o.orderdate, i.supplyname, i.itemno, i.itemname, i.itemqty, o.totalprice, o.shipped "
					+ "from ordering o, item i "
					+ "where o.pdno = i.pdno";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String pdNo = rs.getString("pdNo");
				String orderDate = rs.getString("orderDate");
				String supplyName = rs.getString("supplyName");
				String itemNo = rs.getString("itemno");
				String itemName = rs.getString("itemname");
				int itemQty = rs.getInt("itemqty");
				int totalPrice = rs.getInt("totalPrice");
				String shipped = rs.getString("shipped");

				result.add(new DTO(pdNo, orderDate, supplyName, itemNo, itemName, itemQty, totalPrice, shipped));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return result;

	}


	public ArrayList<DTO> stockStatus() {

		ArrayList<DTO> result = new ArrayList<DTO>();

		try {
			getConnection();

			String sql = "select itemNo, ItemName, supplyname, stock from item";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String itemNo = rs.getString("itemNo");
				String itemName = rs.getString("itemName");
				String supplyName = rs.getString("supplyName");
				int stock = rs.getInt("stock");

				result.add(new DTO(itemNo, itemName, supplyName, stock));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return result;

	}

	// 재고 검색 기능
	public ArrayList<DTO> search2(DTO sch) {

		ArrayList<DTO> list = new ArrayList<DTO>();

		try {
			getConnection();

			// sql문 like활용
			String sql = "select itemno, ItemName, supplyname, stock from item where pdno like ?";

			psmt = conn.prepareStatement(sql);

			// like 를 쓸때 앞뒤로 "%"에 sch.getSearch() 불러옴
			psmt.setString(1, "%" + sch.getSearch() + "%");

			rs = psmt.executeQuery();

			while (rs.next()) {

				String itemNo = rs.getString("itemNo");
				String itemName = rs.getString("itemName");
				String supplyName = rs.getString("supplyName");
				int stock = rs.getInt("stock");

				list.add(new DTO(itemNo, itemName, supplyName, stock));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return list;

	}

	// 
	public void delete1(DTO dto) {

		try {
			getConnection();

			// itemName을 부분 클릭하고 지워야함!!
			String sql = "delete from item where itemName = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getSearch());

			int result = psmt.executeUpdate();

			if (result > 0) {
				System.out.println("데이터베이스 삭제 성공");
			} else {
				System.out.println("데이터베이스 삭제 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

	}

	// 거래처 조회
	public int insert1(DTO sup) {

		try {
			getConnection();
			String sql = "insert into supply values (?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sup.getSupplyCode());
			psmt.setString(2, sup.getSupplyName());
			psmt.setString(3, sup.getAdmin());
			psmt.setString(4, sup.getEmail());
			psmt.setString(5, sup.getPh());
			psmt.setString(6, sup.getAddress());
			psmt.setString(7, sup.getCrno());
			psmt.setString(8, sup.getRemark());
			result1 = psmt.executeUpdate();
			if (result1 != 0) {

				JOptionPane.showMessageDialog(null, "등록되었습니다.", "거래처 추가 완료", JOptionPane.INFORMATION_MESSAGE);

			} else {

				JOptionPane.showMessageDialog(null, "등록에 실패하였습니다.", "거래처 추가 실패", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return result1;
	}

	public ArrayList<DTO> allSelect1() {

		ArrayList<DTO> result = new ArrayList<DTO>();
		try {
			getConnection();
			String sql = "select * from supply";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String supplyCode = rs.getString("supplyCode");
				String supplyName = rs.getString("supplyName");
				String admin = rs.getString("admin");
				String email = rs.getString("email");
				String ph = rs.getString("ph");
				String address = rs.getString("address");
				String crno = rs.getString("crno");
				String remark = rs.getString("remark");
				result.add(new DTO(supplyCode, supplyName, admin, email, ph, address, crno, remark));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return result;
	}

	// bom 관리 삭제
	public void delete_bom(DTO dto) {

		try {
			getConnection();

			// itemName을 부분 클릭하고 지워야함!!
			String sql = "delete from item where pdno = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getSearch());

			int result = psmt.executeUpdate();

			if (result > 0) {
				System.out.println("데이터베이스 삭제 성공");
			} else {
				System.out.println("데이터베이스 삭제 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

	}
	
	public ArrayList<DTO> order_search(DTO sch) {

	      ArrayList<DTO> list = new ArrayList<DTO>();

	      try {
	         getConnection();

	         // sql문 like활용
	         String sql = "select o.pdno, o.orderdate, i.supplyname, i.itemno, i.itemname, i.itemqty, o.totalprice, o.shipped "
	               + "from ordering o, item i "
	               + "where o.pdno like ? and i.pdno like ?";
	         
	         psmt = conn.prepareStatement(sql);

	         // like 를 쓸때 앞뒤로 "%"에 sch.getSearch() 불러옴
	         psmt.setString(1, "%" + sch.getSearch() + "%");
	         psmt.setString(2, "%" + sch.getSearch() + "%");

	         rs = psmt.executeQuery();

	         while (rs.next()) {

	            String pdNo = rs.getString("pdNo");
	            String orderDate = rs.getString("orderDate");
	            String supplyName = rs.getString("supplyName");
	            String itemNo = rs.getString("itemno");
	            String itemName = rs.getString("itemname");
	            int itemQty = rs.getInt("itemqty");
	            int totalPrice = rs.getInt("totalPrice");
	            String shipped = rs.getString("shipped");

	            list.add(new DTO(pdNo, orderDate, supplyName, itemNo, itemName, itemQty, totalPrice, shipped));
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         getClose();
	      }

	      return list;

	   }
	public void deletesup(DTO sup) {

		try {
			getConnection();

			// Supplycode를 부분 클릭하고 지워야함!!
			String sql = "delete from supply where supplycode = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, sup.getSearch());

			int result = psmt.executeUpdate();

			if (result > 0) {
				System.out.println("데이터베이스 삭제 성공");
			} else {
				System.out.println("데이터베이스 삭제 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

	}
}
