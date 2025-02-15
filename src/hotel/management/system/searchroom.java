package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class searchroom extends JFrame implements ActionListener {

    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton add, back;

    searchroom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel searchforroom = new JLabel("Search For Room");
        searchforroom.setBounds(250,11,186,31);
        searchforroom.setForeground(Color.WHITE);
        searchforroom.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(searchforroom);

        JLabel rbt = new JLabel("Room Bed Type");
        rbt.setBounds(50,70,120,20);
        rbt.setForeground(Color.WHITE);
        rbt.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(rbt);

        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(175,70,120,20);
        panel.add(choice);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,205,23);
        checkBox.setBackground(new Color(3,45,48));
        checkBox.setForeground(Color.WHITE);
        panel.add(checkBox);

        JLabel rn = new JLabel("Room Number");
        rn.setBounds(23,162,120,20);
        rn.setForeground(Color.WHITE);
        rn.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(rn);

        JLabel available = new JLabel("Availability");
        available.setBounds(175,162,120,20);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(available);

        JLabel status = new JLabel("Status");
        status.setBounds(306,162,120,20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(status);

        JLabel price = new JLabel("Price");
        price.setBounds(458,162,120,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(price);

        JLabel type = new JLabel("Bed Type");
        type.setBounds(580,162,120,20);
        type.setForeground(Color.WHITE);
        type.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(type);

        table = new JTable();
        table.setBounds(0,187,700,150);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);
        try {
            con con = new con();
            String q = "select * from room";
            ResultSet resultSet = con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        add = new JButton("Search");
        add.setBounds(200,400,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(380,400,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);




            setLayout(null);
            setUndecorated(true);
            setLocation(500,200);
            setSize(700,500);
            setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String q = "select * from room where bedtype = '"+choice.getSelectedItem()+"'";
            String q1 = "select * from room where availability = 'Availabile'  and bedtype = '"+choice.getSelectedItem()+"'";
            try {
                con con = new con();
                ResultSet resultSet = con.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                if (checkBox.isSelected()){
                    ResultSet resultSet1 = con.statement.executeQuery(q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new searchroom();
    }
}
