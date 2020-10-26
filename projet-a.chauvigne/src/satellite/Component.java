package satellite;

public class Component{
    //Attributs
    protected boolean etat;

    //Constructeurs
    public Component() {
        etat = false;
    }

    
    /** 
     * @return boolean
     */
    //Méthodes
    public boolean getEtat() {
        return this.etat;
    }
    
    public void switchOn(){
        etat = true;
    }

    public void switchOff(){
        etat = false;
    }

    /** Nous n'avons pas mis ici mesure (même en méthode abstraite) car certains composants peuvent avoir d'autres utilités
     * que de faire des mesures, e.g. une lampe qui éclaire, un moteur qui fait se mouvoir etc. **/
    
}
