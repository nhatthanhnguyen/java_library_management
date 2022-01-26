/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import java.sql.*;
import javax.swing.JOptionPane;
import DataAccessObject.SQLConnection;

import java.util.logging.Level;
import java.util.logging.Logger;


public class DangNhap extends javax.swing.JFrame {

    public DangNhap() {
        initComponents();
        setVisible(true);
        setResizable(false);
        loginButton.setFocusPainted(false);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        background = new javax.swing.JLabel();
        titleVi = new javax.swing.JLabel();
        titleEn = new javax.swing.JLabel();
        loginLogo = new javax.swing.JLabel();
        loginText = new javax.swing.JLabel();
        loginName = new javax.swing.JTextField();
        loginNameText = new javax.swing.JLabel();
        loginPassword = new javax.swing.JPasswordField();
        passwordText = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        ptitLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setMinimumSize(new java.awt.Dimension(950, 500));
        setSize(new java.awt.Dimension(950, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        background.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.png")))); // NOI18N);

    titleVi.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    titleVi.setForeground(new java.awt.Color(0, 0, 0));
    titleVi.setText("HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG");

    titleEn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
    titleEn.setForeground(new java.awt.Color(255, 0, 0));
    titleEn.setText("Posts and Telecommunications Institute of Technology");

    loginLogo.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.png")))); // NOI18N);
    loginLogo.setText("c");

    loginText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
    loginText.setForeground(new java.awt.Color(0, 0, 0));
    loginText.setText("ĐĂNG NHẬP");

    loginName.setBackground(new java.awt.Color(255, 255, 255));
    loginName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    loginName.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            loginNameKeyPressed(evt);
        }
    });

    loginNameText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    loginNameText.setForeground(new java.awt.Color(0, 0, 0));
    loginNameText.setText("Tên đăng nhập");

    loginPassword.setBackground(new java.awt.Color(255, 255, 255));
    loginPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    loginPassword.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            loginPasswordKeyPressed(evt);
        }
    });

    passwordText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    passwordText.setForeground(new java.awt.Color(0, 0, 0));
    passwordText.setText("Mật khẩu");

    loginButton.setBackground(new java.awt.Color(255, 0, 0));
    loginButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    loginButton.setForeground(new java.awt.Color(255, 255, 255));
    loginButton.setText("Login");
    loginButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            loginButtonActionPerformed(evt);
        }
    });

    ptitLogo.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ptitlogo.png")))); // NOI18N);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(ptitLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleEn)
                        .addComponent(titleVi))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(6, 6, 6)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(loginName, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(loginNameText))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(passwordText))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(loginLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(loginText))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(65, 65, 65))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(loginLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(titleVi)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(titleEn))
                        .addComponent(ptitLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(52, 52, 52)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(loginText)
                    .addGap(31, 31, 31)
                    .addComponent(loginNameText)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(loginName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(passwordText)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(56, 56, 56)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(104, 104, 104))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(43, 43, 43))))
    );

    loginText.getAccessibleContext().setAccessibleDescription("");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String userName = loginName.getText();
        String password = new String(loginPassword.getPassword());
        if(userName.length() == 0 || password.length() == 0){
            JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin");
        } else {
            Connection connection = SQLConnection.openConnection();
            String query = "SELECT * FROM [dbo].[THONGTINDANGNHAP]";
            try {
                assert connection != null;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet res = preparedStatement.executeQuery();
                boolean isSuccess = false;
                while(res.next()){
                    if(res.getString("TenDangNhap").equals(userName) && res.getString("MatKhau").equals(password)){
                        isSuccess = true;
                        break;
                    }
                }
                preparedStatement.close();
                res.close();
                connection.close();

                if(!isSuccess){
                    JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
                    loginName.setText("");
                    loginPassword.setText("");
                    loginName.requestFocus();
                } else {
                    new TrangChu().setVisible(true);
                    this.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loginNameKeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == 10){
            loginPassword.requestFocus();
        }
    }

    private void loginPasswordKeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == 10){
            String userName = loginName.getText();
            String password = new String(loginPassword.getPassword());
            if(userName.length() == 0 || password.length() == 0){
                JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin");
            } else {
                Connection connection = SQLConnection.openConnection();
                String query = "SELECT * FROM [dbo].[THONGTINDANGNHAP]";
                try {
                    assert connection != null;
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet res = preparedStatement.executeQuery();
                    boolean isSuccess = false;
                    while(res.next()){
                        if(res.getString("TenDangNhap").equals(userName) && res.getString("MatKhau").equals(password)){
                            isSuccess = true;
                            break;
                        }
                    }
                    preparedStatement.close();
                    res.close();
                    connection.close();
                    
                    if(!isSuccess){
                        JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
                        loginName.setText("");
                        loginPassword.setText("");
                        loginName.requestFocus();
                    } else {
                        new TrangChu().setVisible(true);
                        this.setVisible(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        }
    }

    public static void main(String args[]) {
        DangNhap dangNhap = new DangNhap();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dangNhap.setVisible(true);
                dangNhap.setResizable(false);
                dangNhap.setTitle("Library Management");
                dangNhap.loginButton.setFocusPainted(false);
            }
        });
    }

    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLogo;
    private javax.swing.JTextField loginName;
    private javax.swing.JLabel loginNameText;
    private javax.swing.JPasswordField loginPassword;
    private javax.swing.JLabel loginText;
    private javax.swing.JLabel passwordText;
    private javax.swing.JLabel ptitLogo;
    private javax.swing.JLabel titleEn;
    private javax.swing.JLabel titleVi;
}
