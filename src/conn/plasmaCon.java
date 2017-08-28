package conn;


import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prital
 */
public class plasmaCon {
    
    public Connection con= null;
    public Statement st=null;
    public ResultSet rs=null;
    public ResultSetMetaData rsmd =null;
    public plasmaCon()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasma", "root", "");
        }
        catch(Exception e)
        {
        }
    }
    
}
