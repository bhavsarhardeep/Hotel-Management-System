package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame {
    reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(3,45,48));
        add(panel1);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"));
        Image image1 = image.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label1 = new JLabel(image2);
        label1.setBounds(300,20,800,800);
        panel.add(label1);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image img1 = img.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel label2 = new JLabel(img2);
        label2.setBounds(5,530,250,250);
        panel1.add(label2);

        JButton buttonnfc = new JButton("New Customer Form");
        buttonnfc.setBounds(30,30,200,30);
        buttonnfc.setBackground(Color.BLACK);
        buttonnfc.setForeground(Color.WHITE);
        buttonnfc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new newcustomer();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttonnfc);

        JButton buttonroom = new JButton("Room");
        buttonroom.setBounds(30,70,200,30);
        buttonroom.setBackground(Color.BLACK);
        buttonroom.setForeground(Color.WHITE);
        buttonroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new room();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttonroom);

        JButton buttondepartment = new JButton("Department");
        buttondepartment.setBounds(30,110,200,30);
        buttondepartment.setBackground(Color.BLACK);
        buttondepartment.setForeground(Color.WHITE);
        buttondepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new department();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttondepartment);

        JButton buttonaei = new JButton("All Employee Info");
        buttonaei.setBounds(30,150,200,30);
        buttonaei.setBackground(Color.BLACK);
        buttonaei.setForeground(Color.WHITE);
        buttonaei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new employee();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttonaei);

        JButton buttonci = new JButton("Customer Info");
        buttonci.setBounds(30,190,200,30);
        buttonci.setBackground(Color.BLACK);
        buttonci.setForeground(Color.WHITE);
        buttonci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new customerinfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttonci);

        JButton buttonmi = new JButton("Manager Info");
        buttonmi.setBounds(30,230,200,30);
        buttonmi.setBackground(Color.BLACK);
        buttonmi.setForeground(Color.WHITE);
        buttonmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new manager();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttonmi);

        JButton buttonco = new JButton("Check Out");
        buttonco.setBounds(30,270,200,30);
        buttonco.setBackground(Color.BLACK);
        buttonco.setForeground(Color.WHITE);
        buttonco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new checkout();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttonco);

        JButton buttonuc = new JButton("Update Check-In Details");
        buttonuc.setBounds(30,310,200,30);
        buttonuc.setBackground(Color.BLACK);
        buttonuc.setForeground(Color.WHITE);
        buttonuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new updatecheck();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttonuc);

        JButton buttonurs = new JButton("Update Room Status");
        buttonurs.setBounds(30,350,200,30);
        buttonurs.setBackground(Color.BLACK);
        buttonurs.setForeground(Color.WHITE);
        buttonurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new updateroom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttonurs);

        JButton buttonpus = new JButton("Pick-up Service");
        buttonpus.setBounds(30,390,200,30);
        buttonpus.setBackground(Color.BLACK);
        buttonpus.setForeground(Color.WHITE);
        buttonpus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new pickup();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttonpus);

        JButton buttonsr = new JButton("Search Room");
        buttonsr.setBounds(30,430,200,30);
        buttonsr.setBackground(Color.BLACK);
        buttonsr.setForeground(Color.WHITE);
        buttonsr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new searchroom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(buttonsr);

        JButton logout = new JButton("Logout");
        logout.setBounds(30,470,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.exit(102);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(logout);

        JButton back = new JButton("Back");
        back.setBounds(140,470,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    new dashboard();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel1.add(back);

            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            setSize(1950,1090);
            setVisible(true);
    }
    public static void main(String[] args) {
        new reception();
    }
}
