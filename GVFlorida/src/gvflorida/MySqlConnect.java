/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gvflorida;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Jonelle
 */
public class MySqlConnect {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Connection query(String q, String username, String password){
        Connection con = null;
        Statement st = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/florida_bus?zeroDateTimeBehavior=convertToNull", username, password);
            st = con.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Query Executed");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return null;
    }
    
    private boolean validate_login(String username, String password){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/florida_bus?zeroDateTimeBehavior=convertToNull", username, password);
            return true;
        }
        catch(Exception e){
            return false;
            }       
    }
}