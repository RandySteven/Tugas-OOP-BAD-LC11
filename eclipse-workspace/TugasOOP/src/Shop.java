import java.util.List;

public class Shop {

	private List<Makanan> makananList;
	private List<Minuman> minumanList;
	private int moneyEarned;
	
	public void addMakanan(Makanan makanan) {
		makananList.add(makanan);
	}
	public void addMinuman(Minuman minuman) {
		minumanList.add(minuman);
	}
	public List<Makanan> getMakananList() {
		return makananList;
	}
	public void setMakananList(List<Makanan> makananList) {
		this.makananList = makananList;
	}
	public List<Minuman> getMinumanList() {
		return minumanList;
	}
	public void setMinumanList(List<Minuman> minumanList) {
		this.minumanList = minumanList;
	}
	public int getMoneyEarned() {
		return moneyEarned;
	}
	public void setMoneyEarned(int moneyEarned) {
		this.moneyEarned = moneyEarned;
	}
	public void updateMoneyEarned(int moneyEarned) {
		this.moneyEarned += moneyEarned;
	}
	
	public Shop(List<Makanan> makananList, List<Minuman> minumanList, int moneyEarned) {
		super();
		this.makananList = makananList;
		this.minumanList = minumanList;
		this.moneyEarned = moneyEarned;
	}

	
}
