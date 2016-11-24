package tollcollect;


import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSource
{
  Connection      connection = null;
  BasicDataSource bdSource   = new BasicDataSource();
  private static int MAX_ACTIVE= 10;

  public DataSource()
  {
    bdSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    bdSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
    bdSource.setUsername("sys as sysdba");
    bdSource.setPassword("MANAGER");
    bdSource.setMaxActive(MAX_ACTIVE);
  }

  public Connection createConnection()
  {
    Connection con = null;
    try
    {
      if( connection != null )
      {
        System.out.println("Cant create a New Connection");
      }
      else
      {
        con = bdSource.getConnection();
      }
    }
    catch( Exception e )
    {
      System.out.println("Error Occured " + e.toString());
    }
    return con;
  }
}

