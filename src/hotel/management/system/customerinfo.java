package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class customerinfo extends JFrame {
    customerinfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel id = new JLabel("ID");
        id.setBounds(31,11,46,14);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        id.setForeground(Color.WHITE);
        panel.add(id);

        JLabel number = new JLabel("Number");
        number.setBounds(150,11,100,14);
        number.setFont(new Font("Tahoma",Font.BOLD,14));
        number.setForeground(Color.WHITE);
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(270,11,70,14);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(360,11,70,14);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(480,11,70,14);
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        country.setForeground(Color.WHITE);
        panel.add(country);

        JLabel room = new JLabel("Room");
        room.setBounds(600,11,70,14);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        room.setForeground(Color.WHITE);
        panel.add(room);

        JLabel date = new JLabel("CI Time");
        date.setBounds(700,11,70,19);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        date.setForeground(Color.WHITE);
        panel.add(date);

        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(800,11,70,14);
        deposit.setFont(new Font("Tahoma",Font.BOLD,14));
        deposit.setForeground(Color.WHITE);
        panel.add(deposit);

        JTable table = new JTable();
        table.setBounds(10,40,890,400);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            con con = new con();
            String employeeinfo = "select * from customer";
            ResultSet resultSet = con.statement.executeQuery(employeeinfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(400,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

            setLayout(null);
            setUndecorated(true);
            setLocation(500,100);
            setSize(900,600);
            setVisible(true);
    }
    public static void main(String[] args) {
        new customerinfo();
    }
}
