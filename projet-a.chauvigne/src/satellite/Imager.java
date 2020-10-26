package satellite;

/** Imager est un type de composant Component que peut contenir un satellite */
public class Imager extends Component{

    //Constructeur
    public Imager() {
        super();
    }

    /** Methode mesure effectue une mesure à l'instant de la commande et renvoie l'image
     * de type DataImage qui va contenir une Date, une Coordonnee (latitude et longitude)
     * et une image bitmap
     * 
     * @return DataImage
     */
    public donnees.DataImage mesure (){
        //Pour le moment, la coordonnee est generee aleatoirement parmi les valeurs possibles de latitude et longitude
        donnees.Coordonnees coordMesure = new donnees.Coordonnees (-90+180*Math.random(), -180+360*Math.random());
        
        //L'image est un tableau d'entiers de taile 255*255, que l'on pourra par la suite identifier à des pixels
        int [][] image = new int [11] [11];
        for (int i=0; i<11; i++) {
            for (int j=0; j<11; j++){ 
                image [i][j] = (int) (255*Math.random()); //Valeurs aléatoires entre 0 et 99 que peuvent prendre les pixels
            }
        }

        //L'image que l'on retourne avec sa date et coordonnee
        donnees.DataImage bitmapImager = new donnees.DataImage (coordMesure, image);
        return bitmapImager;
    }
}
