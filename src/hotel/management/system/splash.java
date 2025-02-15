package hotel.management.system;

import javax.swing.*;

public class splash extends JFrame {

    splash(){

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0,0,858,680);
        add(label);

        setLayout(null);
        setLocation(300,80);
        setSize(858,680);
        setVisible(true);

        try {
            Thread.sleep(5000);
            new login();
            setVisible(false);
        }catch (Exception E){
            E.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new splash();
    }
}
