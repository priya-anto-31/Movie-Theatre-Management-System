import java.sql.*;
import java.util.*;
class Movie3
{ 
    public static void main(String args[])
    {
       try
       {
           int numrows=0,search;
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/indianmovies","root","password");
           Statement stm=con.createStatement();
           String qry="select * from movies order by year desc";
           ResultSet rs=stm.executeQuery(qry);
           Scanner scan=new Scanner(System.in);
           System.out.println("Enter year to search: ");
           search=scan.nextInt();
           while(rs.next())
           {
              if(rs.getInt(3)==search)
              {
                 System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getDouble(4)+"\t"+rs.getString(5));
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
}
