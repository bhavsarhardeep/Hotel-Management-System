package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class manager extends JFrame {
    manager(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel name = new JLabel("Name");
        name.setBounds(41,11,70,19);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(159,11,70,19);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(273,11,70,19);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(416,11,70,19);
        job.setFont(new Font("Tahoma",Font.BOLD,14));
        job.setForeground(Color.WHITE);
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(536,11,70,19);
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        salary.setForeground(Color.WHITE);
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(656,11,70,19);
        phone.setFont(new Font("Tahoma",Font.BOLD,14));
        phone.setForeground(Color.WHITE);
        panel.add(phone);

        JLabel email = new JLabel("E-mail");
        email.setBounds(786,11,70,19);
        email.setFont(new Font("Tahoma",Font.BOLD,14));
        email.setForeground(Color.WHITE);
        panel.add(email);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(896,11,70,19);
        aadhar.setFont(new Font("Tahoma",Font.BOLD,14));
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            con con = new con();
            String employeeinfo = "select * from employee where job = 'manager'";
            ResultSet resultSet = con.statement.executeQuery(employeeinfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(350,500,120,30);
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
            setLocation(430,100);
            setSize(1000,600);
            setVisible(true);
    }
    public static void main(String[] args) {
        new manager();
    }
}
