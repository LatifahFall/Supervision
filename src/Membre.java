import java.util.Objects;

public class Membre {

	private String id;
	private String nom;
	private String prenom;
	private String email;
	private String phone;
	
	 // Constructeur
    public Membre(String id, String nom, String prenom, String email, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
    }
	
	//getters et setters
	public String getId() {return id;}
	public void setId(String id) {this.id=id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom=nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom=prenom;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email=email;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone=phone;}
	
	@Override
	public boolean equals(Object o) {
		Membre m =(Membre)o;
		return m.id==id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
