import javax.swing.JOptionPane;

public class CardView extends javax.swing.JFrame{
	private AppController app;

	private javax.swing.JTextField amountField;
	private javax.swing.JLabel currencyLabel;
	private javax.swing.JButton goBackButton;
	private javax.swing.JLabel infoLabel;
	private javax.swing.JButton payButton;
	private javax.swing.JLabel cardLabel;
	private javax.swing.JLabel cvvLabel;
	private javax.swing.JTextField cardNoField;
	private javax.swing.JTextField cvvField;
	private javax.swing.JLabel expiryLabel;
	private javax.swing.JTextField expiryField;
	//private javax.swing.JLabel cardInfoLabel;
	

	public CardView(AppController controller) {
		this.app = controller;
		initComponents();
		setVisible(true);
		setTitle("Credit/Debit Card");
	}

	private void initComponents() {

		amountField = new javax.swing.JTextField();
		currencyLabel = new javax.swing.JLabel();
		infoLabel = new javax.swing.JLabel();
		payButton = new javax.swing.JButton();
		goBackButton = new javax.swing.JButton();
		cardLabel = new javax.swing.JLabel();
		cvvLabel = new javax.swing.JLabel();
		cardNoField = new javax.swing.JTextField();
		cvvField = new javax.swing.JTextField();
		expiryLabel = new javax.swing.JLabel();
		expiryField = new javax.swing.JTextField();
		//cardInfoLabel = new javax.swing.JLabel();
		
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		infoLabel.setText("Amount to be paid");

		currencyLabel.setText("RM");
		amountField.setText(String.valueOf(app.getTotalPrice()));
		
		cardLabel.setText("Card No");
		cvvLabel.setText("CVV");
		expiryLabel.setText("Expiry");

		payButton.setText("Pay Now");
		payButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				payButtonActionPerformed(evt);
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
																.addComponent(currencyLabel)
												
															
														.addComponent(cardLabel)
														.addComponent(expiryLabel)
														.addComponent(cvvLabel))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(cardNoField)	
																.addComponent(expiryField)
																.addComponent(cvvField)										
																.addComponent(amountField, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))
										.addGap(88, 88, 88))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(payButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
								.addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(currencyLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cardNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			                    .addComponent(cardLabel))
								
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(expiryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			                    .addComponent(expiryLabel))
								
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(cvvField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					                    .addComponent(cvvLabel))
										.addGap(49, 49, 49)
										
								.addComponent(payButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(goBackButton)
						.addContainerGap(133, Short.MAX_VALUE))
				);

		pack();


	}

	private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {
		app.setOrder();
		app.makeNewOrder();
		amountField.setText("");
		cardNoField.setText("");
		cvvField.setText("");
		expiryField.setText("");
		JOptionPane.showMessageDialog(this, "Payment Successful", "Success", JOptionPane.INFORMATION_MESSAGE);

	}

	private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {
		app.showPaymentView(this, app);
	}

}

