/**
 * 
 */
package Coupe;

import java.util.Random;
import java.util.Scanner;

import inputOutput.interfaces.Input;
import personnages.Arbitre;

public class Match  implements Input 
{
 private int numeroTour;
 private Equipe equipe1;
 private Equipe equipe2;
 private Arbitre arbitreMatch ;
 private String resultat ;
 
 public Match()
 { 
	 saisie();
 }
 public Match(Equipe e1 , Equipe e2,int numTour)
 {

	 numeroTour = numTour;
	 equipe1= e1;
	 equipe2 = e2;
	 arbitreMatch = new Arbitre();
	 resultat = generateResultat();
 }
 public void saisie()
 { 
	 
	 System.out.println("saisir le numTour du match  ");
	 Scanner sc = new Scanner(System.in);
	 setNumeroTour(sc.nextInt());
	 equipe1= new Equipe();
	 equipe2 = new Equipe();
	 arbitreMatch = new Arbitre();
	 resultat = generateResultat();
	 
 }
 
public String generateResultat() 
{
	Random r = new Random();
	String[]  S = {"victoire ", "Defaite", "nulle"} ; // victoire indique victoire de l'equipe 1 sur 2  
	  
	return S[r.nextInt(3)]; // r.nextInt(3) renvoi un entier Random entre 0 et 2
}
public void update()
 {
 
 }
public void affiche()
{
	System.out.println("**Match  tour "+ numeroTour+"  :  "+ equipe1.getNomEquipe()+
			" VS "+equipe2.getNomEquipe());
	System.out.println("RESULTAT = "+resultat);
	
	
}
 // setters+Getters 
public int getNumeroTour() {
	return numeroTour;
}
public void setNumeroTour(int numeroTour) {
	this.numeroTour = numeroTour;
}
public Equipe getEquipe1() {
	return equipe1;
}
public void setEquipe1(Equipe equipe1) {
	this.equipe1 = equipe1;
}
public Equipe getEquipe2() {
	return equipe2;
}
public void setEquipe2(Equipe equipe2) {
	this.equipe2 = equipe2;
}
public Arbitre getArbitreMatch() {
	return arbitreMatch;
}
public void setArbitreMatch(Arbitre arbitreMatch) {
	this.arbitreMatch = arbitreMatch;
}
public String getResultat() {
	return resultat;
}
public void setResultat(String resultat) {
	this.resultat = resultat;
}
	
	

}
