import javax.swing.JOptionPane;

public class CodView extends javax.swing.JFrame{

	private AppController app;

	private javax.swing.JTextField amountField;
	private javax.swing.JLabel currencyLabel;
	private javax.swing.JButton goBackButton;
	private javax.swing.JLabel infoLabel;
	private javax.swing.JButton payButton;

	public CodView(AppController controller) {
		this.app = controller;
		initComponents();
		setVisible(true);
		setTitle("Cash On Delivery");
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		amountField = new javax.swing.JTextField();
		currencyLabel = new javax.swing.JLabel();
		infoLabel = new javax.swing.JLabel();
		payButton = new javax.swing.JButton();
		goBackButton = new javax.swing.JButton();


		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);



		infoLabel.setText("Amount to be paid");

		currencyLabel.setText("RM");
		amountField.setText(String.valueOf(app.getTotalPrice()));

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
																.addComponent(currencyLabel))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
								
								.addGap(49, 49, 49)
								.addComponent(payButton))
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
		JOptionPane.showMessageDialog(this, "Payment Successful", "Success", JOptionPane.INFORMATION_MESSAGE);

	}

	private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
		app.showPaymentView(this, app);
	}

}

