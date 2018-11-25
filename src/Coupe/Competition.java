	package Coupe;
	
	import java.util.Scanner;

	import inputOutput.interfaces.*;

public class Competition implements Input,Affichable,updatable 
{
private int numeroTours ; // le numéro des tours dans notre compétition
private Match[] matchTable; // un tableau contenant les matchs de notre compétition
   
    
    public Competition() 
    {
    	saisie(); // realise la saisie du tableau de matches
    	numeroTours = genererNumeroTours(); // intialise le numeroTours 
    }
    
    public Competition (int tour , Match[] match) {
    	this.numeroTours=tour;
    	this.matchTable=match;
    	
    } // surcharge de constructeur 
   
	public void saisie() // interface 
	{		
		System.out.println("saisir le nbre de Matches ");
		 Scanner sc = new Scanner(System.in);
		 final int N = sc.nextInt();  // le nbre de matches 
		 
		 for(int i =0 ; i<N;i++)
		 {
			 
			 matchTable[i]=new Match();
			 // remplissage de tableau de matches 
		 }
		
	}


	public void update()
	{
		
	}
	public void Afficher() // affiche les matches et les resultats des matchs par tour 
	{
		 int counter=0;  
		 // si counter == taille du tableau donc on a afficher tous les matches
		 while (counter<matchTable.length) 
		 
		 {
			 
			 
		for(int i = 1; i <= numeroTours ; i++)  // les tours commencent de 1 
		{   
			System.out.println("les matches du tour "+i);
			if ( matchTable[i-1].getNumeroTour() == i ) 
		{ matchTable[i-1].affiche(); counter ++ ; } // affiche le match au iemme tour
			
		}
		
		
		 }
	}
    public int genererNumeroTours()
    {
       return(  (int)(Math.log(matchTable.length)/Math.log(2)) );  // nbre de tours =  log2(nb equipes)
       
    }


// setters getters 

    public int getNumeroTours() 
    {
		return numeroTours;
	}
    
    public Match[] getMatchTable() {
		return matchTable;
	}
   
}