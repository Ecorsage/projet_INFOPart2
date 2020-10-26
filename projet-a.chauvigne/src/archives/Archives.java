package archives;
import java.util.HashMap;

public class Archives {
    //Attributs : la HashMap dans laquelle on va stocker nos Data
    private HashMap <String, donnees.Data> EltsArchives;

    //Constructeur
    public Archives() {
        EltsArchives = new HashMap <String, donnees.Data>();
    }

    //Methodes
    /** Methode permettant d'ajouter une Data qui sera recuperee en sortie de teleoperate 
     * pour la stocker
     * @param clef
     * @param val
     */
    public void ajouterData (String clef, donnees.Data val){
        EltsArchives.put (clef, val);
    }

    public void display(){
        if (EltsArchives.size()==0){
            System.out.println("La salle d'archivage est vide");
        } else {
            for (String s : EltsArchives.keySet()){
                System.out.println();
                System.out.println(s);
                System.out.println(EltsArchives.get(s));
            }
        }
    }
    
    /** Getter pour toute notre archive
     * @return HashMap<String, Data>
     */
    public HashMap<String,donnees.Data> getEltsArchives() {
        return this.EltsArchives;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " EltsArchives='" + EltsArchives + "'" +
            "}";
    }

}
