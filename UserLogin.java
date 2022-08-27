package com.jack2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component ;
import java.util.Random;

class UserLoginFrame extends JFrame {
    private JButton loginButton = new JButton("login");
private UserLoginFrame jf = this ;
private int[] password = new int[4] ;
private int loginTime = 0 ;
    JPasswordField passwordField = new JPasswordField();
    private JTextField userNameField = new JTextField();
private String[] username = new String[4]  ;
    public UserLoginFrame() {

        password[0] = 123456 ;
        username[0] = "jack666" ;
        this.initFrame();
        this.paintView();
        this.addButtonListener();
        this.setVisible(true);
    }
    public void addButtonListener() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked") ;
                String s0 = new String(userNameField.getText());
                String s1 = new String(passwordField.getPassword()) ;
                if(s1.isEmpty()||s0.isEmpty()){
                    JOptionPane.showMessageDialog(jf,"please input parameters") ;
                    return ;
                }
                Integer ii = Integer.parseInt(s1) ;
                int i0 = ii ;

                if(!s0.equals(username[0])&&i0 != password[0]){
                    loginTime++ ;
                    if(loginTime==4){
                        JOptionPane.showMessageDialog(jf,"your can't retry again");

                        System.exit(0);
                        return ;
                    }
                    JOptionPane.showMessageDialog(jf,"login failed " + loginTime + " times") ;
                passwordField.setText("");
                userNameField.setText("") ;
                }
                if(loginTime == 3){
                    JOptionPane.showConfirmDialog(jf,"this is final chance") ;
                }


                if(s0.equals(username[0])&&i0 == password[0]){
          JOptionPane.showMessageDialog(jf,"login success") ;
               // jf.tRImage();

                }

            }
        });
    }
        public void paintView () {
            JLabel tips = new JLabel("Hello");
            tips.setBounds(60, 60, 60, 10);
            this.add(tips);

            passwordField.setBounds(200, 100, 200, 20);
            this.add(passwordField);

            userNameField.setBounds(200, 80, 200, 20);
            this.add(userNameField);

            loginButton.setBounds(250, 120, 70, 20);
            this.add(loginButton);
        }
        public void initFrame () {
            this.setLayout(null);
            this.setSize(600, 300);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(3);
            this.setAlwaysOnTop(true);
        }
        public void tRImage(){
       while(true){
           Random r0 = new Random() ;
        int i0 = r0.nextInt(1080) ;
            Random r1 = new Random() ;
            int i1 = r0.nextInt(2000) ;
        JFrame imageFrame = new JFrame("Love TuRan Forever") ;
        imageFrame.setBounds(i1,i0,500,500) ;
        imageFrame.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        /*JLabel imageLabel = new JLabel(new ImageIcon("")) ;
        * imageLabel.setBounds(0,0,500,500) ;
        * imageFrame.add(imageLabel) ;
        * */
        imageFrame.setAlwaysOnTop(true);
        imageFrame.setVisible(true);}
        }
        public static void main (String[]args){
         UserLoginFrame loginFrame =  new UserLoginFrame();
        }
    }
