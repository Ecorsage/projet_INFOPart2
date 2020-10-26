package donnees;

public class Coordonnees {
    private double latitude;
    private double longitude;

    //Constructeurs
    public Coordonnees() {
    }
    public Coordonnees(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /** Getter
     * @return double
     */
    public double getLatitude() {
        return this.latitude;
    }

    /** Getter
     * @return double
     */
    public double getLongitude() {
        return this.longitude;
    }
    
    /** ToString
     * @return String
     */
    @Override
    public String toString() {
        return 
            " latitude= " + getLatitude() +
            ", longitude= " + getLongitude();
    }

}
