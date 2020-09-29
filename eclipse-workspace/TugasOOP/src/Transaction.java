
public class Transaction {

	private int item_id;
	private int qty;
	private int total;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public int total(int a, int b) {
		return a * b;
	}
	public int getTotal() {
		return total;
	}
	public Transaction(int item_id, int qty, int total) {
		super();
		this.item_id = item_id;
		this.qty = qty;
		this.total = total;
	}

	
}
