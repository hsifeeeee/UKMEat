

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class AppController {
    public static FavoritesModel favs = new FavoritesModel();
    public UserModel user = new UserModel();
    public static HashMap<String, UserModel> usersList = new HashMap<>();
    ArrayList<PaymentModel> transactionList = new ArrayList<>(); 
    public static MakeOrderModel makeorder = new MakeOrderModel();
    
    ArrayList<DeliveryModel> deliveryList = new ArrayList<>();
    
    public static void run() {
        LoginView loginView = new LoginView();favs.setFavorites();
        AppController.seed();
        loginView.run();
    }

    public static void seed() {
        String email = "admin";
        String password = "admin";

        UserModel permaUser = new UserModel(email, password);
        usersList.put(email, permaUser);
        
    }
    public boolean login(String email, String password) {
        try {
            //System.out.println(usersList.containsKey(email));
            //System.out.println(usersList.get(email).getPassword().equals(password));
            if (usersList.containsKey(email) && usersList.get(email).getPassword().equals(password)) {
                user.setCurrentUser(usersList.get(email));
                return true;
            }
        } catch (Error e) {
            
        }
        return false;
    }
    public boolean register(String email, String password) {
        try {
            user.setEmail(email);
            user.setPassword(password);
            // save user in local memory
            usersList.put(email, user);
        } catch (Error e) {
            return false;
        }
        return true;
    }
    
    public void showRegisterView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new RegisterView(app);
    }
    
    public void showLoginView(JFrame currentFrame, AppController app){
        currentFrame.dispose();
        new LoginView(app);
    }
    
    public void showOrderView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new OrderView(app);
    }
 
    public void showPaymentView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new PaymentView(app);
    }
    
    public void showRewardView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new RewardView(app);
    }
    
    public void showRewardApplyView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new RewardApplyView(app);
    }
    
    public void showInvoiceView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new InvoiceView(app);
    }
    
    public void showDeliveryView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new DeliveryView(app);
    }
    
    public void showDeliveryStatusView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new DeliveryStatusView(app);
    }
    
    public void showFavoritesView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new FavoritesView(app);
    }
   
    public void viewMainMenu(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new MainMenu(app);
    }
    public void showCodView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new CodView(app);
    }
    
    public void showCardView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new CardView(app);
    }
     
    public UserModel getCurrentUser() {
        return user.getCurrentUser();
    }
    
    public void setCurrentUser(UserModel u) {
        user.setCurrentUser(u);
    }
    public String[] removeFromFavorite(String s) {
    	favs.removeFromFavourite(s);
    	JFrame frame = new JFrame();
    	if (s.equals(null)) {
			JOptionPane.showMessageDialog(frame, "Please select 1 item!");
		} else {
			JOptionPane.showMessageDialog(frame, "Operation Success!");
		}
    	
    	System.out.println("Number of items: "+ favs.getFavouriteList().length);
    	return favs.getFavouriteList();
    }
    
    public String[] addToFavorite(String s) {
    	
    	//
    	
    	JFrame frame = new JFrame();
    	if (s.equals(null)) {
    		
			JOptionPane.showMessageDialog(frame, "Please select 1 item!");
		} else {
			String[] ss = s.split(" ");
			String foodname[] = new String[ss.length-1];
			
			int i;
			for(i = 0; i < ss.length-1; i++) {
	            foodname[i] = ss[i];
	        }
	        String foodName = String.join(" ", foodname);
	        favs.addToFavourite(foodName);
			//System.out.println(foodName);
			JOptionPane.showMessageDialog(frame, "Operation Success!");
		}
    	
    	//System.out.println("Number of items: "+ favs.getFavouriteList().length);
    	return favs.getFavouriteList();
    }
    
    public void makeNewOrder() {
		makeorder.makeNewOrder();
	}
	
	public String[] getFood() {
		return makeorder.getFood();
	}
	
	public String[] getDrink() {
		return makeorder.getDrink();
	}
	
	public void addItem(Object item) {
		String itemName = String.valueOf(item);
		int ind = itemName.indexOf("(")-1;
		itemName = itemName.substring(0 , ind);
		makeorder.addItem(itemName);
	}
	
	public void calculate() {
		makeorder.calculate();
	}
	
	public String printCart() {
		return makeorder.printCart();
	}
	
	public int getOrderID() {
		return makeorder.getOrderID();
	}
	
	public void setOrder() {
		makeorder.setOrder();
	}
	
	public String[] getRewardList() {
		return makeorder.getRewardList(); 
	}
	
	public int getLastID() {
		return makeorder.getLastID();
	}
	
	public void applyReward(int rewardID) {
		makeorder.applyReward(rewardID);
	}
	
	public String[] getInvoice() {
		return makeorder.getInvoice();
	}
	
	public String getItemInvoice(int orderID) {
		return makeorder.getItemInvoice(orderID);
	}
	
	public double getTotalPrice() {
		return makeorder.getTotalPrice();
	}

    public boolean checkOrderID(int orderID) {
    	return makeorder.checkOrderID(orderID);
    }
    
	public void setPayMethod(String pay) {
		makeorder.setPayMethod(pay);
	}
}
