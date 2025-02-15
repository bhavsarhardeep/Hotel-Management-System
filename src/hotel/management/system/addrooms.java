package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addrooms extends JFrame implements ActionListener {

    JTextField textField1,textField2;
    JComboBox comboBox, comboBox1, comboBox2;
    JButton button1, button2;

    addrooms(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label1 = new JLabel("Add Rooms");
        label1.setBounds(194,10,160,22);
        label1.setFont(new Font("Tahoma",Font.BOLD,22));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(64,70,152,22);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        textField1 = new JTextField();
        textField1.setBounds(200,70,156,20);
        textField1.setFont(new Font("Tahoma",Font.BOLD,14));
        textField1.setForeground(Color.WHITE);
        textField1.setBackground(new Color(16,108,115));
        panel.add(textField1);

        JLabel label3 = new JLabel("Availability");
        label3.setBounds(64,110,152,22);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        comboBox = new JComboBox(new String[]{"Availabile","Occupied"});
        comboBox.setBounds(200,110,156,20);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(new Color(16,108,115));
        panel.add(comboBox);

        JLabel label4 = new JLabel("Price");
        label4.setBounds(64,150,152,22);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        textField2 = new JTextField();
        textField2.setBounds(200,150,156,20);
        textField2.setFont(new Font("Tahoma",Font.BOLD,14));
        textField2.setForeground(Color.WHITE);
        textField2.setBackground(new Color(16,108,115));
        panel.add(textField2);

        JLabel label5 = new JLabel("Cleaning Status");
        label5.setBounds(64,190,152,22);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);
        comboBox1 = new JComboBox(new String[]{"Cleaned","Dirty"});
        comboBox1.setBounds(200,190,156,20);
        comboBox1.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox1.setForeground(Color.WHITE);
        comboBox1.setBackground(new Color(16,108,115));
        panel.add(comboBox1);

        JLabel label6 = new JLabel("Bed Type");
        label6.setBounds(64,230,152,22);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);
        comboBox2 = new JComboBox(new String[]{"Single Bed","Double Bed"});
        comboBox2.setBounds(200,230,156,20);
        comboBox2.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox2.setForeground(Color.WHITE);
        comboBox2.setBackground(new Color(16,108,115));
        panel.add(comboBox2);

        button1 = new JButton("Add");
        button1.setBounds(64,321,111,33);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        panel.add(button1);

        button2 = new JButton("Back");
        button2.setBounds(198,321,111,33);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        panel.add(button2);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image image1 = image.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label = new JLabel(image2);
        label.setBounds(500,60,300,300);
        panel.add(label);

            setUndecorated(true);
            setLocation(20,200);
            setLayout(null);
            setSize(900,500);
            setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1){
            try {
                con con = new con();
                String room = textField1.getText();
                String available = (String) comboBox.getSelectedItem();
                String price = textField2.getText();
                String status = (String) comboBox1.getSelectedItem();
                String type = (String) comboBox2.getSelectedItem();

                String q = "insert into room values('"+room+"','"+ available+"','"+status+"','"+price+"','"+type+"')";
                con.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Room Successfully Added");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            new admin();
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new addrooms();
    }
}
