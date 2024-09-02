public class ProductModel {
	private String name;
	private double price;
	private int qty=1;
	
	public ProductModel(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return qty;
	}
	
	public void add() {
		qty++;
	}
	
	public double getSubTotal() {
		return price*qty;
	}
}

class ProductCatalogue {
	
	private ProductModel food[] = new ProductModel[10]; 
	private ProductModel drink[] = new ProductModel[5]; 
	private ProductModel menu[] = new ProductModel[food.length+drink.length];
	
	public ProductCatalogue() {
		setCatalogue();
	}
	
	public void setCatalogue() {
	food[0] = new ProductModel("Nasi Bujang", 4); 
	food[1] = new ProductModel("Nasi Kandar", 20);
	food[2] = new ProductModel("Nasi Vanggey", 50);
	food[3] = new ProductModel("Nasi Goreng", 5);
	food[4] = new ProductModel("Nasi Paprik", 5);
	food[5] = new ProductModel("Nasi Ayam", 7);
	food[6] = new ProductModel("Ayam Goreng", 6);
	food[7] = new ProductModel("Ikan Balado", 7);
	food[8] = new ProductModel("Mee Goreng", 7);
	food[9] = new ProductModel("Aglio Olio", 6);
	drink[0] = new ProductModel("Teh Ais", 2); 
	drink[1] = new ProductModel("Green Tea", 3);
	drink[2] = new ProductModel("Sirap", 1);
	drink[3] = new ProductModel("Teh O Ais", 1);
	drink[4] = new ProductModel("Extra Joss", 2);
	}
	
	public String[] getFood() {
		String arr[] = new String[food.length];
		for (int i=0; i<food.length; i++)
			arr[i] = (food[i].getName() + " (RM" + food[i].getPrice() + ")");
		return arr;
	}
	
	public String[] getDrink() {
		String arr[] = new String[drink.length];
		for (int i=0; i<drink.length; i++)
			arr[i] = (drink[i].getName() + " (RM" + drink[i].getPrice() + ")");
		return arr;
	}
	
	public ProductModel[] getFullMenu() {
		System.arraycopy(food, 0, menu, 0, food.length);  
		System.arraycopy(drink, 0, menu, food.length, drink.length); 
		return menu;
	}
}
