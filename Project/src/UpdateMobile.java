import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Image;

class UpdateMobile extends JPanel implements ActionListener
{
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6,l7,background;
    ImageIcon bimg,cimg;
    JTextField t1,t2,t3,t4,t5,t6;
    JCheckBox cb1,cb2,cb3,cb4;
    Checkbox cb5,cb6;
    //CheckboxGroup cbg;
    CheckboxGroup cb;
    Connection con;
    Statement st;
    ResultSet rs;
    int id;
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
    UpdateMobile()
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
        //cb4.setBackground(new Color(0,0,0,0));ja
        cb4.setOpaque(false);
        cb4.setForeground(Color.WHITE);
        add(cb4);

      /*  cb = new CheckboxGroup();
        cb5=new Checkbox("White",cb,true);
        cb5.setBounds(450,420,150,25);
        cb5.setForeground(Color.WHITE);
        add(cb5);

        cb6=new Checkbox("Black",cb,false);
        cb6.setBounds(620,420,150,25);
        cb6.setForeground(Color.WHITE);
        add(cb6);*/
        t6=new JTextField();
        t6.setBounds(450,420,200,25);
        t6.setBackground(Color.WHITE);

        b1=new JButton("Update");
        b1.setBounds(120,550,130,30);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(370,550,130,30);
        add(b2);

        b3=new JButton("Search");
        b3.setBounds(600,550,130,30);
        add(b3);

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
        add(t6);
        add(background);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        setBounds(0,0,600,600);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object ob=ae.getSource();
        if(ob==b1)
        {
            try{
                JOptionPane.showMessageDialog(null,"Update","Emulation",0);
                String dual_sim,dual_cam,fingerprint,color,g4;
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
                color=t6.getText();
                st.executeUpdate("Update new_mobile set m_id="+Integer.parseInt(t1.getText())+",company_name='"+t2.getText()+"',model_number='"+t3.getText()+"',emei_number='"+t4.getText()+"',amount="+Integer.parseInt(t5.getText())+" ,color='"+color+"',g4='"+g4+"',dual_sim='"+dual_sim+"',dual_cam='"+dual_cam+"',fingerprint='"+fingerprint+"' where m_id="+id+"");
                JOptionPane.showMessageDialog(null,"Updated","Emulation",0);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"Emulation",0);
            }
        }
        if(ob==b2)
        {
            JOptionPane.showMessageDialog(null,"Cancel","Emulation",0);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            cb1.setSelected(false);
            cb2.setSelected(false);
            cb3.setSelected(false);
            cb4.setSelected(false);
        }
        if(ob==b3)
        {
            try
            {

                //JOptionPane.showMessageDialog(null,"Search","Emulation",0);
                id=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the mobile id you want to search","Emulation",0));
                rs=st.executeQuery("Select * from new_mobile where m_id="+id+" ");
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"present","Emulation",0);
                    t1.setText(rs.getString("m_id"));
                    t2.setText(rs.getString("company_name"));
                    t3.setText(rs.getString("model_number"));
                    t4.setText(rs.getString("emei_number"));
                    t5.setText(rs.getString("amount"));
                    t6.setText(rs.getString("color"));
					/*if(rs.getString("White").equals("Yes"))
					{
						cb5.setSelected(true);
						cb6.setSelected(false);
					}
					else
					{
						cb5.setSelected(false);
						cb6.setSelected(true);
					}*/
                    if(rs.getString("g4").equals("Yes"))
                    {
                        cb2.setSelected(true);
                    }
                    else
                    {
                        cb2.setSelected(false);
                    }
                    if(rs.getString("dual_sim").equals("Yes"))
                    {
                        cb1.setSelected(true);
                    }
                    else
                    {
                        cb1.setSelected(false);
                    }
                    if(rs.getString("dual_cam").equals("Yes"))
                    {
                        cb3.setSelected(true);
                    }
                    else
                    {
                        cb3.setSelected(false);
                    }
                    if(rs.getString("fingerprint").equals("Yes"))
                    {
                        cb4.setSelected(true);
                    }
                    else
                    {
                        cb4.setSelected(false);
                    }

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
    }
}