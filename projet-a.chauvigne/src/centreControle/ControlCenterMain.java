package centreControle;
import satellite.ISAESat;

public class ControlCenterMain {
    
    /** Methode Main
     * @param args
     */
    public static void main(String[] args) {
        ControlCenter monControlCenter = new ControlCenter(); //Creation du centre de controle
        monControlCenter.add (new ISAESat ("A")); //ajout de 2 satellites
        monControlCenter.add (new ISAESat ("B"));
        
        monControlCenter.teleoperate(); //on appelle teleoperate qui va scanner les ordres de l'utilisateur





    }
}
