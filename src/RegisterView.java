import javax.swing.JOptionPane;

public class RegisterView extends javax.swing.JFrame {

    AppController app;
    
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton gotoLoginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel pwdLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel registerLabel;
    
    public RegisterView(AppController controller) {
        this.app = controller;
        initComponents();
        setVisible(true);
        setTitle("Sign Up");
    }

    
    private void initComponents() {

        registerLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        pwdLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        gotoLoginButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registerLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        registerLabel.setText("Sign Up Here");

        emailLabel.setText("Email");

        pwdLabel.setText("Password");

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        gotoLoginButton.setText("Already have an account");
        gotoLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoLoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registerLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gotoLoginButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registerButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pwdLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField)
                            .addComponent(emailField))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(registerLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton)
                    .addComponent(gotoLoginButton))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        pack();
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        boolean response = app.register(emailField.getText(), new String(passwordField.getPassword()));
        if (response) {
            JOptionPane.showMessageDialog(this, "Registration Success", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Something went wrong", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void gotoLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        app.showLoginView(this, app);
    }

  

}
