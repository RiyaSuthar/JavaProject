import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.*;
import java.sql.*;
import java.awt.Image;

class NewMobile extends JPanel implements ActionListener
{
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7,background;
    ImageIcon bimg,cimg;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JCheckBox cb1,cb2,cb3,cb4;
    //Checkbox cb5,cb6;
   // CheckboxGroup cbg;
    Connection con;
    Statement st;
    ResultSet rs;
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile","root","");
            st=con.createStatement();
            //JOptionPane.showMessageDialog(null,"Connected","Emulation",0);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e,"Emulation",0);
        }
    }
    NewMobile()
    {
        //background image
        bimg=new ImageIcon("18.jpeg");
        Image backimg=bimg.getImage();
        Image temp=backimg.getScaledInstance(900,800,Image.SCALE_SMOOTH);
        cimg=new ImageIcon(temp);
        background=new JLabel("",cimg,JLabel.CENTER);
        background.setBounds(0,0,900,800);


        Font f=new Font("Serif",Font.BOLD,20);
        setBackground(new Color(0,0,0,20));
        setLayout(null);
        setOpaque(false);

        l1=new JLabel("Mobile Id");
        l1.setBounds(100,40,100,30);
        l1.setFont(f);
        l1.setForeground(Color.WHITE);

        l2=new JLabel("Company Name");
        l2.setBounds(100,100,200,30);
        l2.setFont(f);
        l2.setForeground(Color.WHITE);

        l3=new JLabel("Model Number");
        l3.setBounds(100,160,200,30);
        l3.setFont(f);
        l3.setForeground(Color.WHITE);

        l4=new JLabel("Imei Number");
        l4.setBounds(100,220,200,30);
        l4.setFont(f);
        l4.setForeground(Color.WHITE);

        l5=new JLabel("Amount");
        l5.setBounds(100,280,200,30);
        l5.setFont(f);
        l5.setForeground(Color.WHITE);

        l6=new JLabel("Feartures");
        l6.setBounds(100,340,200,30);
        l6.setFont(f);
        l6.setForeground(Color.WHITE);

        l7=new JLabel("Color");
        l7.setBounds(100,420,200,30);
        l7.setFont(f);
        l7.setForeground(Color.WHITE);

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

        cb1=new JCheckBox("Dual Sim");
        cb1.setBounds(450,340,150,25);
        //cb1.setFont(f);
        //cb1.setBackground(new Color(0,0,0,0));
        cb1.setOpaque(false);
        cb1.setForeground(Color.WHITE);
        add(cb1);

        cb2=new JCheckBox("4G");
        cb2.setBounds(620,340,150,25);
        //cb2.setBackground(new Color(0,0,0,0));
        cb2.setOpaque(false);
        cb2.setForeground(Color.WHITE);
        add(cb2);

        cb3=new JCheckBox("Dual Camera");
        cb3.setBounds(450,370,150,25);
        //cb3.setBackground(new Color(0,0,0,0));
        cb3.setOpaque(false);
        cb3.setForeground(Color.WHITE);
        add(cb3);

        cb4=new JCheckBox("Fingerprint Sensor");
        cb4.setBounds(620,370,150,25);
        //cb4.setBackground(new Color(0,0,0,0));
        cb4.setOpaque(false);
        cb4.setForeground(Color.WHITE);
        add(cb4);

        /*cbg = new CheckboxGroup();
        cb5=new Checkbox("White",cbg,true);
        cb5.setBounds(450,420,150,25);
        cb5.setForeground(Color.WHITE);
        //cb5.setOpaque(false);
        add(cb5);

        cb6=new Checkbox("Black",cbg,false);
        cb6.setBounds(620,420,150,25);
        cb6.setForeground(Color.WHITE);
        //cb6.setOpaque(false);
        add(cb6);*/
        t7=new JTextField();
        t7.setBounds(450,420,200,25);
        t7.setBackground(Color.WHITE);
        //t3=new JTextField();
        //t3.setBounds(450,160,200,25);
        //t3.setBackground(Color.WHITE);

        b1=new JButton("Submit");
        b1.setBounds(200,550,150,30);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(550,550,150,30);
        add(b2);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t7);
        add(background);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setBounds(0,0,800,900);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object ob=ae.getSource();
        if(ob==b1)
        {
            int a1,a2;
            String s1,s2,s3,dual_sim,dual_cam,fingerprint,color,g4;
            a1=Integer.parseInt(t1.getText());
            s1=t2.getText();
            s2=t3.getText();
            s3=t4.getText();
            color=t7.getText();
            a2=Integer.parseInt(t5.getText());
            if(cb1.isSelected())
            {
                dual_sim="Yes";
            }
            else
            {
                dual_sim="No";
            }
            if(cb2.isSelected())
            {
                g4="Yes";
            }
            else
            {
                g4="No";
            }
            if(cb3.isSelected())
            {
                dual_cam="Yes";
            }
            else
            {
                dual_cam="No";
            }
            if(cb4.isSelected())
            {
                fingerprint="Yes";
            }
            else
            {
                fingerprint="No";
            }
           /* if(cb5.getState())
            {
                color="White";
            }
            else
            {
                color="Black";
            }*/
            try
            {
                st.execute("insert into new_mobile (m_id,company_name,model_number,emei_number,amount,color,g4,dual_sim,dual_cam,fingerprint) values ("+a1+", '"+s1+"','"+s2+"','"+s3+"',"+a2+",'"+color+"','"+g4+"','"+dual_sim+"','"+dual_cam+"','"+fingerprint+"')");
                //JOptionPane.showMessageDialog(null,"Saved","Emulation",0);
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t7.setText("");
                cb1.setSelected(false);
                cb2.setSelected(false);
                cb3.setSelected(false);
                cb4.setSelected(false);
                JOptionPane.showMessageDialog(null,"Saved","Emulation",0);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"Emulation",0);
            }

        }
        if(ob==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t7.setText("");
            cb1.setSelected(false);
            cb2.setSelected(false);
            cb3.setSelected(false);
            cb4.setSelected(false);

        }
    }

}