import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

class DeleteCustomer extends JPanel implements ActionListener
{
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,background;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    Checkbox cb1,cb2;
    CheckboxGroup cbg;
    ImageIcon bimg,cimg;
    int id;
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
    DeleteCustomer()
    {
        bimg=new ImageIcon("18.jpeg");
        Image backimg=bimg.getImage();
        Image temp=backimg.getScaledInstance(900,800,Image.SCALE_SMOOTH);
        cimg=new ImageIcon(temp);
        background=new JLabel("",cimg,JLabel.CENTER);
        background.setBounds(0,0,900,800);

        Font f=new Font("Serif",Font.BOLD,20);
        setBackground(new Color(0,0,0,20));
        setLayout(null);
        l1=new JLabel("Customer Id");
        l1.setBounds(100,40,200,30);
        l1.setFont(f);
        l1.setForeground(Color.WHITE);

        l2=new JLabel("Name");
        l2.setBounds(100,100,200,30);
        l2.setFont(f);
        l2.setForeground(Color.WHITE);

        l3=new JLabel("Address");
        l3.setBounds(100,160,200,30);
        l3.setFont(f);
        l3.setForeground(Color.WHITE);

        l4=new JLabel("E-Mail");
        l4.setBounds(100,220,200,30);
        l4.setFont(f);
        l4.setForeground(Color.WHITE);

        l5=new JLabel("Phone Number");
        l5.setBounds(100,280,200,30);
        l5.setFont(f);
        l5.setForeground(Color.WHITE);

        l6=new JLabel("Purchase Date");
        l6.setBounds(100,340,200,30);
        l6.setFont(f);
        l6.setForeground(Color.WHITE);

        l7=new JLabel("Model Number");
        l7.setBounds(100,400,200,30);
        l7.setFont(f);
        l7.setForeground(Color.WHITE);

        l8=new JLabel("Gender");
        l8.setBounds(100,460,200,30);
        l8.setFont(f);
        l8.setForeground(Color.WHITE);

        t1=new JTextField();
        t1.setBounds(450,40,200,25);
        t1.setBackground(Color.WHITE);

        t2=new JTextField();
        t2.setBounds(450,100,200,25);
        t2.setBackground(Color.WHITE);

        t3=new JTextField();
        t3.setBounds(450,160,200,25);
        t3.setBackground(Color.WHITE);

        t4=new JTextField();
        t4.setBounds(450,220,200,25);
        t4.setBackground(Color.WHITE);

        t5=new JTextField();
        t5.setBounds(450,280,200,25);
        t5.setBackground(Color.WHITE);

        t6=new JTextField();
        t6.setBounds(450,340,200,25);
        t6.setBackground(Color.WHITE);

        t7=new JTextField();
        t7.setBounds(450,400,200,25);
        t7.setBackground(Color.WHITE);

        t8=new JTextField();
        t8.setBounds(450,460,200,25);
        t8.setBackground(Color.WHITE);

        /*cbg = new CheckboxGroup();
        cb1=new Checkbox("Male",cbg,true);
        cb1.setBounds(450,460,150,25);
        cb1.setForeground(Color.WHITE);
        add(cb1);

        cb2=new Checkbox("Female",cbg,false);
        cb2.setBounds(510,460,150,25);
        cb2.setForeground(Color.WHITE);
        add(cb2);*/

        b1=new JButton("Search");
        b1.setBounds(120,550,130,30);
        add(b1);

        b2=new JButton("Delete");
        b2.setBounds(310,550,130,30);
        add(b2);

        b3=new JButton("Cancel");
        b3.setBounds(500,550,130,30);
        add(b3);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);
        add(t8);
        add(background);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        setBounds(0,0,600,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object ob=ae.getSource();
        if(ob==b1)
        {
            try{
                id=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter customer id you want to Delete","Emulation",0));
                rs=st.executeQuery("Select * from customer where customer_id="+id+"");
                if(rs.next())
                {
                    t1.setText(rs.getString("customer_id"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("address"));
                    t4.setText(rs.getString("email"));
                    t5.setText(rs.getString("phone_number"));
                    t6.setText(rs.getString("purchase_date"));
                    t7.setText(rs.getString("model_number"));
                    t8.setText(rs.getString("gender"));
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Record not found","Emulation",0);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"Emulation",0);
            }

        }
        if(ob==b2)
        {
            try{
                int yy=JOptionPane.showConfirmDialog(null,"Do you want to delete this customer?","Emulation",0);
                if(yy==0)
                {
                    st.executeUpdate("delete from customer where customer_id=" +id+" ");
                    JOptionPane.showMessageDialog(null,"Record Deleted","Emulation",0);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"Emulation",0);
            }
        }
        if(ob==b3)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
        }
    }
}