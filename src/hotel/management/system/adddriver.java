package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adddriver extends JFrame implements ActionListener {

    JTextField nametext, agetext, carctext, carntext, loctext;
    JComboBox comboBox, comboBox1;
    JButton add, back;

    adddriver(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel label = new JLabel("Add Drivers");
        label.setBounds(194,10,200,22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(label);

        JLabel name = new JLabel("Name");
        name.setBounds(64,70,120,22);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);
        nametext = new JTextField();
        nametext.setBounds(174,70,156,20);
        nametext.setForeground(Color.WHITE);
        nametext.setFont(new Font("Tahoma",Font.BOLD,14));
        nametext.setBackground(new Color(16,108,115));
        panel.add(nametext);

        JLabel age = new JLabel("Age");
        age.setBounds(64,110,120,22);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(age);
        agetext = new JTextField();
        agetext.setBounds(174,110,156,20);
        agetext.setForeground(Color.WHITE);
        agetext.setFont(new Font("Tahoma",Font.BOLD,14));
        agetext.setBackground(new Color(16,108,115));
        panel.add(agetext);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(64, 150, 102, 22);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        comboBox = new JComboBox(new String[]{"Male","Female"});
        comboBox.setBackground(new Color(16,108,115));
        comboBox.setBounds(176, 150, 154, 20);
        comboBox.setFont(new Font("Tahoma", Font.BOLD,14));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);

        JLabel carc = new JLabel("Car Company");
        carc.setBounds(64,190,120,22);
        carc.setForeground(Color.WHITE);
        carc.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carc);
        carctext = new JTextField();
        carctext.setBounds(174,190,156,20);
        carctext.setForeground(Color.WHITE);
        carctext.setFont(new Font("Tahoma",Font.BOLD,14));
        carctext.setBackground(new Color(16,108,115));
        panel.add(carctext);

        JLabel carn = new JLabel("Car Name");
        carn.setBounds(64,230,120,22);
        carn.setForeground(Color.WHITE);
        carn.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carn);
        carntext = new JTextField();
        carntext.setBounds(174,230,156,20);
        carntext.setForeground(Color.WHITE);
        carntext.setFont(new Font("Tahoma",Font.BOLD,14));
        carntext.setBackground(new Color(16,108,115));
        panel.add(carntext);

        JLabel available = new JLabel("Available");
        available.setBounds(64, 270, 102, 22);
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        available.setForeground(Color.WHITE);
        panel.add(available);
        comboBox1 = new JComboBox(new String[]{"Yes","No"});
        comboBox1.setBackground(new Color(16,108,115));
        comboBox1.setBounds(176, 270, 154, 20);
        comboBox1.setFont(new Font("Tahoma", Font.BOLD,14));
        comboBox1.setForeground(Color.WHITE);
        panel.add(comboBox1);

        JLabel loc = new JLabel("Location");
        loc.setBounds(64,310,120,22);
        loc.setForeground(Color.WHITE);
        loc.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(loc);
        loctext = new JTextField();
        loctext.setBounds(174,310,156,20);
        loctext.setForeground(Color.WHITE);
        loctext.setFont(new Font("Tahoma",Font.BOLD,14));
        loctext.setBackground(new Color(16,108,115));
        panel.add(loctext);

        add = new JButton("Add");
        add.setBounds(64,380,111,33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(198,380,111,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image1 = image.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label1 = new JLabel(image2);
        label1.setBounds(500,60,300,300);
        panel.add(label1);

            setUndecorated(true);
            setLayout(null);
            setLocation(20,200);
            setSize(900,500);
            setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== add){
            try {
                con con = new con();
                String name = nametext.getText();
                String age = agetext.getText();
                String gender = (String) comboBox.getSelectedItem();
                String carcompany = carctext.getText();
                String carname = carntext.getText();
                String available = (String) comboBox1.getSelectedItem();
                String location = loctext.getText();

                String q = "insert into driver values ('"+name+"', '"+age+"', '"+gender+"', '"+carcompany+"', '"+carname+"', '"+available+"', '"+location+"')";
                con.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null, "Driver Added Successully");
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
        new adddriver();
    }
}
