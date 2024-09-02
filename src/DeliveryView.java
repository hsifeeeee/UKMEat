
public class DeliveryView extends javax.swing.JFrame {

    private AppController app;
    
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton DeliveryStatusButton;
    

    public DeliveryView(AppController controller) {
        this.app = controller;
        initComponents();
        setVisible(true);
        setTitle("Delivery Status");
    }

    private void initComponents() {

    	DeliveryStatusButton = new javax.swing.JButton();
	
		goBackButton = new javax.swing.JButton();
		infoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        

        infoLabel.setText("Check Delivery Status");

        DeliveryStatusButton.setText("Check Current Delivery Status");
        DeliveryStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryButtonActionPerformed(evt);
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
                        .addComponent(DeliveryStatusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       
                        .addComponent(goBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(infoLabel)
                .addGap(18, 18, 18)
                .addComponent(DeliveryStatusButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              
                .addGap(66, 66, 66)
                .addComponent(goBackButton)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void deliveryButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	app.showDeliveryStatusView(this, app);
    }



   private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        app.viewMainMenu(this, app);
    }
   
    
    
}