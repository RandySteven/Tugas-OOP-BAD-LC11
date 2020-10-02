import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	String name;
	int price, stock, weight, liter, qty, total, item_id, input;
	int id = 0;
	Makanan makanan;
	Minuman minuman;
	Item item;
	Item itemNew;
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	String pilihan = "";
	Vector<Item> itemList = new Vector<>();
	int moneyEarned = 0;
	Transaction transaction = new Transaction(item_id, qty, total);
	Vector<Transaction> transactionList = new Vector<>();
	Shop shop;
	void add() {
		id++;
		System.out.print("Masukkan nama product : ");name=scan.nextLine();
		System.out.print("Masukkan harga product : ");price=scan.nextInt();scan.nextLine();
		System.out.print("Masukkan banyak product : ");stock=scan.nextInt();scan.nextLine();
		System.out.print("[Makanan | Minuman] : ");pilihan=scan.nextLine();
		if(pilihan.equalsIgnoreCase("Makanan")) {
			System.out.print("Masukkan berat : ");weight=scan.nextInt();scan.nextLine();
			item = new Makanan(id, name, price, stock, weight);
		}
		if(pilihan.equalsIgnoreCase("Minuman")) {
			System.out.print("Masukkan liter : ");liter=scan.nextInt();scan.nextLine();
			item = new Minuman(id, name, price, stock, liter);
		}
		System.out.println("Press Enter to back ...");
		scan.nextLine();
		itemList.add(item);
		shop = new Shop(moneyEarned);
	}
	
	void view() {
		for (Item item : itemList) {
			if(item instanceof Makanan) {
				Makanan makan = (Makanan)item;
				System.out.printf("%-2d %-20s %-7d %-5d %-5dg \n", item.getId(), item.getName(), item.getPrice(), item.getStock(), makan.getWeight());
			}
			if(item instanceof Minuman) {
				Minuman minum = (Minuman)item;
				System.out.printf("%-2d %-20s %-7d %-5d %-5dlt \n", item.getId(), item.getName(), item.getPrice(), item.getStock(), minum.getLiter());
			}
		}
	}
	boolean find = false;
	void transaction() {
		for (Item item : itemList) {
			System.out.printf("%-2d %-20s %-7d %-5d \n", item.getId(), item.getName(), item.getPrice(), item.getStock());
		}
		System.out.println("Input masukkan item id : ");item_id=scan.nextInt();scan.nextLine();
		for (Item item : itemList) {
				if(item_id == item.getId()) {
					find = true;
					if(find==true) {
						do {							
							System.out.println("Masukkan qty : ");qty=scan.nextInt();scan.nextLine();
							if(qty>item.getStock()) {
								System.out.println("Quantity harus lebih kecil dari stock");
							}
						} while (qty>item.getStock());
						total = qty*item.getPrice();
						total = transaction.total(qty, item.getPrice());
						System.out.println("Total : " + total);
						item.minStock(qty);
						Transaction transaction = new Transaction(item_id, qty, total);
						shop.updateMoneyEarned(transaction.getTotal());
						transactionList.add(transaction);
					}else {
						System.out.println("Item tidak ditemukan");
					}
					
					if(find==true&&item.getStock()==0) {
						System.out.println("Stock item saat ini tidak ada");
					}
				}
		}
		System.out.println("Press Enter to back ...");
		scan.nextLine();
	}
	
	void viewHistoryTransaction() {
		for (Transaction transaction : transactionList) {
			System.out.println("=======================================================");
			System.out.println("Item yang di beli : " + transaction.getItem_id());
			for (Item item : itemList) {
				if(transaction.getItem_id()==item.getId()) {
					System.out.println("Nama item : " + item.getName());
					System.out.println("Harga item : " + item.getPrice());
				}
			}
			System.out.println("Qty : " + transaction.getQty());
			System.out.println("Total : " + transaction.getTotal());
			moneyEarned += transaction.getTotal();
		}
		System.out.println("Press Enter to back ...");
		scan.nextLine();
	}
	
	void updateStock() {
		for (Item item : itemList) {
			System.out.printf("%-2d %-20s %-7d %-5d \n", item.getId(), item.getName(), item.getPrice(), item.getStock());
		}
		System.out.print("Input masukkan item id : ");item_id=scan.nextInt();scan.nextLine();
		for (Item item : itemList) {
			if(item_id == item.getId()) {
				find = true;
				if(find==true) {
					System.out.println("Masukkan qty : ");qty=scan.nextInt();scan.nextLine();
					item.updateStock(qty);
				}
				else {
					System.out.println("Item tidak ditemukan");
				}		
			}
		}
	}
	
	void deleteStock() {
		for (Item item : itemList) {
			System.out.printf("%-2d %-20s %-7d %-5d \n", item.getId(), item.getName(), item.getPrice(), item.getStock());
		}
		System.out.print("Input masukkan item id yang mau di delete : ");item_id=scan.nextInt();scan.nextLine();
		for (Item item : itemList) {
			if(item_id == item.getId()) {
				find = true;	
			}
		}
		if(find==true) {
			itemList.remove(item_id-1);
		}
		else {
			System.out.println("Item tidak ditemukan");
		}	
	}
	
	void updateProduct() {
		for (Item item : itemList) {
			System.out.printf("%-2d %-20s %-7d %-5d \n", item.getId(), item.getName(), item.getPrice(), item.getStock());
		}
		System.out.print("Input masukkan item id yang mau di-update : ");item_id=scan.nextInt();scan.nextLine();
		for (Item item : itemList) {
			if(item_id == item.getId()) {
				find = true;	
			}
		}
		if(find==true) {
			System.out.print("Masukkan nama product : ");name=scan.nextLine();
			System.out.print("Masukkan harga product : ");price=scan.nextInt();scan.nextLine();
			System.out.print("Masukkan banyak product : ");stock=scan.nextInt();scan.nextLine();
			System.out.print("[Makanan | Minuman] : ");pilihan=scan.nextLine();
			if(pilihan.equalsIgnoreCase("Makanan")) {
				System.out.print("Masukkan berat : ");weight=scan.nextInt();scan.nextLine();
				itemNew = new Makanan(item_id, name, price, stock, weight);
			}
			if(pilihan.equalsIgnoreCase("Minuman")) {
				System.out.print("Masukkan liter : ");liter=scan.nextInt();scan.nextLine();
				itemNew = new Minuman(item_id, name, price, stock, liter);
			}
			itemList.set(item_id-1, itemNew);
		}
		else {
			System.out.println("Item tidak ditemukan");
		}
	}
	
	public Main(){
		do {
			System.out.println("Shop total earned : " + moneyEarned);
			System.out.println();
			System.out.println("");
			System.out.println("1. Masukkan barang");
			System.out.println("2. Lihat daftar barang");
			System.out.println("3. Lakukan transaksi");
			System.out.println("4. Lihat riwayat transaksi");
			System.out.println("5. Update stock barang");
			System.out.println("6. Delete barang");
			System.out.println("7. Update barang");
			System.out.println("0, Exit");
			System.out.print(">>");input=scan.nextInt();scan.nextLine();
			
			switch (input) {
			case 1:
				add();
				break;

			case 2:
				view();
				break;

			case 3:
				transaction();
				break;

			case 4:
				viewHistoryTransaction();
				break;
			
			case 5:
				updateStock();
				break;
				
			case 6:
				deleteStock();
				break;
				
			case 7:
				updateProduct();
				break;
			default:
				break;
			}
		} while (input!=0);
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}

}
