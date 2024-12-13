import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDao {
    private List<Membre> membres = new ArrayList<>();
    private List<Incident> incidents = new ArrayList<>(); // Liste d'incidents simulée

    @Override
    public void inserer(Membre m) {
        membres.add(m);
        System.out.println("Membre inséré : " + m);
    }

    @Override
    public List<Incident> chargerListIncidents() {
        // Simuler le chargement des incidents liés aux membres
        System.out.println("Chargement des incidents...");
        return incidents;
    }
    
    public List<Membre> listerMembres() {
        return membres; // Retourner la base de données simulée
    }
}
