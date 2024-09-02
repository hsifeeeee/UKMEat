
public class MainMenu extends javax.swing.JFrame {
    
    AppController app;
    
    private javax.swing.JButton orderButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton rewardsButton;
    private javax.swing.JLabel userLabel;
    private javax.swing.JButton deliveryButton;
    private javax.swing.JButton invoiceButton;
    private javax.swing.JButton favoriteButton;
    
    public MainMenu(AppController controller) {
        this.app = controller;
        initComponents();
        userLabel.setText("Welcome to UKMEats, " +app.getCurrentUser().getEmail());
        setVisible(true);
        setTitle("Main menu");
    }

    private void initComponents() {

        orderButton = new javax.swing.JButton();
        rewardsButton = new javax.swing.JButton();
        deliveryButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        invoiceButton = new javax.swing.JButton();
        favoriteButton = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        orderButton.setText("Make Order");
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        rewardsButton.setText("Reward");
        rewardsButton.setToolTipText("");
        rewardsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rewardsButtonActionPerformed(evt);
            }
        });

        deliveryButton.setText("Delivery Status");
        deliveryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryButtonActionPerformed(evt);
            }
        });
        
        favoriteButton.setText("Favorites");
        favoriteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoriteButtonActionPerformed(evt);
            }
        });
        
        invoiceButton.setText("Invoice");
        invoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        userLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userLabel.setText("Hi, User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(orderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rewardsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deliveryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoiceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(favoriteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(userLabel)
                .addGap(18, 18, 18)
                .addComponent(orderButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rewardsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deliveryButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoiceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(favoriteButton)
                .addGap(66, 66, 66)
                .addComponent(logoutButton)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }

    private void deliveryButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
    	app.showDeliveryView(this, app);
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        app.setCurrentUser(null);
        app.showLoginView(this, app);
    }

    private void rewardsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        app.showRewardView(this, app);
    }

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {
       app.showOrderView(this, app);
    }
    
    private void invoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        app.showInvoiceView(this, app);
    }

    private void favoriteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        app.showFavoritesView(this, app);
    }
    
   
  
}
