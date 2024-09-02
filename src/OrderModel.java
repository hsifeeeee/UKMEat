import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class OrderModel {
	
	private int orderID;	
	private LinkedList<ProductModel> productList = new LinkedList<ProductModel>();
	private int voucherDisc;
	private double totalPrice;
	private String paymethod = "";
	private ProductCatalogue pc = new ProductCatalogue();
	String rewardPrint = "";
	
	
	public OrderModel(int orderID) {
		this.orderID = orderID;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	// add item to specific order ID's product list
	public void addItem(String itemName) {
		ProductModel menu[] = pc.getFullMenu();
		for (int i=0; i<menu.length; i++)
			if (menu[i].getName().equals(itemName)) {
				boolean alreadyInList = false;
				for (ProductModel pd: productList) {  // Add the product into List if it is not already in the list
					if (pd.getName().equals(itemName))
						alreadyInList = true;	
				}
				
				if (alreadyInList) {
					for (ProductModel pd: productList) 
						if (pd.getName().equals(itemName))
							pd.add();
				} else
					productList.add(menu[i]);
			}
	}
	
	// get specific order ID's product list
	public String[] getProductList() {
		String arr[] = new String[productList.size()];
		int i=0;
		for (ProductModel pd: productList) {
			arr[i] = (pd.getName() + "\t"+ pd.getQuantity() + "\tRM" + pd.getSubTotal());   // Name, Qty, Subtotal
			i++;
		}
		return arr;
	}
	

	public void calTotalPrice() {
		double totalPrice = 0;
		for (ProductModel pd: productList) {
			totalPrice += pd.getSubTotal();
		}
		this.totalPrice = totalPrice;
	}
	
	public void applyRewardToPrice(double discount, int rewardID) {
		totalPrice = totalPrice - discount;
		rewardPrint = "Reward ID:"+rewardID+"\t-RM"+discount+"\n";
	}
	
	
	public String getDetails() {  //cartBox
		String tmp = "";
		String prd = String.join("\n", getProductList());
		tmp += prd;
		tmp += "\n___________\n"+rewardPrint+"Total Price: RM"+totalPrice;
		tmp += paymethod;
		return tmp;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setPayMethod(String pay) {
		paymethod = "\n Payment Method: " + pay;
	}
}

