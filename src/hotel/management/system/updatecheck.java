package hotel.management.system;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updatecheck extends JFrame{


    updatecheck(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image1 = image.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label = new JLabel(image2);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel labletitle = new JLabel("Check-In Details");
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

        JLabel lablename = new JLabel("Name :");
        lablename.setBounds(25,174,100,14);
        lablename.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablename.setForeground(Color.WHITE);
        panel.add(lablename);
        JTextField textFieldname = new JTextField();
        textFieldname.setBounds(248,174,140,20);
        panel.add(textFieldname);

        JLabel lablecheckin = new JLabel("Checked-In :");
        lablecheckin.setBounds(25,216,100,14);
        lablecheckin.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablecheckin.setForeground(Color.WHITE);
        panel.add(lablecheckin);
        JTextField textFieldcheckin = new JTextField();
        textFieldcheckin.setBounds(248,216,140,20);
        panel.add(textFieldcheckin);

        JLabel lablecheckap = new JLabel("Amount Paid (Rs) :");
        lablecheckap.setBounds(25,261,150,14);
        lablecheckap.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablecheckap.setForeground(Color.WHITE);
        panel.add(lablecheckap);
        JTextField textFieldap = new JTextField();
        textFieldap.setBounds(248,261,140,20);
        panel.add(textFieldap);

        JLabel lablecheckpa = new JLabel("Pending Amount (Rs) :");
        lablecheckpa.setBounds(25,302,150,14);
        lablecheckpa.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablecheckpa.setForeground(Color.WHITE);
        panel.add(lablecheckpa);
        JTextField textFieldpa = new JTextField();
        textFieldpa.setBounds(248,302,140,20);
        panel.add(textFieldpa);

        JButton update = new JButton("Update");
        update.setBounds(56,378,89,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con con = new con();
                    String q = choice.getSelectedItem();
                    String room = textFieldrn.getText();
                    String name = textFieldname.getText();
                    String check = textFieldcheckin.getText();
                    String amount = textFieldap.getText();
                    con.statement.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+check+"', deposite = '"+amount+"' where number = '"+q+"' ");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel.add(update);

        JButton back = new JButton("Back");
        back.setBounds(168,378,89,25);
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
        check.setBounds(281,378,89,25);
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
                        textFieldname.setText(resultSet.getString("name"));
                        textFieldcheckin.setText(resultSet.getString("checkintime"));
                        textFieldap.setText(resultSet.getString("deposite"));
                    }

                    ResultSet resultSet1 = con.statement.executeQuery("select * from room where roomnumber = '"+textFieldrn.getText()+"' ");

                    while (resultSet1.next()){
                        String price = resultSet1.getString("price");
                        int amountpaid = Integer.parseInt(price) - Integer.parseInt(textFieldap.getText());
                        textFieldpa.setText(""+amountpaid);
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
            setSize(950,500);
            setVisible(true);
    }
    public static void main(String[] args) {
        new updatecheck();
    }
}
