package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField passwordField;
    JButton button, button1;

    login(){

        JLabel label1 = new JLabel("Username");
        label1.setBounds(40,20,100,30);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        label1.setForeground(Color.WHITE);
        add(label1);

        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(26,104,110));
        add(textField);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40,70,100,30);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.WHITE);
        add(label2);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(new Color(26,104,110));
        add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image image = imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(318,-30,255,300);
        add(label);

        button = new JButton("Login");
        button.setBounds(40,140,120,30);
        button.setFont(new Font("serif", Font.PLAIN,15));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        add(button);

        button1 = new JButton("Cancel");
        button1.setBounds(180,140,120,30);
        button1.setFont(new Font("serif", Font.PLAIN,15));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        add(button1);

        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            try{
                con con = new con();
                String username = textField.getText();
                String password = passwordField.getText();

                String q = "select * from login where username = '"+username+"' and password = '"+password+"' ";
                ResultSet resultSet = con.statement.executeQuery(q);
                if (resultSet.next()){
                    new dashboard();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid");
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            System.exit(102);
        }
    }
    public static void main(String[] args) {
        new login();
    }

}
