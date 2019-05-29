import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.Image;

class ChangePassword extends JPanel implements ActionListener
{
    ImageIcon bimg,cimg;
    JLabel username,oldpassword,newpassword,confirmpassword,background;
    JTextField user,opass,npass,cpass;
    JButton b1,b2;
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
    ChangePassword()
    {
        //background image
        bimg=new ImageIcon("18.jpeg");
        Image backimg=bimg.getImage();
        Image temp=backimg.getScaledInstance(900,800,Image.SCALE_SMOOTH);
        cimg=new ImageIcon(temp);
        background=new JLabel("",cimg,JLabel.CENTER);
        background.setBounds(0,0,900,800);

        Font f=new Font("Serif",Font.BOLD,20);

        username=new JLabel("Username");
        username.setBounds(150,100,200,30);
        username.setFont(f);
        username.setForeground(Color.WHITE);

        oldpassword=new JLabel("Old Password");
        oldpassword.setBounds(150,175,200,30);
        oldpassword.setFont(f);
        oldpassword.setForeground(Color.WHITE);

        newpassword=new JLabel("New Password");
        newpassword.setBounds(150,250,200,30);
        newpassword.setFont(f);
        newpassword.setForeground(Color.WHITE);

        confirmpassword=new JLabel("Confirm Password");
        confirmpassword.setBounds(150,325,200,30);
        confirmpassword.setFont(f);
        confirmpassword.setForeground(Color.WHITE);

        user=new JTextField();
        user.setBounds(450,100,200,30);
        user.setBackground(Color.WHITE);

        opass=new JTextField();
        opass.setBounds(450,175,200,30);
        opass.setBackground(Color.WHITE);

        npass=new JTextField();
        npass.setBounds(450,250,200,30);
        npass.setBackground(Color.WHITE);

        cpass=new JTextField();
        cpass.setBounds(450,325,200,30);
        cpass.setBackground(Color.WHITE);

        b1=new JButton("Change");
        b1.setBounds(180,425,100,30);

        b2=new JButton("Cancel");
        b2.setBounds(475,425,100,30);

        background.add(username);
        add(username);
        add(oldpassword);
        add(newpassword);
        add(confirmpassword);
        add(user);
        add(opass);
        add(npass);
        add(cpass);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(background);
        setBounds(0,0,600,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object ob=ae.getSource();
        if(ob==b1)
        {
            try{
                String username,password,newpass,confirmpass;
                username=user.getText();
                password=opass.getText();
                newpass=npass.getText();
                confirmpass=cpass.getText();
                rs=st.executeQuery("Select * from login where username='"+username+"'");
                if(rs.next())
                {
                    if(newpass.equals(confirmpass))
                    {
                        st.executeUpdate("Update login set password='"+newpass+"' where username='"+username+"' and password='"+password+"'");
                        JOptionPane.showMessageDialog(null,"Password Changed","Emulation",0);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Passwords do not match","Emulation",0);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Username or Password is incorrect","Emulation",0);
                }}
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"Emulation",0);
            }
        }
        if(ob==b2)
        {
            user.setText("");
            opass.setText("");
            npass.setText("");
            cpass.setText("");
        }
    }
}