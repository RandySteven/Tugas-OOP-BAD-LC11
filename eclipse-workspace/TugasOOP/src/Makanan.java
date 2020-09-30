
public class Makanan extends Item{

	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Makanan(int id, String name, int price, int stock, int weight) {
		super(id, name, price, stock);
		this.weight = weight;
	}

	@Override
	public void minStock(int stock) {
		this.stock -= stock;
	}
	
	public void updateStock(int stock) {
		this.stock += stock;
	}
}
