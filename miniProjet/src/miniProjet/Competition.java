package miniProjet;
/**
 * @author Raed
 *
 */
public class Competition {
    private int numeroTours ; // le num�ro des tours dans notre comp�tition
    private Match[] matchTable; // un tableau contenant les matchs de notre comp�tition
   
    
    public Competition() {
    	
    }// constructeur vide
    


    public Competition (int tour , Match[] match) {
    	this.numeroTours=tour;
    	this.matchTable=match;
    	
    } // constructeurs
    
    
}
