package controler;

import Model.Aeroport;
import Model.Vol;
import java.sql.*;
import java.util.ArrayList;
import configs.Crude;
import java.util.Date;
import javax.swing.*;

public class VolControler {
    private Crude crude = new Crude();

    public boolean insert(Vol vol) {
        String sql = "INSERT INTO vol (aeroportDepart, aeroportArrivee, dateDepart, heureDepart, dateArrivee,heureArrivee) VALUES ('"
                + vol.getAeroportDepart() + "','" + vol.getAeroportArrivee() + "','" + vol.getDateDepart() + "','" + vol.getHeureDepart()
                + "','" + vol.getDateArrivee() + "','" + vol.getHeureArrivee() + "')";
        System.out.println(sql);
        return crude.exeCreate(sql);
    }

    public boolean update(Vol vol, int id) {
        String sql = "UPDATE vol SET aeroportDepart='" + vol.getAeroportDepart() + "',  aeroportArrivee='"
                + vol.getAeroportArrivee() + "' , dateDepart= '" + vol.getDateDepart() + "',heureDepart = '" + vol.getHeureDepart()
                + "', dateArrivee = '" + vol.getDateArrivee() + "', heureArrivee= '" + vol.getHeureArrivee() + "' WHERE id=" + id;
        return crude.exeUpdate(sql);
    }

    public boolean delete(Vol vol) {
        String sql = "DELETE FROM vol WHERE id=" + vol.getId();
        return crude.exeDelete(sql);
    }

    public ArrayList<Vol> getAllVols() {
        try {
            String sql = "SELECT * FROM vol";
            ResultSet rs = crude.exeRead(sql);
            ArrayList<Vol> volList = new ArrayList<>();

            while (rs.next()) {
                Vol vol = new Vol(Date dateDepart, Date heureDepart, Date dateArrivee, Date heureArrivee, boolean reservable,
               Aeroport aeroportDepart, Aeroport aeroportArrivee); // Correction : Création d'un nouvel objet Vol
                vol.setId(rs.getInt("id"));
               vol.setAeroportDepart(new Aeroport(rs.getString("aeroportDepart")));
               vol.setAeroportArrivee(new Aeroport(rs.getString("aeroportArrivee")));
                vol.setDateDepart(rs.getDate("dateDepart"));
                vol.setHeureDepart(rs.getTime("heureDepart"));
                vol.setDateArrivee(rs.getDate("dateArrivee"));
                vol.setHeureArrivee(rs.getTime("heureArrivee"));

                volList.add(vol);
            }
            return volList;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erreur VolController ", "Erreur ", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public Vol findByID(int id) {
        try {
            String sql = "SELECT * FROM vol WHERE id = " + id;
            ResultSet rs = crude.exeRead(sql);
            Vol vol = new Vol(( dateDepart,heureDepart,dateArrivee,  heureArrivee,reservable,
              aeroportDepart, aeroportArrivee));

            while (rs.next()) {
                vol.setId(rs.getInt("id"));
     vol.setAeroportDepart(new Aeroport(rs.getString("aeroportDepart")));
               vol.setAeroportArrivee(new Aeroport(rs.getString("aeroportArrivee")));
                 vol.setDateDepart(rs.getDate("dateDepart"));
                vol.setHeureDepart(rs.getTime("heureDepart"));
                vol.setDateArrivee(rs.getDate("dateArrivee"));
                vol.setHeureArrivee(rs.getTime("heureArrivee"));
            }
            return vol;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erreur VolController ", "Erreur ", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
