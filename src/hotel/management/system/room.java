package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class room extends JFrame{

    JTable table;
    JButton back;

    room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image1 = image.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label = new JLabel(image2);
        label.setBounds(600,200,200,200);
        panel.add(label);

        JLabel roomno = new JLabel("Room No.");
        roomno.setBounds(12,15,80,19);
        roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        roomno.setForeground(Color.WHITE);
        panel.add(roomno);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(119,15,80,19);
        availability.setFont(new Font("Tahoma",Font.BOLD,14));
        availability.setForeground(Color.WHITE);
        panel.add(availability);

        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(210,15,150,19);
        clean.setFont(new Font("Tahoma",Font.BOLD,14));
        clean.setForeground(Color.WHITE);
        panel.add(clean);

        JLabel price = new JLabel("Price");
        price.setBounds(330,15,80,19);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setForeground(Color.WHITE);
        panel.add(price);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(417,15,80,19);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        bed.setForeground(Color.WHITE);
        panel.add(bed);



        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            con con = new con();
            String roominfo = "select * from room";
            ResultSet resultSet = con.statement.executeQuery(roominfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(200,500,120,30);
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
            setSize(900,600);
            setVisible(true);
    }
    public static void main(String[] args) {
        new room();
    }
}
