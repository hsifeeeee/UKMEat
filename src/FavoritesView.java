import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FavoritesView extends javax.swing.JFrame {
	
	private AppController app;
    private javax.swing.JList items;
    private javax.swing.JButton goBackButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel infoLabel;
    private JList<String> i; 
    private Container c;
    private javax.swing.GroupLayout layout;
   public FavoritesView(AppController controller) {
        this.app = controller;
        initComponents();
        setVisible(true);
        setTitle("Payment");
    }

    private void initComponents() {

    	items = new JList(app.favs.getFavouriteList());
    	i = new JList<>(app.favs.getFavouriteList());
    	
		goBackButton = new javax.swing.JButton();
		infoLabel = new javax.swing.JLabel();
		removeButton = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        infoLabel.setText("Favorites");
        removeButton.setText("Remove");
        goBackButton.setText("Go Back");
        
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });
        
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });


        layout = new javax.swing.GroupLayout(getContentPane());
        
        c = getContentPane();
        c.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    	.addComponent(i, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    	.addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(infoLabel)
                .addGap(18, 18, 18)
                .addComponent(i)
                .addGap(18, 18, 18)
                .addComponent(goBackButton)
                .addGap(18, 18, 18)
                .addComponent(removeButton)
                .addGap(18, 18, 18)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }

   private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        app.viewMainMenu(this, app);
    }

	private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		int index = i.getSelectedIndex();
		String s = (String) i.getSelectedValue();
		System.out.println(s);
		c.remove(i);
		i = new JList(app.removeFromFavorite(s));
		c.add(i);
		c.revalidate();
	}
}

