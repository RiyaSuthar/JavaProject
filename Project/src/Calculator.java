import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;

public class Calculator extends JPanel implements ActionListener {
    ImageIcon bimg,cimg;
    JLabel background;
    JDesktopPane dp;
    JLabel label1,label2,label3;
    JTextField t1,t2,t3;
    JButton add,div,mul,sub,clear;
    Calculator()
    {
        bimg=new ImageIcon("18.jpeg");
        Image backimg=bimg.getImage();
        Image temp=backimg.getScaledInstance(900,800,Image.SCALE_SMOOTH);
        cimg=new ImageIcon(temp);
        background=new JLabel("",cimg,JLabel.CENTER);
        background.setBounds(0,0,900,800);

        Font f=new Font("Serif",Font.BOLD,20);
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

        clear=new JButton("Clear");
        clear.setBounds(400,460,150,30);

        add(label1);
        add(label2);
        add(label3);
        add(t1);
        add(t2);
        add(t3);
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(clear);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clear.addActionListener(this);
        add(background);
        setBounds(0,0,600,600);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        Object ob=e.getSource();
        float num1,num2;
        float result;
        num1=Integer.parseInt(t1.getText());
        num2=Integer.parseInt(t2.getText());
        if(ob==add)
        {
            result=num1+num2;
            t3.setText(Double.toString(result));
        }
        if(ob==sub)
        {
            result=num1-num2;
            t3.setText(Double.toString(result));
        }
        if(ob==mul)
        {
            result=num1*num2;
            t3.setText(Double.toString(result));
        }
        if(ob==div)
        {
            result=num1/num2;
            t3.setText(Double.toString(result));
        }
        if(ob==clear)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
    }

}
