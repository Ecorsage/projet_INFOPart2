package centreControle;
import java.util.HashMap;
import java.util.Scanner;
import satellite.Satellite;

public class ControlCenter {
    //Attributs
    private HashMap <String, Satellite> constellationSatellites;
    private donnees.Data valMesuree;
    private archives.Archives salle;

    // Constructeur : Initialisation 
    public ControlCenter() {
        constellationSatellites = new HashMap <String, Satellite>();
        valMesuree = null;
        salle = new archives.Archives ();
    }

    /** Méthode pour ajouter de nouveaux satellites */
    public void add (Satellite sat){
        constellationSatellites.put(sat.getName(), sat);
    }

    /** Methode que l'on appelle dans le main et qui est pivot */
    public void teleoperate(){
        /** Partie I : Scan de la commande utilisateur */
            System.out.println();   
            System.out.println("Bienvenue, voici les types de commandes que vous pouvez saisir :");
            System.out.println("NOMDESATELLITE:NOMDECOMPOSANT:ORDRE : une commande relative a un composant d'un satellite");
            System.out.println("DISPLAY : afficher les elements que vous avez archives");
            System.out.println("STOP : vous faire sortir");
        
            Scanner sc = new Scanner (System.in);
            boolean b = true;
        while (b==true) {   
            sc.hasNextLine();  
            String line = sc.nextLine(); // Interroge l'utilisateur sur la commande à passer
            String [] words = line.split(":"); // Sépare cette String en un tableau de String pour chaque mot
            
            /** Pour arreter le scanner, l'utilisateur entre STOP */
            if (words[0].equals("STOP")) {
                b=false;
                sc.close();
                System.out.println("Fin de la commande, Merci");
            }else {
        
        /** Partie II : Interpretation de la commande */
            /** Affichage des elements de la salle d'archives */
            if (words[0].equals("DISPLAY")) {
                        salle.display();
                }else {

                    if (constellationSatellites.containsKey(words[0]) ) { // verifie que le satellite existe
                        
                        /**Test que si la commande ne contient pas STOP ni DISPLAY, alors on a bien entré une commande de type SATELLITE:COMPONENT:ORDER*/
                        int numberOfSeparators=0;
                        for (int i=0; i<line.length();i++){
                            if (line.charAt(i) == ':') {
                                numberOfSeparators++;
                            }
                        }
                        if ((numberOfSeparators!=2) || (line.endsWith(":"))) { //Il ne nous reste plus que des commandes avec 2 separateurs
                            System.out.println("KO Veuillez entrer un format de commande valide");
                        }else{
                            System.out.println("La commande est acceptee");
                            if (words[2].equals("DATA")) {
                                /**Lorsque DATA est saisi, on appelle teleMesure */
                                valMesuree = constellationSatellites.get(words[0]).teleMesure(words[1]);
                                /**Test si teleMesure renvoie une data */
                                if (valMesuree!=null){
                                    /** On ajoute a salle, qui est notre salle d'archivage la data que l'on recupere
                                     * on la nomme par le nom du satellite espage la date de mesure en string
                                    */
                                    salle.ajouterData(words[0] +" "+ words[1] +" "+ valMesuree.getDateStr(), valMesuree);
                                    System.out.println("OK data bien enregistree");
                                }else {
                                    /**Si teleMesure ne renvoie pas de data, soit le composant n'existe pas 
                                     * soit il est eteint
                                     */
                                    System.out.println("KO car le composant n'existe pas ou est éteint");
                                }      
                            }else {
                                /**Si DATA n'est pas saisi, alors on appelle teleCommande qui traitera toutes les autres commandes */
                                System.out.println(constellationSatellites.get(words[0]).teleCommande (words[1], words[2]));
                                }
                            } 
                    }else {
                        System.out.println("KO Veuillez saisir une commande correcte, avec un nom de satellite qui existe");
                    } 
                }
            } 
        }
    }
}

