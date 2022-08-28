package com.jack2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class UserLoginFrame extends JFrame {
    private final JButton loginButton = new JButton("login");
    private UserLoginFrame jf;
    private final JButton registerButton = new JButton("register") ;
    private String password;
    private int loginTime = 0;
    JPasswordField passwordField = new JPasswordField();
    private final JTextField userNameField = new JTextField();
    private String username;
    private String inputUsername;
    private String inputPassword;

    public UserLoginFrame(String username, String password) {
        this.addRegisterButtonActionListener();
        this.setjf();
        this.setPassword(password);
        this.setUsername(username);
        this.initFrame();
        this.paintView();
        this.addLoginButtonListener();
        this.setVisible(true);
    }
    public UserLoginFrame() {
        this.addRegisterButtonActionListener();
        this.setjf();
        this.initFrame();
        this.paintView();
        this.addLoginButtonListener();
        this.setVisible(true);
    }
public void setUsername(String username) {
this.username = username ;
}
public void setPassword(String password){
        this.password = password ;
}
    public void setjf() {
        jf = this;
    }

    public void setInputPassword() {
        this.inputPassword = new String(this.passwordField.getPassword());
    }

    public void setInputUsername() {

        this.inputUsername =this.userNameField.getText();
    }

    public void addLoginButtonListener() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
                jf.setInputPassword();
                jf.setInputUsername();
                if (jf.isEmpty1()) {
                    JOptionPane.showMessageDialog(jf, "please input parameters");
                    return;
                }
                if (!jf.inputUsername.equals(jf.username) && !jf.inputPassword.equals(jf.password)) {
                    jf.loginTime++;
                    if (jf.loginTime == 4) {
                        JOptionPane.showMessageDialog(jf, "your can't retry again");

                        System.exit(0);
                        return;
                    }
                    JOptionPane.showMessageDialog(jf, "login failed " + loginTime + " times");
                    jf.passwordField.setText("");
                    jf.userNameField.setText("");
                }
                if (jf.loginTime == 3) {
                    JOptionPane.showConfirmDialog(jf, "this is final chance");
                }


                if (jf.inputUsername.equals(username) && jf.inputPassword.equals(jf.password)) {
                    JOptionPane.showMessageDialog(jf, "login success");
                    jf.loginTime = 0;
                    jf.tRImage();

                }

            }
        });

    }

    public boolean isEmpty1() {
        if (this.inputPassword.isEmpty() || this.inputUsername.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void paintView() {
        JLabel tips = new JLabel("Hello");
        tips.setBounds(60, 60, 60, 10);
        this.add(tips);

        passwordField.setBounds(200, 100, 200, 20);
        this.add(passwordField);

        userNameField.setBounds(200, 80, 200, 20);
        this.add(userNameField);
        this.registerButton.setBounds(310, 120, 90, 20);
        this.add(this.registerButton);
        this.loginButton.setBounds(210, 120, 90, 20);
        this.add(this.loginButton);
    }
public void addRegisterButtonActionListener(){
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jf.passwordField.getPassword()==null||jf.userNameField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(jf,"register Failed") ;
                    return ;
                }
                jf.setInputPassword();
                jf.setInputUsername();
                jf.password = jf.inputPassword ;
                jf.username = jf.inputUsername ;
JOptionPane.showMessageDialog(jf,"Register Success");
            }
        });
}

    public void initFrame() {
        this.setLayout(null);
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(1);
        this.setAlwaysOnTop(true);
    }

    public void tRImage() {
        while (true) {
            Random r0 = new Random();
            int i0 = r0.nextInt(1080);
            int i1 = r0.nextInt(2000);
            JFrame imageFrame = new JFrame("Love TuRan Forever");
            imageFrame.setBounds(i1, i0, 500, 500);
            imageFrame.setDefaultCloseOperation(3);
            /*JLabel imageLabel = new JLabel(new ImageIcon("")) ;
             * imageLabel.setBounds(0,0,500,500) ;
             * imageFrame.add(imageLabel) ;
             * */
            imageFrame.setAlwaysOnTop(true);
            imageFrame.setVisible(true);
        }
    }


    public static void main(String[] args) {
        UserLoginFrame loginFrame = new UserLoginFrame("jack", "admin666");
    }
}
