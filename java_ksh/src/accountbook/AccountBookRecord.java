package accountbook;

public class AccountBookRecord {
	private boolean incomeExpense; 
	private String date;
	private String asset; // 현금, 은행, 카드
	private String Category; // 식비, 교통, 건강
	private int money;
	private String detail;
	public boolean isIncomeExpense() {
		return incomeExpense;
	}
	public void setIncomeExpense(boolean incomeExpense) {
		this.incomeExpense = incomeExpense;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public AccountBookRecord(boolean incomeExpense, String date, String asset, String category, int money,
			String detail) {
		this.incomeExpense = incomeExpense;
		this.date = date;
		this.asset = asset;
		Category = category;
		this.money = money;
		this.detail = detail;
	}
	
	
}
