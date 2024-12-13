public class Main {
    public static void main(String[] args) {
        // Création de l'implémentation du DAO
        MembreDao membreDao = new MembreDaoImpl();
        
        // Lancer l'interface utilisateur
        new AjouterMembreUI(membreDao);
    }
}

