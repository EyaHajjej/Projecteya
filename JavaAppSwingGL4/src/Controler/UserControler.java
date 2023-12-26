/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

/**
 *
 * @author omrani
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 

 

import Model.User;
import java.sql.*;
import java.util.*;
import configs.Crude;
import javax.swing.*;


/**
 *
 * @author OMRANI
 */
public class UserControler {
 private Crude crude = new Crude();
 
    public boolean insert(User e) {
        //Check for unique login/pwd
        
        String sql =
                "INSERT INTO user(firstname, lastname, login, pwd) VALUES ('"
                + e.getFirstname()+ "','"+e.getLastname()+ "','" + e.getLogin() + "','" + e.getPwd()+ "')";
       System.out.println(sql);
        return crude.exeCreate(sql); 
    }

    public boolean update(User a, Integer id) {
        String sql =
                "UPDATE user SET firstname='" + a.getFirstname() + "', lastname='"
                + a.getLastname() + "' , login= '" + a.getLogin() + "', pwd = '" + a.getPwd() + "' WHERE id=" + id;
        return crude.exeUpdate(sql);    
    }

    public boolean delete(User e) {
        String sql = "DELETE FROM user WHERE id=" + e.getId();
        return crude.exeDelete(sql);    
    }

    public List<User> getAll() {
    try {
            String sql = "SELECT * FROM user";
            ResultSet rs = crude.exeRead(sql);
            List<User> liste = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setFirstname(rs.getString(2));
                user.setLastname(rs.getString(3));
                user.setLogin(rs.getString(4));
                user.setPwd(rs.getString(5));
                
                liste.add(user);
            }
            return liste;
        } catch (SQLException ex) {
                System.err.println(ex.getMessage());
             JOptionPane.showMessageDialog(null, "Erreur AdministratorDAO ", "Erreur ", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    public User findByID(int id) {
        try {
            String sql = "SELECT * FROM administrator WHERE id = "+id;
            ResultSet rs = crude.exeRead(sql);
            User admin = new User();
            while (rs.next()) {
                admin.setId(rs.getInt(1));
                admin.setFirstname(rs.getString(2));
                admin.setLastname(rs.getString(3));
                admin.setLogin(rs.getString(4));
                admin.setPwd(rs.getString(5));
            }
            return admin;
        } catch (SQLException ex) {
              System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erreur AdministratorDAO ", "Erreur ", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public User findByLoginPwd(String login, String pwd){
        User user = null;
        try {
            String sql = "SELECT * FROM user WHERE login = '"+login+"' AND pwd = '"+pwd+"'";
            ResultSet rs = crude.exeRead(sql);
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt(1));
                    user.setFirstname(rs.getString(2));
                    user.setLastname(rs.getString(3));
                    user.setLogin(rs.getString(4));
                    user.setPwd(rs.getString(5));
                }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erreur AdministratorDAO ", "Erreur ", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return user;
    }

}
