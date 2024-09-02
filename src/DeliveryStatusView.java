import javax.swing.JOptionPane;


public class DeliveryStatusView extends javax.swing.JFrame{

	private AppController app;

	private javax.swing.JTextField IDField;
	private javax.swing.JLabel IDLabel;
	private javax.swing.JButton goBackButton;
	private javax.swing.JLabel infoLabel;
	private javax.swing.JButton checkButton;

	public DeliveryStatusView(AppController controller) {
		this.app = controller;
		initComponents();
		setVisible(true);
		setTitle("Check Delivery Status");
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		IDField = new javax.swing.JTextField();
		IDLabel = new javax.swing.JLabel();
		infoLabel = new javax.swing.JLabel();
		checkButton = new javax.swing.JButton();
		goBackButton = new javax.swing.JButton();


		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);



		infoLabel.setText("Enter your order ID");

		IDLabel.setText("ID");

		checkButton.setText("Check Now");
		checkButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkButtonActionPerformed(evt);
			}
		});

		goBackButton.setText("Go Back");
		goBackButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goBackButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(81, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(infoLabel)
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(IDLabel))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(IDField, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))
										.addGap(88, 88, 88))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(checkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(goBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(115, 115, 115))))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(60, 60, 60)
						.addComponent(infoLabel)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(IDLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								
								.addGap(49, 49, 49)
								.addComponent(checkButton))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(goBackButton)
						.addContainerGap(133, Short.MAX_VALUE))
				);

		pack();


	}

	private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// If order id incorrect, give error
		if (app.checkOrderID(Integer.parseInt(IDField.getText())))
			JOptionPane.showMessageDialog(this, "Check Successful, Order still in Delivery", "Success", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "Incorrect Order ID", "Failure", JOptionPane.INFORMATION_MESSAGE);


	}

	private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
		app.showDeliveryView(this, app);
	}

}

