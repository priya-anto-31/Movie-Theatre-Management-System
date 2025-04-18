import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;
class Movie1 extends JFrame implements ActionListener
{
    JButton book, no;
    JTextField n1,n2;
    JLabel h,h1,h2,res;
    Movie1()
    {
        book=new JButton("Book Ticket");
        no=new JButton("No of Tickets");
        
        h= new JLabel("Movie Theatre Management System");
        h1= new JLabel("Movie Name:");
        h2= new JLabel("No of Tickets Available :");
        res= new JLabel("");
        
        n1=new JTextField(30);
        n2=new JTextField(30);
        add(h);
        add(h1);
        add(h2);
        add(res);
        add(book);
        add(no);
        add(n1);
        
        add(n2);
        setLayout(null);
        book.setBounds(10,150,120,25); 
        no.setBounds(150,150,120,25); 
        n1.setBounds(10,110,260,25);
        n2.setBounds(10,250,260,25);
        h.setBounds(40,15,1500,30);
        h.setFont(new Font("Arial", Font.ITALIC, 26));
        h1.setBounds(10,80,150,20);
        h1.setFont(new Font("Verdana", Font.PLAIN, 16));
        h2.setBounds(10,220,1500,20);
        h2.setFont(new Font("Verdana", Font.PLAIN, 16));
        res.setBounds(10,290,12000,25);
        res.setFont(new Font("Verdana", Font.PLAIN, 16));
        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#B4EEB4"));
        
        book.setBackground(Color.decode("#6897BB"));
        no.setBackground(Color.decode("#6897BB"));
       
        book.addActionListener(this);
        no.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {   
        Object source=ae.getSource();
        String s1;
        s1=n1.getText();

        try
        {
          int numrows=0,count;
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookticket","root","password");
          Statement stm=con.createStatement();
          String qry="select * from movies ";
          ResultSet rs=stm.executeQuery(qry);
          while(rs.next())
          {
            if(source==book)
                 {
                    
                    stm.executeUpdate("UPDATE movies SET Seats_Available = Seats_Available - 1 WHERE Movie_Name='"+s1+"'");
                   res.setText("Congratulations ! Your ticket was Booked :)");

                 }
            if(source==no)
                 {
			if(s1.equals(rs.getString(2)))
			{
			    n2.setText(""+rs.getInt(5));
			     
                 }
                
             }
             numrows++;
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
        Movie1 obj=new Movie1();
    }
}
