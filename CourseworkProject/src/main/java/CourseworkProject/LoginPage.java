/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseworkProject;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
        setMinimumSize(new Dimension(374, 667));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailInput = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        emailLabel1 = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("(LOGO HERE)");

        emailLabel1.setText("Email:");

        passLabel.setText("Password:");

        jLabel4.setText("(TOAST HERE SHOULD BE HIDDEN)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addGap(0, 170, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emailLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(passwordInput)
                    .addComponent(emailInput, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(93, 93, 93))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel1))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel))
                .addGap(80, 80, 80)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jLabel4)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInputActionPerformed

    
        @SuppressWarnings("empty-statement")
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
                // TODO add your handling code here:
            String email = emailInput.getText();
            String password = String.valueOf(passwordInput.getPassword());
            
            login = authUser(email,password);
            
            
            //If statements for login go here (dont have database)
            if (login != null){
            dispose();
            }
            else if(login.password != null) {
                //i dont know yet
            }else {
                   JOptionPane.showMessageDialog(LoginPage.this,
                        "Email or Password Invalid",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
                }
    }//GEN-LAST:event_loginButtonActionPerformed

        public LoginandRegvar login;
        private LoginandRegvar authUser(String email, String password){
            LoginandRegvar login = null;

            final String url = "DATABASE LINK SHOULD GO HERE"; //Need Database
            final String USERNAME = "java"; // EMAIL is read
            final String PASS = "";

            try (Connection connection = DriverManager.getConnection(url, USERNAME, PASS)){

                Statement state = connection.createStatement();
                String query = "SELECT * FROM BLANK WHERE email=? AND password=?"; //REPLACE "BLANK" WITH DATABASE TITLE

                //Prepared Statements (used to precompile SQL statements)
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                    login = new LoginandRegvar();
                    login.email = resultSet.getString("email");
                    login.password = resultSet.getString("password");  
                    //Need to return the username so it can be shown on the Performance tabs
                }

                state.close();
                connection.close();

            } catch (Exception e) {
               throw new IllegalStateException("Can't connect to the database", e);} 

           return login;         
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /*
        LoginPage loginPage = new LoginPage(null); //This Line Broken?
        LoginandRegVar login = loginPage.login;
        if (login != null) {
            System.out.println("Successful Authentication of: " + login.name);
            System.out.println("          Email: " + login.email);
        }
        else {
            System.out.println("Authentication canceled");
        }
            */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passwordInput;
    // End of variables declaration//GEN-END:variables
}


//Sources:
//https://www.youtube.com/watch?v=gCdj9OPAeT8 -The main source for the login page
//https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database