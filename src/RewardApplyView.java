import java.util.*;
import java.awt.*;
import java.awt.List;
import javax.swing.*;


import java.awt.event.*;

public class RewardApplyView extends JFrame implements ActionListener {

	JLabel pageTitle, rewardTitle;
	JList reward;
	JButton addReward, goBack;
	JPanel paneltitle, panelreward, panelreward_a, panelButton;
	private AppController controller;

	public RewardApplyView(AppController controller) {
		
		setVisible(true);
        setTitle("Your rewards");
        setSize(300,200);

		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		this.controller = controller;

		// TITLE
		paneltitle = new JPanel();
		paneltitle.setLayout(new FlowLayout());
		pageTitle = new JLabel("Rewards");
		paneltitle.add(pageTitle);
		pane.add(paneltitle, BorderLayout.NORTH);

		// REWARDS
		panelreward = new JPanel();
		panelreward.setLayout(new BorderLayout());
		rewardTitle = new JLabel("Rewards to claim");

		reward = new JList(controller.getRewardList()); 
		addReward = new JButton("APPLY");
		addReward.addActionListener(this);

		panelreward_a = new JPanel();
		panelreward_a.setLayout(new BoxLayout(panelreward_a, BoxLayout.Y_AXIS));
		panelreward_a.add(reward);

		panelreward.add(rewardTitle, BorderLayout.NORTH);
		panelreward.add(panelreward_a, BorderLayout.WEST);
		
		// BUTTON
		panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout());
		goBack = new JButton("BACK");
		goBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goBackActionPerformed(evt);
			}
		});
		panelButton.add(goBack);
		panelButton.add(addReward);
		panelreward.add(panelButton, BorderLayout.SOUTH);
		pane.add(panelreward, BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == addReward) {
			if(reward.getSelectedValue()!=null) {
				String itemName = String.valueOf(reward.getSelectedValue());
				int ind = itemName.indexOf(" ");
				itemName = itemName.substring(0 , ind);
				int rewardID = Integer.parseInt(itemName);
				controller.applyReward(rewardID);
				this.setVisible(false); 
				this.dispose(); 
			}
		}
	}

	private void goBackActionPerformed(java.awt.event.ActionEvent evt) {
		controller.showOrderView(this, controller);
	}
}

