import java.time.LocalDateTime;

public class Incident {

	private String ref;
	private LocalDateTime time;
	private String status;
	
	 // Constructeur
    public Incident(String ref, LocalDateTime time, String status) {
        this.ref = ref;
        this.time = time;
        this.status = status;
    }
    
  //getters et setters
  	public String getRef() {return ref;}
  	public void setRef(String id) {this.ref=ref;}
  	public LocalDateTime getTime() {return time;}
  	public void setTime(LocalDateTime time) {this.time = time;}
  	public String getStatus() {return status;}
  	public void setStatus(String status) {this.status = status;}
  	
}
