/**
 * 
 */
package personnages;

import java.util.Scanner;

import inputOutput.interfaces.Affichable;

/**
 * @author SamiElleuch
 *
 */
public class Joueur extends Personne  implements Affichable 
	{
	
	private String poste ; 
	private int numMaillot;
	
	

	/**
	 * 
	 */
	public Joueur() 
	{    super(); // apelle le constructeur de personne  intialise nom ...
		saisie(); 
	}
	
	
	public void saisie()  //interface
	{
		System.out.println("saisir le poste du joueur ");
		 Scanner sc = new Scanner(System.in);
		 poste = sc.nextLine();
		System.out.println("saisir le numMaillot du joueur ");
        numMaillot= sc.nextInt();
	
	}


	public void Afficher() 
	{
	super.Afficher();
	
	}


	
}
