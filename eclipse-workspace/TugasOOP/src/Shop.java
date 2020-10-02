public class Shop {

	private int moneyEarned;
	
	public int getMoneyEarned() {
		return moneyEarned;
	}
	public void setMoneyEarned(int moneyEarned) {
		this.moneyEarned = moneyEarned;
	}
	public void updateMoneyEarned(int moneyEarned) {
		this.moneyEarned += moneyEarned;
	}
	
	public Shop(int moneyEarned) {
		super();
		this.moneyEarned = moneyEarned;
	}

}
