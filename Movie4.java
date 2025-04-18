import java.sql.*;
import java.util.*;
class Movie4
{ 
    public static void main(String args[])
    {
       try
       {
           int numrows=0,year;
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/indianmovies","root","password");
           Statement stm=con.createStatement();
           Scanner scan=new Scanner(System.in);
           System.out.println("Enter year before which the movie details have to be deleted: ");
           year=scan.nextInt();
           String qry1="delete from movies where year<"+year;
           String qry2="select * from movies order by year desc";
           stm.executeUpdate(qry1);
           ResultSet rs=stm.executeQuery(qry2);
           while(rs.next())
           {
              System.out.println(rs.getString(1)+"\t  "+rs.getString(2)+"\t "+rs.getInt(3)+"\t  "+rs.getDouble(4)+"\t  "+rs.getString(5));
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
}
