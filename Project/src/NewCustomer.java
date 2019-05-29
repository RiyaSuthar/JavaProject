import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.Image;

class NewCustomer extends JPanel implements ActionListener
{
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,background,l9,l10;
    ImageIcon bimg,cimg;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Checkbox cb1,cb2;
    CheckboxGroup cbg;
    JComboBox date,month,yr;
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
    NewCustomer()
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

        l1=new JLabel("Customer Id");
        l1.setBounds(100,20,200,30);
        l1.setFont(f);
        l1.setForeground(Color.WHITE);

        l2=new JLabel("Name");
        l2.setBounds(100,67,200,30);
        l2.setFont(f);
        l2.setForeground(Color.WHITE);

        l3=new JLabel("Address");
        l3.setBounds(100,114,200,30);
        l3.setFont(f);
        l3.setForeground(Color.WHITE);

        l4=new JLabel("E-Mail");
        l4.setBounds(100,161,200,30);
        l4.setFont(f);
        l4.setForeground(Color.WHITE);

        l5=new JLabel("Phone Number");
        l5.setBounds(100,208,200,30);
        l5.setFont(f);
        l5.setForeground(Color.WHITE);

        String []arr={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        date = new JComboBox(arr);
        date.setBounds(450,255,200,30);

        String []mon={"January","February","March","April","May","June","July","August","September","October","November","December"};
        month = new JComboBox(mon);
        month.setBounds(450,301,200,30);

        String []year={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
        yr = new JComboBox(year);
        yr.setBounds(450,349,200,30);


        l6=new JLabel("Purchase Date");
        l6.setBounds(100,255,200,30);
        l6.setFont(f);
        l6.setForeground(Color.WHITE);

        l7=new JLabel("Purchase Month");
        l7.setBounds(100,302,200,30);
        l7.setFont(f);
        l7.setForeground(Color.WHITE);

        l8=new JLabel("Purchase Year");
        l8.setBounds(100,349,200,30);
        l8.setFont(f);
        l8.setForeground(Color.WHITE);

        l9=new JLabel("Model Number");
        l9.setBounds(100,396,200,30);
        l9.setFont(f);
        l9.setForeground(Color.WHITE);

        l10=new JLabel("Gender");
        l10.setBounds(100,443,200,30);
        l10.setFont(f);
        l10.setForeground(Color.WHITE);



        t1=new JTextField();
        t1.setBounds(450,20,200,25);
        t1.setBackground(Color.WHITE);

        t2=new JTextField();
        t2.setBounds(450,67,200,25);
        t2.setBackground(Color.WHITE);

        t3=new JTextField();
        t3.setBounds(450,114,200,25);
        t3.setBackground(Color.WHITE);

        t4=new JTextField();
        t4.setBounds(450,161,200,25);
        t4.setBackground(Color.WHITE);

        t5=new JTextField();
        t5.setBounds(450,208,200,25);
        t5.setBackground(Color.WHITE);

        //t6=new JTextField();
        //t6.setBounds(350,349,200,25);
        //t6.setBackground(Color.WHITE);


        t7=new JTextField();
        t7.setBounds(450,396,200,25);
        t7.setBackground(Color.WHITE);

        t6=new JTextField();
        t6.setBounds(450,443,200,25);
        t6.setBackground(Color.WHITE);

       /* cbg = new CheckboxGroup();
        cb1=new Checkbox("Male",cbg,true);
        cb1.setBounds(350,443,150,25);
        cb1.setForeground(Color.WHITE);
        setOpaque(false);
        add(cb1);

        cb2=new Checkbox("Female",cbg,false);
        cb2.setBounds(510,443,150,25);
        cb2.setForeground(Color.WHITE);
        add(cb2);*/

        b1=new JButton("Submit");
        b1.setBounds(200,550,150,30);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(600,550,150,30);
        add(b2);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(l10);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);
        background.add(date);
        background.add(month);
        background.add(yr);
        add(background);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setBounds(0,0,600,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object ob=ae.getSource();

        if(ob==b1)
        {
            JOptionPane.showMessageDialog(null,"hi","Emulation",0);
            int customer_id;
            String name,add,email,phone,model_number,gender,d,m,y;
            customer_id=Integer.parseInt(t1.getText());
            name=t2.getText();
            add=t3.getText();
            email=t4.getText();
            phone=t5.getText();
            //date=t6.getText();
            d=(String)date.getSelectedItem();
            m=(String)month.getSelectedItem();
            y=(String)yr.getSelectedItem();
            model_number=t7.getText();
            gender=t6.getText();
            /*if(cb1.getState())
            {
                gender="Male";
            }
            else
            {
                gender="Female";
            }*/
            //d= (String)JComboBox.getSelectedItem();
            try{
                st.execute("insert into customer (customer_id,name,address,email,phone_number,purchase_date,purchase_month,purchase_year,model_number,gender) values ("+customer_id+",'"+name+"','"+add+"','"+email+"','"+phone+"','"+d+"','"+m+"','"+y+"','"+model_number+"','"+gender+"')");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"Emulation",0);
            }
        }
        if(ob==b2)
        {
            //JOptionPane.showMessageDialog(null,"hello","Emulation",0);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
        }
    }
}