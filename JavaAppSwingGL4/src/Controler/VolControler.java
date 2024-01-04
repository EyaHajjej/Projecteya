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
 

 


import Model.Vol;
import java.sql.*;
import java.util.*;
import configs.Crude;
import javax.swing.*;


/**
 *
 * @author OMRANI
 */
public class VolControler {
 private Crude crude = new Crude();
 
    public boolean insert(Vol e) {
        //Check for unique login/pwd
        
        String sql =
                "INSERT INTO vol(dateDepart, heureDepart, dateArrivee, heureArrivee,reservable,aeroport_depart_id,aeroport_arrivee_id) VALUES ('"
                + e.getdateDepart()+ "','"+e.getheureDepart()+ "','" + e.getdateArrivee() + "','" + e.getheureArrivee()+ "','" + e.getreservable()+  "','" + e.getaeroport_depart_id()+ "','" + e.getaeroport_arrivee_id() + "')";
       System.out.println(sql);
        return crude.exeCreate(sql); 
    }

    public boolean update(Vol a, Integer id) {
        String sql =
                "UPDATE vol SET dateDepart='" + a.getdateDepart() + "',  heureDepart='"
                + a.getheureDepart() + "' , dateArrivee= '" + a.getdateArrivee() + "', heureArrivee = '" + a.getheureArrivee() + "',  reservable = '" + a.getreservable() +  "',  aeroport_depart = '" + a.getaeroport_depart_id() + "',  aeroport_arrivee = '" + a.getaeroport_arrivee_id() +  "' WHERE id=" + id;
        return crude.exeUpdate(sql);    
    }

    public boolean delete(Vol e) {
        String sql = "DELETE FROM vol WHERE id=" + e.getId();
        return crude.exeDelete(sql);    
    }

    public List<Vol> getAll() {
    try {
            String sql = "SELECT * FROM vol";
            ResultSet rs = crude.exeRead(sql);
            List<Vol> liste = new ArrayList<Vol>();
            while (rs.next()) {
                Vol vol = new Vol();
                vol.setId(rs.getInt(1));
                vol.setdateDepart(rs.getString(2));
                vol.setheureDepart(rs.getString(3));
                vol.setdateArrivee(rs.getString(4));
                vol.setheureArrivee(rs.getString(5));
                 vol.setreservable(rs.getString(6));
                  vol.setaeroport_depart_id(rs.getString(7));
                   vol.setaeroport_arrivee_id(rs.getString(8));
                
                liste.add(vol);
            }
            return liste;
        } catch (SQLException ex) {
                System.err.println(ex.getMessage());
             JOptionPane.showMessageDialog(null, "Erreur AdministratorDAO ", "Erreur ", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    public Vol findByID(int id) {
        try {
            String sql = "SELECT * FROM administrator WHERE id = "+id;
            ResultSet rs = crude.exeRead(sql);
            Vol admin = new Vol();
            while (rs.next()) {
                admin.setId(rs.getInt(1));
                admin.setdateDepart(rs.getString(2));
                admin.setheureDepart(rs.getString(3));
                admin.setdateArrivee(rs.getString(4));
                admin.setheureArrivee(rs.getString(5));
                 admin.setreservable(rs.getString(6));
                  admin.setaeroport_depart_id(rs.getString(7));
                   admin.setaeroport_arrivee_id(rs.getString(8));
            }
            return admin;
        } catch (SQLException ex) {
              System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erreur AdministratorDAO ", "Erreur ", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public Vol findByLoginPwd(String login, String pwd){
        Vol vol = null;
        try {
            String sql = "SELECT * FROM vol WHERE login = '"+login+"' AND pwd = '"+pwd+"'";
            ResultSet rs = crude.exeRead(sql);
                while (rs.next()) {
                    vol = new Vol();
                 vol.setId(rs.getInt(1));
                vol.setdateDepart(rs.getString(2));
                vol.setheureDepart(rs.getString(3));
                vol.setdateArrivee(rs.getString(4));
                vol.setheureArrivee(rs.getString(5));
                 vol.setreservable(rs.getString(6));
                  vol.setaeroport_depart_id(rs.getString(7));
                   vol.setaeroport_arrivee_id(rs.getString(8));
                }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erreur AdministratorDAO ", "Erreur ", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return vol;
    }

}
