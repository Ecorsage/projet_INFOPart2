package donnees;
import java.util.Arrays;

public class DataImage extends DataGeoloc{
    //Atributs
    private int [][] bitmap ; 

    // Constructeurs 
    public DataImage(Coordonnees coordonnee, int [][] bitmap) {
        super (coordonnee);
        this.bitmap = bitmap;
    }

    //Methodes
    /** Getter de la bitmap ie de la photo prise
     * @return int[][]
     */
    public int[][] getBitmap() {
        return this.bitmap;
    }

    
    /** ToString permettant d'afficher pour la mesure : sa date, ses coordonnées de position,
     * et l'image prise par la camera
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "{" + " Date= " + getDateStr() +
             "; Coordonnées = " + getCoord() +
             "; Bitmap=" + Arrays.deepToString(getBitmap()) +
              "}";

    }

}
