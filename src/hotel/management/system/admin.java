package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {

    JButton addemployee,addroom,adddriver,logout,back;

    admin(){

        addemployee = new JButton("ADD EMPLOYEE");
        addemployee.setBounds(250,230,200,30);
        addemployee.setBackground(Color.WHITE);
        addemployee.setForeground(Color.BLACK);
        addemployee.setFont(new Font("Tahoma",Font.BOLD,15));
        addemployee.addActionListener(this);
        add(addemployee);

        addroom = new JButton("ADD ROOM");
        addroom.setBounds(250,380,200,30);
        addroom.setBackground(Color.WHITE);
        addroom.setForeground(Color.BLACK);
        addroom.setFont(new Font("Tahoma",Font.BOLD,15));
        addroom.addActionListener(this);
        add(addroom);

        adddriver = new JButton("ADD DRIVER");
        adddriver.setBounds(250,530,200,30);
        adddriver.setBackground(Color.WHITE);
        adddriver.setForeground(Color.BLACK);
        adddriver.setFont(new Font("Tahoma",Font.BOLD,15));
        adddriver.addActionListener(this);
        add(adddriver);

        logout = new JButton("Logout");
        logout.setBounds(10,750,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma",Font.BOLD,15));
        logout.addActionListener(this);
        add(logout);

        back = new JButton("Back");
        back.setBounds(110,750,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.addActionListener(this);
        add(back);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image image1 = image.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label1 = new JLabel(image2);
        label1.setBounds(70,180,120,120);
        add(label1);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image img1 = img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel label2 = new JLabel(img2);
        label2.setBounds(70,340,120,120);
        add(label2);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image imageIcon1 = imageIcon.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageIcon1);
        JLabel label = new JLabel(imageIcon2);
        label.setBounds(70,500,120,120);
        add(label);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image imageIcon4 = imageIcon3.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon5 = new ImageIcon(imageIcon4);
        JLabel label3 = new JLabel(imageIcon5);
        label3.setBounds(1000,250,400,400);
        add(label3);




        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==addemployee){
            new addemployee();
        } else if (e.getSource()==addroom) {
            new addrooms();
        } else if (e.getSource()==adddriver) {
            new adddriver();
        } else if (e.getSource()==logout) {
            System.exit(102);
        } else if (e.getSource()==back) {
            new dashboard();
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new admin();
    }
}
