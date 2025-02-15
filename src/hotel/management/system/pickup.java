package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class pickup extends JFrame {
    pickup(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,590);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel pus = new JLabel("Pick Up Service");
        pus.setBounds(90,11,160,25);
        pus.setFont(new Font("Tahoma",Font.BOLD,20));
        pus.setForeground(Color.WHITE);
        panel.add(pus);

        JLabel toc = new JLabel("Type of Car");
        toc.setBounds(32,97,89,14);
        toc.setFont(new Font("Tahoma",Font.PLAIN,14));
        toc.setForeground(Color.WHITE);
        panel.add(toc);

        Choice choice = new Choice();
        choice.setBounds(123,94,150,25);
        panel.add(choice);

        try{
            con con = new con();
            ResultSet resultSet = con.statement.executeQuery("select * from driver");
            while (resultSet.next()){
                choice.add(resultSet.getString("carname"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(24,208,46,14);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(165,208,46,14);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(264,208,100,14);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel carcompany = new JLabel("Company");
        carcompany.setBounds(366,208,100,14);
        carcompany.setFont(new Font("Tahoma",Font.BOLD,14));
        carcompany.setForeground(Color.WHITE);
        panel.add(carcompany);

        JLabel carname = new JLabel("Car Name");
        carname.setBounds(486,208,100,14);
        carname.setFont(new Font("Tahoma",Font.BOLD,14));
        carname.setForeground(Color.WHITE);
        panel.add(carname);

        JLabel available = new JLabel("Available");
        available.setBounds(600,208,100,14);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel location = new JLabel("Location");
        location.setBounds(700  ,208,100,14);
        location.setFont(new Font("Tahoma",Font.BOLD,14));
        location.setForeground(Color.WHITE);
        panel.add(location);


        JTable table = new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            con con = new con();
            String driverinfo = "select * from driver";
            ResultSet resultSet = con.statement.executeQuery(driverinfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con con = new con();
                    String q = "select * from driver where carname = '"+ choice.getSelectedItem()+"' ";
                    ResultSet resultSet = con.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel.add(display);

        JButton back = new JButton("Back");
        back.setBounds(420,500,120,30);
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
            setLocation(500,100);
            setSize(800,600);
            setVisible(true);
    }
    public static void main(String[] args) {
        new pickup();
    }
}
