package Coupe;

import java.util.Scanner;

import inputOutput.interfaces.Affichable;
import inputOutput.interfaces.updatable;
import personnages.Entraineur;
import personnages.Joueur;

public class Equipe implements updatable,Affichable  
{
	
 private String nomEquipe;
 private Joueur[] joueurTitulaires;
 private Joueur[] remplacants;
 private Entraineur entraineur;
 private int F =0 ;
 		public Equipe() 
	{ joueurTitulaires = new Joueur[F]; // temporary nbre de joueurs nda5louh entré par utilisateur ?
	 saisie();
	 
	}
 		public Equipe(String name , Joueur[] joueurtitulaire ,Joueur[] joueurRemplacant,Entraineur entraineur)
	{   
		saisie(name,joueurtitulaire,joueurRemplacant,entraineur);
	}
	
		public void saisie(String name , Joueur[] joueurtitulaire ,Joueur[] joueurRemplacant,Entraineur entraineur)
	{
		nomEquipe=name;
		this.joueurTitulaires=joueurtitulaire;
		this.remplacants = joueurRemplacant;
		this.entraineur = entraineur;
	}
	
		public void saisie()
	{
		System.out.println("saisir le nom de  l'equipe ");
		
		Scanner sc = new Scanner(System.in);
		nomEquipe = sc.nextLine();
		
	/*	System.out.println("entrer les joueurs titulaire de l'equipe "); // nbre de joueurs titulaires =11
   
		for(int i=0;i<F;i++) 
   
	{
		joueurTitulaires[i]=new Joueur();   
		System.out.println(" *next joueur* ");
	}
		

		System.out.println("entrer le nombre de joueurs remplacants de l'equipe ");
		int n = sc.nextInt();
		remplacants = new Joueur[n];
		
		
		
		System.out.println("entrer les joueurs remplacants de l'equipe "); // nbre de joueurs remplaçants = 11 
   
	for(int i=0;i<n;i++) 
    {
		remplacants[i]=new Joueur();   
	}
		/*System.out.println("entrer l'entraineur de l'equipe ");
    
		entraineur= new Entraineur();*/
	
	}
	
	// GETTERS / SETTERS 

	 	public String getNomEquipe() {
			return nomEquipe;
		}
		public void setNomEquipe(String nomEquipe) {
			this.nomEquipe = nomEquipe;
		}
		public Joueur[] getJoueurTitulaires() {
			return joueurTitulaires;
		}
		public void setJoueurTitulaires(Joueur[] joueurTitulaires) {
			this.joueurTitulaires = joueurTitulaires;
		}
		public Joueur[] getRemplacants() {
			return remplacants;
		}
		public void setRemplacants(Joueur[] remplacants) {
			this.remplacants = remplacants;
		}
		public Entraineur getEntraineur() {
			return entraineur;
		}
		public void setEntraineur(Entraineur entraineur) {
			this.entraineur = entraineur;
		}
		
		public void update() {
		
			
		}
		public void Afficher() // affiche liste des joueurs 
		{
			 System.out.println(" ** Les joueurs titulaires de l'equipe "+nomEquipe);
			for (int i = 0; i<joueurTitulaires.length;i++)
			{  joueurTitulaires[i].Afficher();         }
			 System.out.println("\n ** Les joueurs Remplacants de cette equipe ");
				for (int i = 0 ;i<remplacants.length;i++)
				{  remplacants[i].Afficher(); }  

		}
	
						
}
