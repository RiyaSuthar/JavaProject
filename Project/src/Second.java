import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Second implements ActionListener
{
    Frame f;
    Label l1,l2,l3,l4;
    TextField t1,t2,t3,t4;
    Button b1,b2,b3,b4,b5,b6,b7;
    Connection con;
    Statement st;
    ResultSet rs;
    int id;
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Emulation","root","");
            st=con.createStatement();
            System.out.println("Connected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    Second()
    {
        f=new Frame("New Database");
        f.setLayout(null);
        Color c=new Color(122, 150, 60);
        f.setBackground(c);
        l1=new Label("Enter Employee name");
        l1.setBounds(40,40,200,20);
        f.add(l1);
        l2=new Label("Enter Employee Designation");
        l2.setBounds(40,80,200,20);
        f.add(l2);
        l3=new Label("Enter Employee Department");
        l3.setBounds(40,120,200,20);
        f.add(l3);
        l4=new Label("Enter Employee Salary");
        l4.setBounds(40,160,200,20);
        f.add(l4);
        t1=new TextField();
        t1.setBounds(260,40,100,20);
        f.add(t1);
        t1.setEnabled(false);
        t2=new TextField();
        t2.setBounds(260,80,100,20);
        f.add(t2);
        t2.setEnabled(false);
        t3=new TextField();
        t3.setBounds(260,120,100,20);
        f.add(t3);
        t3.setEnabled(false);
        t4=new TextField();
        t4.setBounds(260,160,100,20);
        f.add(t4);
        t4.setEnabled(false);
        b1=new Button("ADD");
        b1.setBounds(800,40,100,20);
        f.add(b1);
        b2=new Button("CLEAR");
        b2.setBounds(800,80,100,20);
        f.add(b2);
        b3=new Button("END");
        b3.setBounds(800,120,100,20);
        f.add(b3);
        b4=new Button("SHOW ALL");
        b4.setBounds(800,160,100,20);
        f.add(b4);
        b5=new Button("SEARCH");
        b5.setBounds(800,200,100,20);
        f.add(b5);
        b6=new Button("FIND/DELETE");
        b6.setBounds(800,240,100,20);
        f.add(b6);
        b7=new Button("FIND");
        b7.setBounds(800,280,100,20);
        f.add(b7);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        f.setVisible(true);
        f.setSize(1000,1000);

    }
    public void actionPerformed(ActionEvent ae)
    {
        Object ob=ae.getSource();
        if(ob==b1)
        {
            if(b1.getLabel().equals("ADD"))
            {
                t1.setEnabled(true);
                t2.setEnabled(true);
                t3.setEnabled(true);
                t4.setEnabled(true);
                t1.requestFocus();
                b1.setLabel("SAVE");

            }
            else
            {
                String a1,a2,a3;
                int a4;
                a1=t1.getText();
                a2=t2.getText();
                a3=t3.getText();
                a4=Integer.parseInt(t4.getText());
                try{
                    st.execute("insert into Employee (e_name,e_desig,e_depart,e_sal) values(' "+a1+" ',' "+a2+" ',' "+a3+" ',"+a4+" )");
                    JOptionPane.showMessageDialog(null,"Saved","Emulation",0);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t1.setEnabled(false);
                    t2.setEnabled(false);
                    t3.setEnabled(false);
                    t4.setEnabled(false);
                    b1.setLabel("ADD");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        if(ob==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }
        if(ob==b3)
        {
            System.exit(0);
        }
        if(ob==b4)
        {
            try
            {
                rs=st.executeQuery("Select * from employee");
                String d[][]=new String[20][5];
                int r=0;
                while(rs.next())
                {
                    d[r][0]=rs.getString("e_id");
                    d[r][1]=rs.getString("e_name");
                    d[r][2]=rs.getString("e_desig");
                    d[r][3]=rs.getString("e_depart");
                    d[r][4]=rs.getString("e_sal");
                    r++;
                }
                String h[]={"Employee id","Employee name","Employee designation","Employee department","Employee Salary"};
                JTable tb=new JTable(d,h);
                JScrollPane sp=new JScrollPane(tb);
                sp.setBounds(40,200,650,200);
                f.add(sp);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if(ob==b5)
        {
            try
            {
                id=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter id to you want to search","Emulation",0));
                rs=st.executeQuery("Select * from employee where e_id=" +id+ " ");
                if(rs.next())
                {
                    String z="Record found";
                    z+="\nName is : "+rs.getString("e_name");
                    z+="\nDesignation is : "+rs.getString("e_desig");
                    z+="\nDepartment is : "+rs.getString("e_depart");
                    z+="\nSalary is : "+rs.getString("e_sal");
                    JOptionPane.showMessageDialog(null,z,"Emulation",0);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Not Found","Emulation",0);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if(ob==b6)
        {
            try
            {
                id=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter id to you want to search","Emulation",0));
                rs=st.executeQuery("Select * from employee where e_id=" +id+ " ");
                if(rs.next())
                {
                    String z="Record found";
                    z+="\nName is : "+rs.getString("e_name");
                    z+="\nDesignation is : "+rs.getString("e_desig");
                    z+="\nDepartment is : "+rs.getString("e_depart");
                    z+="\nSalary is : "+rs.getString("e_sal");
                    z+="\nDo you want to delete?";
                    int yy=JOptionPane.showConfirmDialog(null,z,"Emulation",0);
                    if(yy==0)
                    {
                        st.executeUpdate("delete from employee where e_id=" +id+" ");
                        JOptionPane.showMessageDialog(null,"Record Deleted","Emulation",0);
                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Record Not Found","Emulation",0);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if(ob==b7)
        {
            if(b7.getLabel().equals("FIND"))
            {
                try
                {
                    id=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter id you want to update","Emulation",0));
                    rs=st.executeQuery("Select * from employee where e_id=" +id+ " ");
                    if(rs.next())
                    {
                        t1.setText(rs.getString("e_name"));
                        t2.setText(rs.getString("e_desig"));
                        t3.setText(rs.getString("e_depart"));
                        t4.setText(rs.getString("e_sal"));
                        t1.setEnabled(true);
                        t2.setEnabled(true);
                        t3.setEnabled(true);
                        t4.setEnabled(true);
                        b7.setLabel("UPDATE");
                        t1.requestFocus();
                        JOptionPane.showMessageDialog(null,"Change the text you want to update and press UPDATE","Emulation",0);
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
            else
            {
                try{
                    st.executeUpdate("Update Employee  set e_name='"+t1.getText()+"',e_desig='"+t2.getText()+"',e_depart='"+t3.getText()+"',e_sal="+Integer.parseInt(t4.getText())+"  where e_id=" +id+ " ");
                    JOptionPane.showMessageDialog(null,"Record Updated","Emulation",0);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    b7.setLabel("FIND");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e,"Emulation",0);
                }

            }
        }
    }
    public static void main(String z[])
    {
        Second A=new Second();
    }

}