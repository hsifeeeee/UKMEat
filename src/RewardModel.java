import java.util.ArrayList;

public class RewardModel {
	
	private int rewardID;
	private int priceDiscount;
	
	public RewardModel(int rewardID) {
		this.rewardID = rewardID;
	}
	
	public int getRewardID() {
		return rewardID;
	}
	
	public double checkDiscount(double totalprice) {
		if (totalprice>49)
			priceDiscount = 10;
		else
			priceDiscount = 0;
		return priceDiscount;
	}
	
	public int getDiscount() {
		return priceDiscount;
	}
}