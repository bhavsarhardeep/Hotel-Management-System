package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class department extends JFrame {
    department(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel dept = new JLabel("Department");
        dept.setBounds(145,11,105,14);
        dept.setFont(new Font("Tahoma",Font.BOLD,14));
        dept.setForeground(Color.WHITE);
        panel.add(dept);

        JLabel budget = new JLabel("Budget");
        budget.setBounds(431,11,105,20);
        budget.setFont(new Font("Tahoma",Font.BOLD,14));
        budget.setForeground(Color.WHITE);
        panel.add(budget);

        JTable table = new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            con con = new con();
            String departmentinfo = "select * from department";
            ResultSet resultSet = con.statement.executeQuery(departmentinfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(400,410,120,30);
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
                setLocation(500,150);
                setSize(700,500);
                setVisible(true);
    }
    public static void main(String[] args) {
        new department();
    }
}
