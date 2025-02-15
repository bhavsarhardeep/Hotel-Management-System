package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame implements ActionListener {

    JButton admin, reception;

    dashboard(){
        super("HOTEL MANAGEMENT SYSTEM");

        reception = new JButton("Reception");
        reception.setBounds(425,510,140,30);
        reception.setFont(new Font("Tahoma", Font.BOLD, 15));
        reception.setBackground(new Color(255,98,0));
        reception.setForeground(Color.WHITE);
        reception.addActionListener(this);
        add(reception);

        admin = new JButton("Admin");
        admin.setBounds(880,510,140,30);
        admin.setFont(new Font("Tahoma", Font.BOLD, 15));
        admin.setBackground(new Color(255,98,0));
        admin.setForeground(Color.WHITE);
        admin.addActionListener(this);
        add(admin);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image image1 = image.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label1 = new JLabel(image2);
        label1.setBounds(850,300,200,195);
        add(label1);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image img1 = img.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel label2 = new JLabel(img2);
        label2.setBounds(400,300,200,195);
        add(label2);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image imageIcon1 = imageIcon.getImage().getScaledInstance(1950,1090,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageIcon1);
        JLabel label = new JLabel(imageIcon2);
        label.setBounds(0,0,190,1090);
        add(label);


        setSize(1950,1090);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==reception){
            new reception();
            setVisible(false);
        }else {
            new login2();
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new dashboard();
    }
}
