import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

class MainFrame extends JFrame implements ActionListener
{
    ImageIcon bimg,cimg;
    JLabel background;
    JMenuBar mb;
    JMenu m1,m2,m3,m4,m5,m6;
    JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14;
    JPanel panel;
    JDesktopPane dp;
    Connection con;
    Statement st;
    ResultSet rs;
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile","root","");
            st=con.createStatement();
           // JOptionPane.showMessageDialog(null,"Connected","Emulation",0);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e,"Emulation",0);
        }
    }
    MainFrame()
    {
        //background image
        bimg=new ImageIcon("13.jpeg");
        Image backimg=bimg.getImage();
        Image temp=backimg.getScaledInstance(1900,1500,Image.SCALE_SMOOTH);
        cimg=new ImageIcon(temp);

        background=new JLabel("",cimg,JLabel.CENTER);
        background.setBounds(0,100,2000,1000);

        //menubar
        mb=new JMenuBar();
        mb.setBounds(0,0,2000,30);
        mb.setBackground(new Color(0,0,0,30));
        mb.setBorder(null);
        //mb.setForeground(Color.WHITE);


        //menus
        m1=new JMenu("Mobile");
        m1.setForeground(Color.WHITE);
        m1.setBackground(new Color(0,0,0,20));
        mb.add(m1);

        m2=new JMenu("Customer");
        m2.setForeground(Color.WHITE);
        m2.setBackground(new Color(0,0,0,20));
        mb.add(m2);

        m3=new JMenu("Login");
        m3.setForeground(Color.WHITE);
        m3.setBackground(new Color(0,0,0,20));
        mb.add(m3);

        m4=new JMenu("View");
        m4.setForeground(Color.WHITE);
        m4.setBackground(new Color(0,0,0,20));
        mb.add(m4);

        m5=new JMenu("Extras");
        m5.setForeground(Color.WHITE);
        m5.setBackground(new Color(0,0,0,20));
        mb.add(m5);

        //m6=new JMenu("View");
        //m6.setForeground(Color.WHITE);
        //m6.setBackground(new Color(0,0,0,20));
        //mb.add(m6);

        //menuitems
        mi1=new JMenuItem("New Mobile");

        //mi1.setBackground(new Color(0,0,0,10));
        m1.add(mi1);
        mi1.setOpaque(true);
        mi2=new JMenuItem("Update Mobile");
        //mi2.setBackground(new Color(0,0,0,10));
        m1.add(mi2);
        m1.setBackground(new Color(0,0,0,10));
        mi3=new JMenuItem("New Customer");
        m2.add(mi3);
        mi4=new JMenuItem("Modify Customer");
        m2.add(mi4);
        mi5=new JMenuItem("Delete Customer");
        m2.add(mi5);
        mi6=new JMenuItem("Logout");
        m3.add(mi6);
        mi7=new JMenuItem("Change Password");
        m3.add(mi7);
        mi8=new JMenuItem("Mobile Details");
        m4.add(mi8);
        mi9=new JMenuItem("Customer Details");
        m4.add(mi9);
        mi10=new JMenuItem("Sales");
        m4.add(mi10);
        mi11=new JMenuItem("Calculator");
        m5.add(mi11);
        mi12=new JMenuItem("Import");
        //m5.add(mi12);
        mi13=new JMenuItem("Export");
        //m5.add(mi13);
        //mi14=new JMenuItem("Mobile Details");
        //m6.add(mi14);


        //panel
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,2000,30);
        panel.setBackground(new Color(0,0,0,50));
        panel.add(mb);

        //desktop pane
        dp=new JDesktopPane();
        dp.setLayout(null);
        dp.setBounds(700,45,1100,800);
        dp.setBackground(new Color(0,0,0,0));
        background.add(dp);

        background.add(panel);
        add(background);
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);
        mi7.addActionListener(this);
        mi8.addActionListener(this);
        mi9.addActionListener(this);
        mi10.addActionListener(this);
        mi11.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(2000,1000);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object ob=ae.getSource();
        if(ob==mi1)
        {
            JInternalFrame jif = new JInternalFrame("New Mobile",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            jif.setBackground(new Color(0,0,0,20));
            jif.setBorder(null);
            jif.setVisible(true);
            jif.setOpaque(false);
            NewMobile nm= new NewMobile();
            nm.setLayout(null);
            nm.setBounds(0,0,1000,800);
            nm.setOpaque(true);
            jif.add(nm);
            //jif.addWindowStateListener(listener);
            dp.add(jif);
        }
        if(ob==mi2)
        {
            JInternalFrame jif =new JInternalFrame("Update Mobile",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            jif.setBackground(new Color(0,0,0,20));
            jif.setBorder(null);
            jif.setVisible(true);
            UpdateMobile up=new UpdateMobile();
            up.setLayout(null);
            up.setBounds(0,0,1000,800);
            jif.add(up);
            dp.add(jif);
        }
        if(ob==mi3)
        {
            JInternalFrame jif =new JInternalFrame("New Customer",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            jif.setBackground(new Color(0,0,0,20));
            jif.setBorder(null);
            jif.setVisible(true);
            NewCustomer nc=new NewCustomer();
            nc.setLayout(null);
            nc.setBounds(0,0,1000,800);
            jif.add(nc);
            dp.add(jif);

        }
        if(ob==mi4)
        {
            JInternalFrame jif =new JInternalFrame("Update Customer",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            jif.setBackground(new Color(0,0,0,20));
            jif.setBorder(null);
            jif.setVisible(true);
            UpdateCustomer uc=new UpdateCustomer();
            uc.setLayout(null);
            uc.setBounds(0,0,900,800);
            jif.add(uc);
            dp.add(jif);
        }
        if(ob==mi5)
        {
            JInternalFrame jif =new JInternalFrame("Delete Customer",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            jif.setBackground(new Color(0,0,0,20));
            jif.setBorder(null);
            jif.setVisible(true);
            DeleteCustomer dc=new DeleteCustomer();
            dc.setLayout(null);
            dc.setBounds(0,0,900,800);
            jif.add(dc);
            dp.add(jif);

        }
        if(ob==mi6)
        {
            Login1 a=new Login1();
            setVisible(false);
        }
        if(ob==mi7)
        {

            JInternalFrame jif =new JInternalFrame("Change Password",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            jif.setBackground(new Color(0,0,0,20));
            jif.setBorder(null);
            jif.setVisible(true);
            ChangePassword cp=new ChangePassword();
            cp.setLayout(null);
            cp.setBounds(0,0,900,800);
            jif.add(cp);
            dp.add(jif);
        }
        if(ob==mi8)
        {
            JLabel background;
            ImageIcon bimg,cimg;
            JInternalFrame jif =new JInternalFrame("Mobile Details",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            //jif.setBackground(new Color(0,0,0,20));
            bimg=new ImageIcon("18.jpeg");
            Image backimg=bimg.getImage();
            Image temp=backimg.getScaledInstance(900,800,Image.SCALE_SMOOTH);
            cimg=new ImageIcon(temp);
            background=new JLabel("",cimg,JLabel.CENTER);
            background.setBounds(0,0,900,800);

            jif.setBorder(null);
            try
            {
                rs=st.executeQuery("Select * from new_mobile");
                String d[][]=new String[200][10];
                int r=0;
                while(rs.next())
                {
                    d[r][0]=rs.getString("m_id");
                    d[r][1]=rs.getString("company_name");
                    d[r][2]=rs.getString("model_number");
                    d[r][3]=rs.getString("emei_number");
                    d[r][4]=rs.getString("amount");
                    d[r][5]=rs.getString("color");
                    d[r][6]=rs.getString("g4");
                    d[r][7]=rs.getString("dual_sim");
                    d[r][8]=rs.getString("dual_cam");
                    d[r][9]=rs.getString("fingerprint");
                    r++;
                }
                String h[]={"Mobile Id","Company name","Model number","Emei number","Amount","Color","4g","Dual sim","Dual camera","Fingerprint"};
                JTable tb=new JTable(d,h);
                JScrollPane sp=new JScrollPane(tb);
                sp.setBounds(20,30,860,700);
                background.add(sp);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"Emulation",0);
            }
            jif.add(background);
            jif.setVisible(true);

            //jif.add(md);
            dp.add(jif);
        }
        if(ob==mi9)
        {
            JLabel background;
            ImageIcon bimg,cimg;
            JInternalFrame jif =new JInternalFrame("Customer Details",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            //jif.setBackground(new Color(0,0,0,20));
            bimg=new ImageIcon("18.jpeg");
            Image backimg=bimg.getImage();
            Image temp=backimg.getScaledInstance(900,800,Image.SCALE_SMOOTH);
            cimg=new ImageIcon(temp);
            background=new JLabel("",cimg,JLabel.CENTER);
            background.setBounds(0,0,900,800);

            jif.setBorder(null);
            try
            {
                rs=st.executeQuery("Select * from customer");
                String d[][]=new String[200][10];
                int r=0;
                while(rs.next())
                {
                    d[r][0]=rs.getString("customer_id");
                    d[r][1]=rs.getString("name");
                    d[r][2]=rs.getString("address");
                    d[r][3]=rs.getString("email");
                    d[r][4]=rs.getString("phone_number");
                    d[r][5]=rs.getString("purchase_date");
                    d[r][6]=rs.getString("purchase_month");
                    d[r][7]=rs.getString("purchase_year");
                    d[r][8]=rs.getString("model_number");
                    d[r][9]=rs.getString("gender");
                    //d[r][8]=rs.getString("dual_cam")
                    r++;
                }
                String h[]={"Customer Id","Name","Address","Email","Phone Number","Purchase date","Purchase Month","Purchase Year","Model Number","Gender"};
                JTable tb=new JTable(d,h);
                JScrollPane sp=new JScrollPane(tb);
                sp.setBounds(20,30,860,700);
                background.add(sp);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"Emulation",0);
            }
            jif.add(background);
            jif.setVisible(true);

            //jif.add(md);
            dp.add(jif);
        }
        if(ob==mi10)
        {
            Font f=new Font("Serif",Font.BOLD,30);
            JLabel background;
            ImageIcon bimg,cimg;
            JInternalFrame jif =new JInternalFrame("Sale Details",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            //jif.setBackground(new Color(0,0,0,20));
            bimg=new ImageIcon("18.jpeg");
            Image backimg=bimg.getImage();
            Image temp=backimg.getScaledInstance(900,800,Image.SCALE_SMOOTH);
            cimg=new ImageIcon(temp);
            background=new JLabel("",cimg,JLabel.CENTER);
            background.setBounds(0,0,900,800);

            jif.setBorder(null);
            jif.add(background);
            jif.setVisible(true);

            String []options={"Month Wise Sale","Model Wise Sale"};
            String selectedValue=(String)JOptionPane.showInputDialog(null,"Select","option",JOptionPane.QUESTION_MESSAGE, null, options,options[ 0 ]);

            if(selectedValue == "Month Wise Sale")
            {
                String []mon={"January","February","March","April","May","June","July","August","September","October","November","December"};
                String selectedMonth=(String)JOptionPane.showInputDialog(null,"Enter month for which you want sales details","Emulation",JOptionPane.QUESTION_MESSAGE,null,mon,mon[0]);
                //JOptionPane.showMessageDialog(null,selectedMonth,"Emulation",0);

                try
                {
                    rs=st.executeQuery("Select * from customer where purchase_month='"+selectedMonth+"'");
                    String d[][]=new String[200][10];
                    int r=0;
                    while(rs.next())
                    {
                        d[r][0]=rs.getString("customer_id");
                        d[r][1]=rs.getString("name");
                        d[r][2]=rs.getString("address");
                        d[r][3]=rs.getString("email");
                        d[r][4]=rs.getString("phone_number");
                        d[r][5]=rs.getString("purchase_date");
                        d[r][6]=rs.getString("purchase_month");
                        d[r][7]=rs.getString("purchase_year");
                        d[r][8]=rs.getString("model_number");
                        d[r][9]=rs.getString("gender");
                        r++;
                    }
                    String h[]={"Customer Id","Name","Address","Email","Contact","Date of Purchase","Month of Purchase","Year of purchase","Model Number","Gender"};
                    JTable tb=new JTable(d,h);
                    JScrollPane sp=new JScrollPane(tb);
                    sp.setBounds( 20,30,860,700);
                    background.add(sp);

                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e,"Emulation",0);
                }

            }
            if(selectedValue == "Model Wise Sale")
            {
                String model=(String)JOptionPane.showInputDialog(null,"Enter model number you want to search ","Emulation",0);
                //JOptionPane.showMessageDialog(null,"Read","Emulation",0);
                try
                {
                    rs=st.executeQuery("Select * from new_mobile where model_number='"+model+"'");
                    String d[][]=new String[200][10];
                    int r=0;
                    while(rs.next())
                    {
                        d[r][0]=rs.getString("m_id");
                        d[r][1]=rs.getString("company_name");
                        d[r][2]=rs.getString("model_number");
                        d[r][3]=rs.getString("emei_number");
                        d[r][4]=rs.getString("amount");
                        d[r][5]=rs.getString("color");
                        d[r][6]=rs.getString("g4");
                        d[r][7]=rs.getString("dual_sim");
                        d[r][8]=rs.getString("dual_cam");
                        d[r][9]=rs.getString("fingerprint");
                        r++;
                    }
                    String h[]={"Mobile Id","Company name","Model number","Emei number","Amount","Color","4g","Dual sim","Dual camera","Fingerprint"};
                    JTable tb=new JTable(d,h);
                    JScrollPane sp=new JScrollPane(tb);
                    sp.setBounds(20,30,860,700);
                    background.add(sp);

                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e,"Emulation",0);
                }
            }
            //jif.add(md);
            dp.add(jif);
        }
        if(ob==mi11)
        {
           /* JInternalFrame jif =new JInternalFrame("Calculator",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            jif.setBackground(new Color(0,0,0,20));
            jif.setBorder(null);
            jif.setVisible(true);*/



            JInternalFrame jif =new JInternalFrame("Calculator",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            jif.setBackground(new Color(0,0,0,20));
            jif.setBorder(null);
            jif.setVisible(true);
            Calculator c=new Calculator();
            c.setLayout(null);
            c.setBounds(0,0,900,800);
            jif.add(c);
            dp.add(jif);













            /*Font f=new Font("Serif",Font.BOLD,30);
            JLabel background;
            ImageIcon bimg,cimg;
            JInternalFrame jif =new JInternalFrame("Calculator",true,true,true,true);
            jif.setLayout(null);
            jif.setBounds(0,0,900,800);
            //jif.setBackground(new Color(0,0,0,20));
            bimg=new ImageIcon("18.jpeg");
            Image backimg=bimg.getImage();
            Image temp=backimg.getScaledInstance(900,800,Image.SCALE_SMOOTH);
            cimg=new ImageIcon(temp);
            background=new JLabel("",cimg,JLabel.CENTER);
            background.setBounds(0,0,900,800);
            jif.setBorder(null);


            JLabel label1,label2,label3;
            JTextField t1,t2,t3;
            JButton add,div,mul,sub;

            label1=new JLabel("Enter first number");
            label1.setBounds(80,70,250,30);
            label1.setFont(f);
            label1.setForeground(Color.WHITE);

            label2=new JLabel("Enter second number");
            label2.setBounds(80,150,300,30);
            label2.setFont(f);
            label2.setForeground(Color.WHITE);

            label3=new JLabel("Result");
            label3.setBounds(250,400,300,30);
            label3.setFont(f);
            label3.setForeground(Color.WHITE);

            t1=new JTextField();
            t1.setBounds(400,70,200,30);

            t2=new JTextField();
            t2.setBounds(400,150,200,30);

            t3=new JTextField();
            t3.setBounds(400,400,200,30);

            add=new JButton("+");
            add.setBounds(170,250,150,30);

            sub=new JButton("-");
            sub.setBounds(400,250,150,30);

            mul=new JButton("X");
            mul.setBounds(170,320,150,30);

            div=new JButton("/");
            div.setBounds(400,320,150,30);

            background.add(add);
            background.add(sub);
            background.add(mul);
            background.add(div);
            background.add(t1);
            background.add(t2);
            background.add(t3);
            background.add(label2);
            background.add(label1);
            background.add(label3);
            jif.add(background);
            jif.setVisible(true);
            dp.add(jif);*/
        }
    }
    public static void main(String z[])
    {
        new MainFrame();
    }
}