import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.sql.*;

class Login1 extends JFrame implements ActionListener
{
    JButton b1,b2;
    JTextField usname;
    JPasswordField pass;
    Connection con;
    Statement st;
    ResultSet rs;
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile","root","");
            st=con.createStatement();
            //JOptionPane.showMessageDialog(null,"Connected","Emulation",0);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e,"Emulation",0);
        }
    }
    Login1()
    {
        //Font 
        Font f=new Font("Serif",Font.BOLD,30);


        //header
        JPanel heading;

        heading=new JPanel();
        heading.setBackground(new Color(0,0,0,50));
        heading.setBounds(420,150,1000,600);
        heading.setLayout(null);

        //login
        JLabel username,password;
        //username
        username=new JLabel("Username");
        username.setBounds(600,100,200,40);
        username.setFont(f);
        username.setForeground(Color.WHITE);
        heading.add(username);
        //password
        password=new JLabel("Password");
        password.setBounds(600,250,200,40);
        password.setFont(f);
        password.setForeground(Color.WHITE);
        heading.add(password);
        //Textfields

        usname=new JTextField();
        usname.setBounds(600,160,250,40);
        //usname.setOpaque(false);
        //usname.setBackground(new Color(202,225,255,60));
        usname.setForeground(Color.BLACK);
        heading.add(usname);


        pass=new JPasswordField();
        pass.setBounds(600,310,250,40);
        //
        // pass.setOpaque(false);
        pass.setForeground(Color.black);
        heading.add(pass);

        //buttons

        b1=new JButton("Login");
        b1.setBounds(570,450,100,30);
        //b1.setOpaque(false);
        //b1.setContentAreaFilled(false);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        b1.addActionListener(this);
        heading.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(770,450,100,30);
        //b2.setOpaque(false);
       // b2.setContentAreaFilled(false);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        b2.addActionListener(this);
        heading.add(b2);

        //image
        ImageIcon ii=new ImageIcon("11.png");
        JLabel label;
        label=new JLabel();
        Image newimg=ii.getImage();
        Image tempt=newimg.getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ii=new ImageIcon(tempt);
        label.setBounds(80,50,500,500);
        //label.setBackground(Color.BLACK);
        //label.setForeground(Color.WHITE);
        label.setIcon(ii);
        heading.add(label);

        //frame
        setSize(2000,1000);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //background
        ImageIcon backgroundimage = new ImageIcon("8.jpg");
        Image img =backgroundimage.getImage();
        Image temp_img=img.getScaledInstance(2000,1100,Image.SCALE_SMOOTH);
        backgroundimage=new ImageIcon(temp_img);

        JLabel background =new JLabel("",backgroundimage,JLabel.CENTER);
        background.setBounds(0,0,2000,1100);
        background.add(heading);
        //background.add(label);
        add(background);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object ob=ae.getSource();
        if(ob==b1)
        {

            try
            {
                String usn,pas;
                char[] p;
                usn=usname.getText();
                //p=pass.getPassword();
                //pas=p.toString();
                pas=new String(pass.getPassword());
               // JOptionPane.showMessageDialog(null,pas,"traingin",0);
                rs=st.executeQuery("Select * from login where username='"+usn+"' and password='"+pas+"' ");
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Login Confirmed","Emulation",0);
                    MainFrame A=new MainFrame();
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Username or Password is incorrect","Emulation",0);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"Emulation",0);
            }


        }
        if(ob==b2)
        {
            JOptionPane.showMessageDialog(null,"Cancel","emulation",0);
            usname.setText("");
            pass.setText("");
        }
    }
    public static void main(String z[])
    {
        new Login1();
    }
}