package donnees;

public class DataGeoloc extends Data{
    //Attributs
    private Coordonnees coord;

    // Constructeurs
    public DataGeoloc(Coordonnees coord) {
        super ();
        this.coord = coord;
    }

    //Methodes
    /** Getter de la coordonnee de la geolocalisation
     * @return Coordonnees
     */
    public Coordonnees getCoord() {
        return this.coord;
    }
}
