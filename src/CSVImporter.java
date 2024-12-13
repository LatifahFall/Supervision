import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CSVImporter {

    public Set<Membre> chargerListeMembre(String nomFichier) {
        Set<Membre> membres = new HashSet<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] data = ligne.split(",");
                
                if (data.length == 4) { // On vérifie que la ligne a bien 4 valeurs
                    String id = java.util.UUID.randomUUID().toString(); // Génération d'un identifiant unique
                    Membre membre = new Membre(id, data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
                    membres.add(membre);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        
        return membres;
    }
}
