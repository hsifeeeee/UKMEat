import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class OrderView extends JFrame implements ActionListener {
	
	JLabel pageTitle, menuTitle, foodTitle, drinkTitle, cartTitle, price, payment; 
	JList food, drink;
	JButton addItem, goBack, refresh, addReward, pay, addToFavorites;
	JTextArea cartBox;
	JTextField totalPrice;
	JPanel paneltitle, panelmenu, panelmenu_a, panelmenu_b, panelCart, panelcartTitle, panelcartBox, panelcartButton, panelPayment;
	
	private AppController controller;
	
	
	// 1. Add - add item into cart textbox
	// 2. Back - go to mainmenu
	// 3. Refresh - to refresh cart textbox after applying reward
	// 4. Add Reward - to apply reward discount
	// 5. Add to fav - add item to fav list
	
	
	public OrderView(AppController controller) {
		
        setVisible(true);
        setTitle("Make your order");
        setSize(500,400);
		
		this.controller = controller;
		
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		
		controller.makeNewOrder();
		
		// TITLE
		paneltitle = new JPanel();
		paneltitle.setLayout(new FlowLayout());
		pageTitle = new JLabel("Make Order");
		paneltitle.add(pageTitle);
		pane.add(paneltitle, BorderLayout.NORTH);
		
		// MENU
		panelmenu = new JPanel();
		panelmenu.setLayout(new BorderLayout());
		menuTitle = new JLabel("Menu");
		
		food = new JList(controller.getFood());
		drink = new JList(controller.getDrink());
		addItem = new JButton("ADD");
		addItem.addActionListener(this);
		
		panelmenu.add(menuTitle, BorderLayout.NORTH);
		
		panelmenu_a = new JPanel();
		panelmenu_a.setLayout(new BoxLayout(panelmenu_a, BoxLayout.Y_AXIS));
		foodTitle = new JLabel("Food", SwingConstants.LEFT);
		panelmenu_a.add(foodTitle);
		panelmenu_a.add(food);
		
		panelmenu_b = new JPanel();
		panelmenu_b.setLayout(new BoxLayout(panelmenu_b, BoxLayout.Y_AXIS));
		drinkTitle = new JLabel("Drink");
		drinkTitle.setHorizontalAlignment(SwingConstants.LEFT);     
		panelmenu_b.add(drinkTitle);
		panelmenu_b.add(drink);
		
		panelmenu.add(panelmenu_a, BorderLayout.WEST);
		panelmenu.add(panelmenu_b, BorderLayout.CENTER);
		panelmenu.add(addItem, BorderLayout.EAST);
		pane.add(panelmenu, BorderLayout.CENTER);
		
		
		// CART
		cartTitle = new JLabel("CART | Order ID: "+controller.getOrderID());   // Add Order ID
		cartBox = new JTextArea("\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n");
		
		// 
		goBack = new JButton("Back");
		goBack.addActionListener(this);
		addReward = new JButton("Add Reward");
		addReward.addActionListener(this);
		refresh = new JButton("Refresh");
		refresh.addActionListener(this);
		addToFavorites = new JButton("Add to Favorites");
		addToFavorites.addActionListener(this);
		
		
		price = new JLabel("Total Price: ");
		totalPrice = new JTextField("        ");
		
		
		pay = new JButton("PAY");
		pay.addActionListener(this);
		
		panelcartTitle = new JPanel();
		panelcartTitle.setLayout(new FlowLayout());
		panelcartTitle.add(cartTitle);
		panelcartBox = new JPanel();
		panelcartBox.setLayout(new FlowLayout());
		panelcartBox.add(cartBox);
		panelcartButton = new JPanel();
		panelcartButton.setLayout(new FlowLayout());
		panelcartButton.add(goBack);
		panelcartButton.add(refresh);
		panelcartButton.add(addReward);
		panelcartButton.add(pay);
		panelcartButton.add(addToFavorites);
		panelCart = new JPanel();
		panelCart.setLayout(new BorderLayout());
		panelCart.add(panelcartTitle, BorderLayout.NORTH);
		panelCart.add(panelcartBox, BorderLayout.CENTER);
		panelCart.add(panelcartButton, BorderLayout.SOUTH);
		pane.add(panelCart, BorderLayout.SOUTH);

		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
				
		if (obj==addItem) {
			// If food is chosen
			if(food.getSelectedValue()!=null) {
				controller.addItem(food.getSelectedValue());
			}
			
			// if drink is chosen
			if (drink.getSelectedValue()!=null) {
				controller.addItem(drink.getSelectedValue());
			}
			
			// Add to cart box
			controller.calculate();
			cartBox.setText(controller.printCart());
			
			// Clear selection
			food.clearSelection();
			drink.clearSelection();
		}
		
		if (obj==goBack) {
			controller.viewMainMenu(this, controller);
		}
		
		if (obj == addReward) {
			RewardApplyView frame = new RewardApplyView(controller);
			frame.setTitle("Reward List");
			frame.setSize(500,300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		
		if (obj==refresh) {
			cartBox.setText(controller.printCart());
		}
		
		if (obj==pay) {
			controller.showPaymentView(this, controller);
			food.clearSelection();
			drink.clearSelection();
			cartTitle.setText("CART | Order ID: "+controller.getOrderID());
			cartBox.setText("\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n");
		}
		
		if (obj== addToFavorites) {
			if(food.getSelectedValue()!=null) {
				controller.addToFavorite(food.getSelectedValue().toString());
			}
		}
		
	}
	
}
