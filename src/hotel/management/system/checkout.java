package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class checkout extends JFrame {

    checkout(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel labletitle = new JLabel("Check-Out");
        labletitle.setBounds(100,20,150,30);
        labletitle.setFont(new Font("Tahoma",Font.BOLD,20));
        labletitle.setForeground(Color.WHITE);
        panel.add(labletitle);

        JLabel userid = new JLabel("Customer Id");
        userid.setBounds(30,80,150,30);
        userid.setFont(new Font("Tahoma",Font.PLAIN,14));
        userid.setForeground(Color.WHITE);
        panel.add(userid);

        Choice customer = new Choice();
        customer.setBounds(200,80,150,30);
        panel.add(customer);

        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(30,130,150,30);
        roomno.setFont(new Font("Tahoma",Font.PLAIN,14));
        roomno.setForeground(Color.WHITE);
        panel.add(roomno);

        JLabel lableroomno = new JLabel();
        lableroomno.setBounds(200,130,150,30);
        lableroomno.setFont(new Font("Tahoma",Font.PLAIN,14));
        lableroomno.setForeground(Color.WHITE);
        panel.add(lableroomno);

        JLabel checkintime = new JLabel("Check-In Time");
        checkintime.setBounds(30,180,150,30);
        checkintime.setFont(new Font("Tahoma",Font.PLAIN,14));
        checkintime.setForeground(Color.WHITE);
        panel.add(checkintime);

        JLabel lablecheckintime = new JLabel();
        lablecheckintime.setBounds(200,180,200,30);
        lablecheckintime.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablecheckintime.setForeground(Color.WHITE);
        panel.add(lablecheckintime);

        JLabel checkouttime = new JLabel(" Check-Out Time");
        checkouttime.setBounds(30,230,150,30);
        checkouttime.setFont(new Font("Tahoma",Font.PLAIN,14));
        checkouttime.setForeground(Color.WHITE);
        panel.add(checkouttime);

        Date date = new Date();

        JLabel labelcheckouttime = new JLabel(""+date);
        labelcheckouttime.setBounds(200,230,200,30);
        labelcheckouttime.setFont(new Font("Tahoma",Font.PLAIN,14));
        labelcheckouttime.setForeground(Color.WHITE);
        panel.add(labelcheckouttime);


        try {
            con con = new con();
            ResultSet resultSet = con.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                customer.add(resultSet.getString("number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        JButton checkoutbtn = new JButton("Check-Out");
        checkoutbtn.setBounds(30,300,120,30);
        checkoutbtn.setBackground(Color.BLACK);
        checkoutbtn.setForeground(Color.WHITE);
        checkoutbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con con = new con();
                    con.statement.executeUpdate("delete from customer where number = '"+customer.getSelectedItem()+"' ");
                    con.statement.executeUpdate("update room set availability = 'Available' where roomnumber = '"+lableroomno.getText()+"' ");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel.add(checkoutbtn);

        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con con = new con();
                try {
                    ResultSet resultSet = con.statement.executeQuery("select * from customer where number = '"+customer.getSelectedItem()+"' ");
                    while (resultSet.next()){
                        lableroomno.setText(resultSet.getString("room"));
                        lablecheckintime.setText(resultSet.getString("checkintime"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel.add(check);

        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

            setLayout(null);
            setUndecorated(true);
            setLocation(500,210);
            setSize(800,400);
            setVisible(true);
    }
    public static void main(String[] args) {
        new checkout();
    }
}
