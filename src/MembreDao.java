import java.util.List;

public interface MembreDao {

	void inserer(Membre m);
	List<Incident> chargerListIncidents();	
}
