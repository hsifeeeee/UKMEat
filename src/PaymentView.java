public class PaymentView extends javax.swing.JFrame {

    private AppController app;
    
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton codButton;
    private javax.swing.JButton cardButton;

   

    public PaymentView(AppController controller) {
        this.app = controller;
        initComponents();
        setVisible(true);
        setTitle("Payment");
    }

    private void initComponents() {

    	codButton = new javax.swing.JButton();
		cardButton = new javax.swing.JButton();
		goBackButton = new javax.swing.JButton();
		infoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        

        infoLabel.setText("Choose Payment Method");

        codButton.setText("Cash On Delivery");
        codButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codButtonActionPerformed(evt);
            }
        });
        
        cardButton.setText("Credit/DebitCard");
        cardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtonActionPerformed(evt);
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
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(codButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(infoLabel)
                .addGap(18, 18, 18)
                .addComponent(codButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton)
                .addGap(66, 66, 66)
                .addComponent(goBackButton)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void codButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	app.setPayMethod("Cash On Delivery");
    	app.showCodView(this, app);
    }

    private void cardButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	app.setPayMethod("Credit/Debit Card");
    	app.showCardView(this, app);
    }	

   private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        app.viewMainMenu(this, app);
    }
}
    
    

