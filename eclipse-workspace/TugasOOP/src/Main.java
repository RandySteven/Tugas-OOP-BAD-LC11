import java.util.Scanner;
import java.util.Vector;

public class Main {
	String name;
	int price, stock, weight, liter, qty, total, item_id, input;
	int id = 0;
	Makanan makanan;
	Minuman minuman;
	Item item;
	Scanner scan = new Scanner(System.in);
	Vector<Makanan> makananList = new Vector<>();
	Vector<Minuman> minumanList = new Vector<>();
	String pilihan = "";
	Vector<Item> itemList = new Vector<>();
	int moneyEarned = 0;

	Transaction transaction = new Transaction(item_id, qty, total);
	Vector<Transaction> transactionList = new Vector<>();
	Shop shop = new Shop(makananList, minumanList, moneyEarned);
	void add() {
		System.out.print("Masukkan nama product : ");name=scan.nextLine();
		System.out.print("Masukkan harga product : ");price=scan.nextInt();scan.nextLine();
		System.out.print("Masukkan banyak product : ");stock=scan.nextInt();scan.nextLine();
		System.out.print("[Makanan | Minuman] : ");pilihan=scan.nextLine();
		if(pilihan.equalsIgnoreCase("Makanan")) {
			System.out.print("Masukkan berat : ");weight=scan.nextInt();scan.nextLine();
			id++;
			makanan = new Makanan(id, name, price, stock, weight);
			makananList.add(makanan);
			item = new Makanan(id, name, price, stock, weight);
		}
		if(pilihan.equalsIgnoreCase("Minuman")) {
			System.out.print("Masukkan liter : ");liter=scan.nextInt();scan.nextLine();
			id++;
			minuman = new Minuman(id, name, price, stock, liter);
			minumanList.add(minuman);
			item = new Minuman(id, name, price, stock, liter);
		}
		System.out.println("Press Enter to back ...");
		scan.nextLine();
		itemList.add(item);
		Shop shop = new Shop(makananList, minumanList, moneyEarned);
	}
	
	void view() {
		for (Item item : itemList) {
			System.out.printf("%-2d %-20s %-7d %-5d \n", item.getId(), item.getName(), item.getPrice(), item.getStock());
		}
		System.out.print("Mau lihat yang mana [Makanan|Minuman|0] : ");pilihan=scan.nextLine();
		if(pilihan.equals("0")) {
			System.out.println("Press Enter to back ...");
			scan.nextLine();
		}
		if(pilihan.equalsIgnoreCase("Makanan")) {
			for (Makanan makanan : makananList) {
				System.out.println("==========================");
				System.out.println(makanan.getId());
				System.out.println("Nama makanan : " + makanan.getName());
				System.out.println("Harga makanan : " + makanan.getPrice());
				System.out.println("Quantity makanan : " + makanan.getStock());
				System.out.println("Berat makanan : " + makanan.getWeight());
			}
			System.out.println("Press Enter to back ...");
			scan.nextLine();
		}
		if(pilihan.equalsIgnoreCase("Minuman")) {
			for (Minuman minuman : minumanList) {
				System.out.println("==========================");
				System.out.println(minuman.getId());
				System.out.println("Nama makanan : " + minuman.getName());
				System.out.println("Harga makanan : " + minuman.getPrice());
				System.out.println("Quantity makanan : " + minuman.getStock());
				System.out.println("Berat makanan : " + minuman.getLiter());
			}
			System.out.println("Press Enter to back ...");
			scan.nextLine();
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
					System.out.println("Masukkan qty : ");qty=scan.nextInt();scan.nextLine();
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
			}
		}
		System.out.println("Press Enter to back ...");
		scan.nextLine();
	}
	
	void viewHistoryTransaction() {
		for (Transaction transaction : transactionList) {
			System.out.println("=======================================================");
			System.out.println("Item yang di beli : " + transaction.getItem_id());
			System.out.println("Qty : " + transaction.getQty());
			System.out.println("Total : " + transaction.getTotal());
		}
		System.out.println("Press Enter to back ...");
		scan.nextLine();
	}
	
	public Main() {
		do {
			System.out.println("Shop total earned : " + shop.getMoneyEarned());
			System.out.println("");
			System.out.println("1. Masukkan barang");
			System.out.println("2. Lihat daftar barang");
			System.out.println("3. Lakukan transaksi");
			System.out.println("4. Lihat riwayat transaksi");
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
			
			default:
				System.out.println("Input just from [1-4]");
				break;
			}
		} while (input!=0);
	}

	public static void main(String[] args) {
		new Main();
	}

}
