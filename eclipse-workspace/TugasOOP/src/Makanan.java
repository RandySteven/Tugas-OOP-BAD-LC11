
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

}
