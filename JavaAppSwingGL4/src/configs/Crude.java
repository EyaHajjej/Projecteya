/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package configs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OMRANI
 */
public class Crude {
    MyConnexion mc = MyConnexion.getInstance();

    public boolean exeCreate(String sql){
        try {
            Statement statement = mc.getConnection().createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean exeUpdate(String sql){
        try {
            Statement statement = mc.getConnection().createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Crude.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean exeDelete(String sql){
        try {
            Statement statement = mc.getConnection().createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Crude.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ResultSet exeRead(String sql){
        try {
            Statement statement = mc.getConnection().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Crude.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
