import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InvoiceView extends JFrame implements ActionListener{
	
	JLabel pageTitle, invoiceTitle, boxTitle; 
	JList invoice;
	JButton viewItem, goBack;
	JTextArea Box;
	JTextField totalPrice;
	JPanel paneltitle, panelinvoice, panelinvoice_a, panelBoxTitle, panelBoxText, panelBoxButton, panelBox;
	
	private AppController controller;
	
	public InvoiceView(AppController controller) {
		
		setVisible(true);
        setTitle("Your order rewards");
        setSize(300,300);
        
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		
		this.controller = controller;
		
		// TITLE
		paneltitle = new JPanel();
		paneltitle.setLayout(new FlowLayout());
		pageTitle = new JLabel("INVOICE");
		paneltitle.add(pageTitle);
		pane.add(paneltitle, BorderLayout.NORTH);
		
		// INVOICE LIST & VIEW BUTTON
		panelinvoice = new JPanel();
		panelinvoice.setLayout(new BorderLayout());
		invoiceTitle = new JLabel("List of invoices");
		
		invoice = new JList(controller.getInvoice());
		viewItem = new JButton("VIEW");
		viewItem.addActionListener(this);
		
		panelinvoice.add(invoiceTitle, BorderLayout.NORTH);
		
		panelinvoice_a = new JPanel();
		panelinvoice_a.setLayout(new BoxLayout(panelinvoice_a, BoxLayout.Y_AXIS));
		panelinvoice_a.add(invoice);
		
		panelinvoice.add(panelinvoice_a, BorderLayout.WEST);
		panelinvoice.add(viewItem, BorderLayout.EAST);
		pane.add(panelinvoice, BorderLayout.CENTER);
		
		// INVOICE BOX
		boxTitle = new JLabel("INVOICE");   // Add Order ID
		Box = new JTextArea("\t\t\t\t\t\n");
		
		panelBoxTitle = new JPanel();
		panelBoxTitle.setLayout(new FlowLayout());
		panelBoxTitle.add(boxTitle);
		panelBoxText = new JPanel();
		panelBoxText.setLayout(new FlowLayout());
		panelBoxText.add(Box);
		goBack = new JButton("BACK");
		goBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goBackActionPerformed(evt);
			}
		});
		panelBoxButton = new JPanel();
		panelBoxButton.setLayout(new FlowLayout());
		panelBoxButton.add(goBack);
		panelBox = new JPanel();
		panelBox.setLayout(new BorderLayout());
		panelBox.add(panelBoxTitle, BorderLayout.NORTH);
		panelBox.add(panelBoxText, BorderLayout.CENTER);
		panelBox.add(panelBoxButton, BorderLayout.SOUTH);
		pane.add(panelBox, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == viewItem) {
			if(invoice.getSelectedValue()!=null) {
				int tmp = Integer.parseInt(String.valueOf(invoice.getSelectedValue()));
				Box.setText(controller.getItemInvoice(tmp));
			}
		}
	}
	
	private void goBackActionPerformed(java.awt.event.ActionEvent evt) {
		controller.viewMainMenu(this, controller);
	}
}
