package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateroom extends JFrame {
    updateroom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image1 = image.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label = new JLabel(image2);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel labletitle = new JLabel("Update Room Status");
        labletitle.setBounds(124,11,222,25);
        labletitle.setFont(new Font("Tahoma",Font.BOLD,20));
        labletitle.setForeground(Color.WHITE);
        panel.add(labletitle);

        JLabel lableid = new JLabel("ID :");
        lableid.setBounds(25,88,46,14);
        lableid.setFont(new Font("Tahoma",Font.PLAIN,14));
        lableid.setForeground(Color.WHITE);
        panel.add(lableid);

        Choice choice = new Choice();
        choice.setBounds(248,88,140,20);
        panel.add(choice);
        try {
            con con = new con();
            ResultSet resultSet = con.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel lablern = new JLabel("Room Number :");
        lablern.setBounds(25,129,107,14);
        lablern.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablern.setForeground(Color.WHITE);
        panel.add(lablern);
        JTextField textFieldrn = new JTextField();
        textFieldrn.setBounds(248,129,140,20);
        panel.add(textFieldrn);

        JLabel lableavailable = new JLabel("Availability :");
        lableavailable.setBounds(25,174,100,14);
        lableavailable.setFont(new Font("Tahoma",Font.PLAIN,14));
        lableavailable.setForeground(Color.WHITE);
        panel.add(lableavailable);
        JTextField textFieldavailable = new JTextField();
        textFieldavailable.setBounds(248,174,140,20);
        panel.add(textFieldavailable);

        JLabel lablestatus = new JLabel("Cleaning Status :");
        lablestatus.setBounds(25,216,100,14);
        lablestatus.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablestatus.setForeground(Color.WHITE);
        panel.add(lablestatus);
        JTextField textFieldstatus = new JTextField();
        textFieldstatus.setBounds(248,216,140,20);
        panel.add(textFieldstatus);

        JButton update = new JButton("Update");
        update.setBounds(120,315,89,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con con = new con();
                    String status = textFieldstatus.getText();
                    con.statement.executeUpdate("update room set cleaningstatus = '"+status+"' where roomnumber = "+textFieldrn.getText());
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel.add(update);

        JButton back = new JButton("Back");
        back.setBounds(180,355,89,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

        JButton check = new JButton("Check");
        check.setBounds(60,355,89,25);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from customer where number = '"+id+"' ";
                try {
                    con con = new con();
                    ResultSet resultSet = con.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldrn.setText(resultSet.getString("room"));
                    }

                    ResultSet resultSet1 = con.statement.executeQuery("select * from room where roomnumber = '"+textFieldrn.getText()+"' ");

                    while (resultSet1.next()){
                        textFieldavailable.setText(resultSet1.getString("availability"));
                        textFieldstatus.setText(resultSet1.getString("cleaningstatus"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel.add(check);


        setLayout(null);
        setUndecorated(true);
        setLocation(400,200);
        setSize(950,450);
        setVisible(true);

    }

    public static void main(String[] args) {
        new updateroom();
    }
}
