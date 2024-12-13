import javax.swing.*;

import java.util.List;
import java.util.Set;

public class AjouterMembreUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JTextField phoneField;
    private JButton ajouterButton;
    private JButton importerCSVButton;

    private MembreDao membreDao;

    public AjouterMembreUI(MembreDao membreDao) {
        this.membreDao = membreDao;

        setTitle("Ajouter un Membre");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Champ Nom
        JLabel nomLabel = new JLabel("Nom :");
        nomLabel.setBounds(20, 20, 100, 25);
        add(nomLabel);

        nomField = new JTextField();
        nomField.setBounds(100, 20, 150, 25);
        add(nomField);

        // Champ Prénom
        JLabel prenomLabel = new JLabel("Prénom :");
        prenomLabel.setBounds(20, 60, 100, 25);
        add(prenomLabel);

        prenomField = new JTextField();
        prenomField.setBounds(100, 60, 150, 25);
        add(prenomField);
        
     // Champ Email
        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setBounds(20, 100, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 100, 150, 25);
        add(emailField);
        
     // Champ Phone
        JLabel phoneLabel = new JLabel("Phone :");
        phoneLabel.setBounds(20, 140, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(100, 140, 150, 25);
        add(phoneField);

        // Bouton Ajouter
        ajouterButton = new JButton("Ajouter");
        ajouterButton.setBounds(200, 180, 150, 25);
        add(ajouterButton);

        ajouterButton.addActionListener(e -> ajouterMembre());
        
        setVisible(true);

        // Bouton Importer CSV
        importerCSVButton = new JButton("Importer CSV");
        importerCSVButton.setBounds(100, 140, 150, 25);
        add(importerCSVButton);

        importerCSVButton.addActionListener(e -> importerMembresDepuisCSV());

        setVisible(true);
        
     // Bouton Afficher Membres
        JButton afficherMembresButton = new JButton("Afficher Membres");
        afficherMembresButton.setBounds(20, 180, 150, 25);
        add(afficherMembresButton);

        afficherMembresButton.addActionListener(e -> afficherMembres());

        setVisible(true);
    }

    private void ajouterMembre() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();

        if (nom.isEmpty() || prenom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Remplissez tous les champs !", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            String id = java.util.UUID.randomUUID().toString();
            Membre membre = new Membre(id, nom, prenom, "", "");
            membreDao.inserer(membre);
            JOptionPane.showMessageDialog(this, "Membre ajouté avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            nomField.setText("");
            prenomField.setText("");
        }
    }

    private void importerMembresDepuisCSV() {
        JFileChooser chooser = new JFileChooser();
        int returnValue = chooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String cheminFichier = chooser.getSelectedFile().getAbsolutePath();
            CSVImporter importer = new CSVImporter();
            Set<Membre> membres = importer.chargerListeMembre(cheminFichier);

            for (Membre m : membres) {
                membreDao.inserer(m);
            }

            JOptionPane.showMessageDialog(this, membres.size() + " membres importés avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        MembreDao membreDao = new MembreDaoImpl();
        new AjouterMembreUI(membreDao);
    }
    
    private void afficherMembres() {
        List<Membre> membres = ((MembreDaoImpl) membreDao).listerMembres(); // Obtenir la base simulée
        if (membres.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun membre dans la base de données simulée.", "Informations", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder sb = new StringBuilder();
            for (Membre m : membres) {
                sb.append(m).append("\n");
            }

            JOptionPane.showMessageDialog(this, sb.toString(), "Base de Données Simulée", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
