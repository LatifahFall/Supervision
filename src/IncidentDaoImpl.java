import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IncidentDaoImpl implements IncidentDao {
    private List<Incident> incidents = new ArrayList<>();

    @Override
    public void inserer(Incident i) {
        incidents.add(i);
        System.out.println("Incident inséré : " + i);
    }

    @Override
    public void insert(Set<Incident> incidentsSet) {
        incidents.addAll(incidentsSet);
        System.out.println("Incidents insérés : " + incidentsSet);
    }
}
