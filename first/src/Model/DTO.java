package Model;

public class DTO {
	private String id;
	private String pw;
	private String empName;
	private String cpName;
	private String pdNo;
	private String itemNo;
	private String itemName;
	private String supplyName;
	private int price;
	private int stock;
	private int itemQty;
	private String search;






	private int wantedQty;
	private String orderDate;
	private int totalPrice;
	private String shipped;
	private String supplyCode; 
	private String admin; 
	private String email; 
	private String ph; 
	private String address; 
	private String crno; 
	private String remark;

	// 芭贰贸 积己磊
	public DTO(String supplyCode, String supplyName, String admin, String email, String ph, String address,
			String crno, String remark) {
		this.supplyCode = supplyCode;
		this.supplyName = supplyName;
		this.admin = admin;
		this.email = email;
		this.ph = ph;
		this.address = address;
		this.crno = crno;
		this.remark = remark;
	}
	
	public String getSupplyCode() {
		return supplyCode;
	}

	public void setSupplyCode(String supplyCode) {
		this.supplyCode = supplyCode;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCrno() {
		return crno;
	}

	public void setCrno(String crno) {
		this.crno = crno;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	// 惯林泅炔 积己磊
		public DTO(String pdNo, String orderDate, String supplyName, String itemNo, String itemName, int itemQty, int totalPrice,
				String shipped) {

			this.pdNo = pdNo;
			this.orderDate = orderDate;
			this.supplyName = supplyName;
			this.itemNo = itemNo;
			this.itemName = itemName;
			this.itemQty = itemQty;
			this.totalPrice = totalPrice;
			this.shipped = shipped;
			
		}

		// 犁绊包府 积己磊
		public DTO(String itemNo, String itemName, String supplyName, int stock) {

			this.itemNo = itemNo;
			this.supplyName = supplyName;
			this.itemName = itemName;
			this.stock = stock;
			
		}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShipped() {
		return shipped;
	}

	public void setShipped(String shipped) {
		this.shipped = shipped;
	}

	
	public DTO(int wantedQty) {
		this.wantedQty = wantedQty;
	}

	public int getWantedQty() {
		return wantedQty;
	}

	public void setWantedQty(int wantedQty) {
		this.wantedQty = wantedQty;
	}

	   
	   public DTO(String search) {
	      this.search = search;
	   }

	   public String getSearch() {
	      return search;
	   }

	   public void setSearch(String search) {
	      this.search = search;
	   }
	   
	 //bom眠啊 积己磊
		public DTO(String pdNo, String itemNo, String itemName, String supplyName, int price, int itemQty, int stock) {
		
		this.pdNo = pdNo;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.supplyName = supplyName;
		this.price = price;
		this.itemQty = itemQty;
		this.stock = stock;
	}
	   

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	// bom包府 积己磊
	public DTO(String pdNo, String itemNo, String itemName, String supplyName, int price, int stock) {
		this.pdNo = pdNo;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.supplyName = supplyName;
		this.price = price;
		this.stock = stock;
	}

	public String getPdNo() {
		return pdNo;
	}

	public void setPdNo(String pdNo) {
		this.pdNo = pdNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSupplyName() {
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	//肺弊牢 积己磊
	public DTO(String id, String pw, String empName, String cpName) {
		this.id = id;
		this.pw = pw;
		this.empName = empName;
		this.cpName = cpName;
	}

	public DTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
