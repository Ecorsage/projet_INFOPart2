package satellite;
import java.util.HashMap;

/** Il s'agit d'une famille de Satellites du type ISAESat que l'on peut developper dans notre ecole*/
public class ISAESat implements Satellite {
    //Attributs
    private String name;
    private HashMap <String, Imager> composantsFamille = new HashMap <String, Imager>(); //Le HashMap qui rescence tous les composants 
    private Imager imager1; 
    private Imager imager2;
    /** Ce qui caractérise la classe ISAESat, ce sont ces 2 seuls composants Imager,
     * on pourrait imaginer une autre famille de Satellites avec d'autres composants
     */

    //Constructeur : Initialisation des Parametres
    public ISAESat (String name) {
        this.name="ISAESAT" + name;
        imager1 = new Imager();
        imager2 = new Imager();    
        composantsFamille.put("IMAGER1", imager1);
        composantsFamille.put("IMAGER2", imager2);
    }
    
    //Methodes
    /** 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /** Methode teleCommande
     * @param composantName
     * @param command
     * @return String
     */
    public Statut teleCommande (String composantName, String command) {
        //Test de l'existence d'un composant "composantName" pour ISAESat
        if (composantsFamille.containsKey(composantName)){
            switch (command){
                case "ON" : //si l'ordre est ON, on allume le composant
                    composantsFamille.get(composantName).switchOn();
                    return Statut.OK;
                case "OFF" : //si l'ordre est OFF, on éteint le composant
                    composantsFamille.get(composantName).switchOff();
                    return Statut.OK;
                default : //si l'ordre est autre chose, la commande n'est pas reconnue
                    System.out.println("Commande non reconnue");
                    return Statut.KO;
            }
        }
        System.out.println("Le composant n'existe pas encore");
        return Statut.KO;
    }
        
    
    /** Methode teleMesure
     * @param composantName
     * @return Data
     */
    public donnees.Data teleMesure (String composantName) {
        //Test de l'existence d'un composant "composantName" pour ISAESat
        if (composantsFamille.containsKey(composantName)){
            //Verification que le composant du satellite est bien ON
            if (composantsFamille.get(composantName).getEtat()) { 
                return composantsFamille.get(composantName).mesure();
            }
        }
        return null; // Le composant n'existe pas
    } 
}
