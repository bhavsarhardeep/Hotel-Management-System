package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class newcustomer extends JFrame implements ActionListener{

    JComboBox comboBox;
    JTextField textFieldnumber, textFieldname, textFieldcountry, textFielddeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date1;
    JButton add, back;

    newcustomer(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image1 = image.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel label = new JLabel(image2);
        label.setBounds(500,150,200,200);
        panel.add(label);

        JLabel lablename = new JLabel("New Customer Form");
        lablename.setBounds(118,11,260,53);
        lablename.setFont(new Font("Tahoma",Font.BOLD,20));
        lablename.setForeground(Color.WHITE);
        panel.add(lablename);

        JLabel lableid = new JLabel("ID :");
        lableid.setBounds(35,76,200,14);
        lableid.setFont(new Font("Tahoma",Font.PLAIN,14));
        lableid.setForeground(Color.WHITE);
        panel.add(lableid);
        comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter ID", "Driving License",});
        comboBox.setBounds(271,76,150,20);
        comboBox.setFont(new Font("Tahoma",Font.PLAIN,14));
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);

        JLabel lablenumber = new JLabel("Number :");
        lablenumber.setBounds(35,111,200,14);
        lablenumber.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablenumber.setForeground(Color.WHITE);
        panel.add(lablenumber);
        textFieldnumber = new JTextField();
        textFieldnumber.setBounds(271,111,150,20);
        panel.add(textFieldnumber);

        JLabel lableName = new JLabel("Name :");
        lableName.setBounds(35,151,200,14);
        lableName.setFont(new Font("Tahoma",Font.PLAIN,14));
        lableName.setForeground(Color.WHITE);
        panel.add(lableName);
        textFieldname = new JTextField();
        textFieldname.setBounds(271,151,150,20);
        panel.add(textFieldname);

        JLabel lablegender = new JLabel("Gender :");
        lablegender.setBounds(35,191,200,14);
        lablegender.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablegender.setForeground(Color.WHITE);
        panel.add(lablegender);
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3,45,48));
        r1.setBounds(271,191,80,12);
        panel.add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3,45,48));
        r2.setBounds(350,191,80,12);
        panel.add(r2);

        JLabel lablecountry = new JLabel("Country :");
        lablecountry.setBounds(35,231,200,14);
        lablecountry.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablecountry.setForeground(Color.WHITE);
        panel.add(lablecountry);
        textFieldcountry = new JTextField();
        textFieldcountry.setBounds(271,231,150,20);
        panel.add(textFieldcountry);

        JLabel lableroom = new JLabel("Allocated Room Number :");
        lableroom.setBounds(35,271,200,14);
        lableroom.setFont(new Font("Tahoma",Font.PLAIN,14));
        lableroom.setForeground(Color.WHITE);
        panel.add(lableroom);
        c1 = new Choice();
            try {
                con con = new con();
                ResultSet resultSet = con.statement.executeQuery("select * from room where availability = 'Availabile' ");
                while (resultSet.next()){
                    c1.add(resultSet.getString("roomnumber"));
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        c1.setBounds(271,271,150,20);
        c1.setFont(new Font("Tahoma", Font.BOLD,14));
        c1.setBackground(new Color(3,45,48));
        c1.setForeground(Color.WHITE);
        panel.add(c1);

        JLabel lablecis = new JLabel("Checked-In :");
        lablecis.setBounds(35,316,200,14);
        lablecis.setFont(new Font("Tahoma",Font.PLAIN,14));
        lablecis.setForeground(Color.WHITE);
        panel.add(lablecis);
        Date date = new Date();
        date1 =new JLabel(""+date);
        date1.setBounds(271,316,200,14);
        date1.setForeground(Color.WHITE);
        date1.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(date1);

        JLabel labledeposite = new JLabel("Deposite :");
        labledeposite.setBounds(35,359,200,14);
        labledeposite.setFont(new Font("Tahoma",Font.PLAIN,14));
        labledeposite.setForeground(Color.WHITE);
        panel.add(labledeposite);
        textFielddeposite = new JTextField();
        textFielddeposite.setBounds(271,359,150,20);
        panel.add(textFielddeposite);

        add = new JButton("Add");
        add.setBounds(100,430,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(260,430,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

            setLayout(null);
            setUndecorated(true);
            setLocation(500,150);
            setSize(850,550);
            setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            con con = new con();

            String radiobtn = null;
            if (r1.isSelected()){
                radiobtn = "Male";
            }else if (r2.isSelected()){
                radiobtn ="Female";
            }

            String doc = (String) comboBox.getSelectedItem();
            String number = textFieldnumber.getText();
            String name = textFieldname.getText();
            String gender = radiobtn;
            String country = textFieldcountry.getText();
            String room = c1.getSelectedItem();
            String date = date1.getText();
            String deposite = textFielddeposite.getText();

            try {
                String q = "insert into customer values('"+doc+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+date+"', '"+deposite+"' )";
                String q1 = "update room set availability = 'Occupied' where roomnumber ="+room;
                con.statement.executeUpdate(q);
                con.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new newcustomer();
    }
}
