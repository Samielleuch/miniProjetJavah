/**
 * 
 */
package personnages;

import java.util.Scanner;

import inputOutput.interfaces.Affichable;
import inputOutput.interfaces.Input;

/**
 * @author SamiElleuch
 *
 */

public abstract class Personne implements Input,Affichable 
{
	private String nomPersonne ; 
	private String prenomPersonne ; 
	private int agePersonne ; 
	private String adressePersonne ;
	private String nationalitePersonne ; 
	
	
	public Personne()
	{
	 System.out.println("saisir le nom du "+ this.getClass().getSimpleName());  
	 // utile pour polymorphism if joueur ywali y'affichi  saisir le num de joueur
	 Scanner sc = new Scanner(System.in);
	 this.nomPersonne = sc.nextLine();
	 
	 System.out.println("saisir le prenom du  "+ this.getClass().getSimpleName());
	 this.prenomPersonne = sc .nextLine();
	 
	 System.out.println("saisir l'age du "+ this.getClass().getSimpleName());
	 this.agePersonne = sc.nextInt();
	 
	 sc .nextLine(); // clears buffer  more info here -> // https://stackoverflow.com/questions/10604125/how-can-i-clear-the-scanner-buffer-in-java
	 System.out.println("saisir l'adresse du  "+ this.getClass().getSimpleName());
	 this.adressePersonne= sc .nextLine();
	 
	 System.out.println("saisir la nationalite du  "+ this.getClass().getSimpleName());
	 this.nationalitePersonne= sc .nextLine();
		
	}
	
	public void Afficher() // affichage  
 	{
	 System.out.println("le nom du "+ this.getClass().getSimpleName()+" est "+nomPersonne);
	 System.out.println("le prenom du "+ this.getClass().getSimpleName()+" est "+prenomPersonne);
	 System.out.println("l'age du "+ this.getClass().getSimpleName()+" est "+agePersonne);
	 System.out.println("l'adresse du "+ this.getClass().getSimpleName()+" est "+adressePersonne);
	 System.out.println("la nationalité de "+ this.getClass().getSimpleName()+" est "+nationalitePersonne);
	}

 // geters + setters 
	
	public String getNom() {
		return nomPersonne;
	}


	public void setNom(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}


	public String getPrenom() {
		return prenomPersonne;
	}


	public void setPrenom(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}


	public int getAge() {
		return agePersonne;
	}


	public void setAge(int agePersonne) {
		this.agePersonne = agePersonne;
	}


	public String getAdresse() {
		return adressePersonne;
	}


	public void setAdresse(String adressePersonne) {
		this.adressePersonne = adressePersonne;
	}


	public String getNationalite() {
		return nationalitePersonne;
	}


	public void setNationalite(String nationalitePersonne) {
		this.nationalitePersonne = nationalitePersonne;
	}




}
