
public class Minuman extends Item{

	public Minuman(int id, String name, int price, int stock, int liter) {
		super(id, name, price, stock);
		this.liter = liter;
	}

	private int liter;

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}
	
	

}
