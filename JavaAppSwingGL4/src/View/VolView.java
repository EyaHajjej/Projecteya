package View;


import Model.Vol;
import controler.VolControler;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class VolView extends JFrame {

    private VolControler VolControler;
    private JTable jTableVols;

    public VolView() {
        setTitle("Gestion des Vols");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        VolControler = new VolControler();

        initUI();
    }

    private void initUI() {
        // Création du modèle de tableau
        DefaultTableModel model = new DefaultTableModel();
        jTableVols = new JTable(model);

        // Ajout des colonnes au modèle
        model.addColumn("ID");
        model.addColumn("Aéroport de Départ");
        model.addColumn("Aéroport d'Arrivée");
        model.addColumn("Date de Départ");
        model.addColumn("Heure de Départ");
        model.addColumn("Date d'Arrivée");
        model.addColumn("Heure d'Arrivée");

        // Ajout des données au modèle
        refreshTable();

        // Création d'un JScrollPane pour la JTable
        JScrollPane scrollPane = new JScrollPane(jTableVols);

        // Ajout des composants à la fenêtre
        add(scrollPane, BorderLayout.CENTER);

        // Bouton pour rafraîchir la table
        JButton refreshButton = new JButton("Rafraîchir");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });

        // Bouton pour ajouter un vol
        JButton addButton = new JButton("Ajouter Vol");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour ajouter un vol
                // Vous pouvez afficher une boîte de dialogue ou passer à une autre vue
                JOptionPane.showMessageDialog(null, "Ajout de vol non implémenté.");
            }
        });

        // Utilisation d'un gestionnaire de mise en page (par exemple, BorderLayout) pour organiser les composants
        setLayout(new BorderLayout());
        add(refreshButton, BorderLayout.NORTH);
        add(addButton, BorderLayout.SOUTH);

        // Vous pouvez ajouter d'autres composants et organiser votre IHM comme nécessaire
    }

    private void refreshTable() {
        // Rafraîchissement des données de la table
        ArrayList<Vol> vols = VolControler.getAllVols();
        DefaultTableModel model = (DefaultTableModel) jTableVols.getModel();
        model.setRowCount(0); // Effacer les anciennes lignes

        for (Vol vol : vols) {
            model.addRow(new Object[]{
                vol.getId(),
                vol.getAeroportDepart(),
                vol.getAeroportArrivee(),
                vol.getDateDepart(),
                vol.getHeureDepart(),
                vol.getDateArrivee(),
                vol.getHeureArrivee()
            });
        }
    }

    public static void main(String[] args) {
        // Exécutez l'IHM dans l'Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VolView volView = new VolView();
                volView.setVisible(true);
            }
        });
    }
}
