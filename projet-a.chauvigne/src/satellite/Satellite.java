package satellite;

public interface Satellite {
    /**l'interface Satellite de laquelle tous les satellites heritent */
    public String getName();
    public Statut teleCommande (String composantName, String command); //Methode TeleCommande
    public donnees.Data teleMesure (String composantName); //Methode teleMesure
    


}
