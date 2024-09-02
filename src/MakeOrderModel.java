import java.util.*;

public class MakeOrderModel {
	
	private OrderModel order;
	public ArrayList<OrderModel> invoiceList = new ArrayList<OrderModel>();
	private ProductCatalogue pc = new ProductCatalogue();
	private ArrayList<RewardModel> rewardList = new ArrayList<RewardModel>();
	private RewardModel reward;
	
	public void makeNewOrder() {
		order = new OrderModel(setOrderID());
	}
	
	
	public int setOrderID() {
		int IDrand = 0;
		if (invoiceList.size() == 0) {
			IDrand = (100);
		} else {
			OrderModel od = invoiceList.get(invoiceList.size()-1);
			IDrand = (od.getOrderID()+1);
		}
		return IDrand;
	}
	
	public int setRewardID() {
		int IDrand = 0; 
		if (rewardList.isEmpty()) {
			IDrand = (1000);
		} else {
			RewardModel rd = rewardList.get(rewardList.size()-1);
			IDrand = (rd.getRewardID()+1);
		}
		return IDrand;
	}
	
	public int getRewardID() {
		return reward.getRewardID();
	}
	
	public int getOrderID() {
		return order.getOrderID();
	}
	
	public String[] getFood() {
		return pc.getFood();
	}
	
	public String[] getDrink() {
		return pc.getDrink();
	}
	
	public void addItem(String itemName) {
		order.addItem(itemName);
	}
	
	public void calculate() {
		order.calTotalPrice();
	}
	
	public String printCart() {
		return order.getDetails();
	}
	
	public void setOrder() {
		setOrder(order);
		if (order.getTotalPrice() > 29) {
			reward = new RewardModel(setRewardID());
			reward.checkDiscount(order.getTotalPrice());  
			setReward(reward);
		}
	}
	
	public void setOrder(OrderModel od) {
		invoiceList.add(od);
	}
	
	public void setReward(RewardModel rd) {
		rewardList.add(rd); 
	}
	
	public String[] getRewardList() {
		String arr[] = new String[rewardList.size()];
		int i=0;
		for (RewardModel rd: rewardList) {
			arr[i] = rd.getRewardID() + "      Discount: RM" + rd.getDiscount();
			i++;
		}
		return arr;
	}
	
	public int getLastID() {
		RewardModel rd = rewardList.get(rewardList.size()-1);
		return rd.getRewardID();
	}
	
	public void applyReward(int rewardID) {
		for (RewardModel rd: rewardList) 
			if(rd.getRewardID() == rewardID) {
				order.applyRewardToPrice(rd.getDiscount(), rd.getRewardID());
			}		
		rewardList.remove(rewardList.size()-1);
	}
	
	public String[] getInvoice() {
		String arr[] = new String[invoiceList.size()];
		int i=0;
		for (OrderModel od: invoiceList) {
			arr[i] = String.valueOf(od.getOrderID());
			i++;
		}
		return arr;
	}
	
	public String getItemInvoice(int orderID) {
		String tmp = "";
		for (OrderModel od: invoiceList) {
			if (od.getOrderID() == orderID) {
				tmp += ("Order ID: "+od.getOrderID()+"\n");
				tmp += od.getDetails();
			}
		}
		return tmp;
	}
	
	public double getTotalPrice() {
		return order.getTotalPrice();
	}
	
	public boolean checkOrderID(int orderID) {
		boolean check = false;
		for (OrderModel od : invoiceList)
			if (od.getOrderID() == orderID)
				check = true;
	    return check;
	}
	
	public void setPayMethod(String pay) {
		order.setPayMethod(pay);
	}
	
	
}
