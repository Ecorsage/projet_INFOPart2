package donnees;
import java.util.Date;

public class Data {
    //Attributs
    private Date dateOfOperation = new Date ();
    private String dateStr = dateOfOperation.toString();

     //Méthodes
    /** Getter de la date au format Date
     * @return Date
     */
    public Date getDateOfOperation() {
        return this.dateOfOperation;
    }

    
    /** Getter de la date au format String
     * @return String
     */
    public String getDateStr() {
        return this.dateStr;
    }    
}
