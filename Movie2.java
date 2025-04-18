import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
class Movie2 extends JFrame implements ActionListener
{
    JButton details;
    JTextField n1,r1,r2,r3,r4;
    JLabel heading;
    Movie2()
    {
        details=new JButton("Show details");
        heading= new JLabel("Movie");
        n1=new JTextField(10);
        r1=new JTextField(10);
        r2=new JTextField(10);
        r3=new JTextField(10);
        r4=new JTextField(10);
        add(heading);
        add(details);
        add(n1);
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        setLayout(null);
        details.setBounds(200,40,150,175);  
        n1.setBounds(10,40,150,20);
        r1.setBounds(10,80,150,20);
        r2.setBounds(10,120,150,20);
        r3.setBounds(10,160,150,20);
        r4.setBounds(10,200,150,20);
        heading.setBounds(20,10,150,20);
        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        details.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object source=ae.getSource();
        int i;
        String str;
        str=n1.getText();
        try
         {
           int numrows=0;
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/indianmovies","root","password");
           Statement stm=con.createStatement();
           String qry="select * from movies order by year desc";
           ResultSet rs=stm.executeQuery(qry);
           while(rs.next())
           {
           if(source==details)
           {
              if((rs.getString(1)).equals(str)==true)
              {
                r1.setText("Director "+rs.getString(2));
                r2.setText("Year "+rs.getInt(3));
                r3.setText("Collection "+rs.getDouble(4));
                r4.setText("Language "+rs.getString(5));
              }
              numrows++;
           }
           }
           if(numrows>0)
           {
               System.out.println(numrows+"rows retrieved 1");
           }
           else
           {
               System.out.println("Data not found");
           }
      }
      catch(ClassNotFoundException e)
      {
          System.out.println(e);
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
    }
    public static void main(String args[])
    {
        Movie2 obj=new Movie2();
    }
}
