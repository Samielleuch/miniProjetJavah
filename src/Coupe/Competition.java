	package Coupe;
	
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import inputOutput.interfaces.Affichable;
import inputOutput.interfaces.Input;
import inputOutput.interfaces.updatable;

public class Competition implements Input,Affichable,updatable 
{
	
private int numeroTours ; // le numéro des tours dans notre compétition
private Match[] matchTable=null; // un tableau contenant les matchs de notre compétition
private Equipe[]  participant; // tableau d'equipes participants   
        
		public Competition() 
    {
    	saisie(); // realise la saisie du tableau de participants
    	numeroTours = genererNumeroTours(); // intialise le numeroTours 
    	GameLogic();
    }
    
    public Competition (int tour , Match[] match,Equipe[] participant ) {
    	this.numeroTours=tour;
    	this.matchTable=match;
    	this.participant = participant;    	
    } // surcharge de constructeur 
   
	public void saisie() // interface 
	{		
		System.out.println("saisir le nbre d'equipes participants ");
		 Scanner sc = new Scanner(System.in);
		 final int N = sc.nextInt();  // le nbre d'equipes
		   participant = new Equipe[N]; // declaration de tableau 
		
		 for(int i =0 ; i<N;i++)
		 {
			 
			 participant[i]=new Equipe();
			 // remplissage de tableau de participants 
		 }
		
	}


	public void update()
	{
		
	}
	public void Afficher() // affiche les matches et les resultats des matchs par tour 
	{
		
		for(int i = 1; i <= numeroTours ; i++) { 
		//	System.out.println("les matches du tour "+i);
		for(int j=0 ;j<matchTable.length;j++) 	  // parcours de matches
			 // les tours commencent de 1 
		{   
			
			if ( matchTable[j].getNumeroTour() == i ) 
		{ matchTable[j].affiche(); } // affiche le match au iemme tour
			
		}
	
		 }
	}
    public int genererNumeroTours()
    {
       return(  (int)(Math.log(participant.length)/Math.log(2)) );  // nbre de tours =  log2(nb equipes)
       
    }
    public List<Match>  rechercheMatch(Equipe e1, Equipe e2)
    {
    	List <Match>  result = new ArrayList<Match>() ; // liste chainé
    	for (int i =0 ; i< matchTable.length;i++)
    	{
    		if (( matchTable[i].getEquipe1().equals(e1) &&  matchTable[i].getEquipe2().equals(e2)) ||
    		( matchTable[i].getEquipe2().equals(e1) && matchTable[i].getEquipe1().equals(e2) )  )
    		{
    			result.add(matchTable[i]);
    		}
    	}
    	
    	return result ;
    	
    }

    private void GameLogic()
     // setup matches ! // genere tableau de matches 
    {
    	
    	Random r = new Random();
    	List <Match>  temp  = new ArrayList<Match>() ; // creation  liste chainé de matches 
    	List<Equipe>  qualifed = new ArrayList<Equipe>(Arrays.asList(participant)) ;// les equipes qualifié chaque tour
        List<Equipe>  roster =  new ArrayList<Equipe>(Arrays.asList(participant)) ; // les participants de chaque tour
    	int nbToure = 1;
    	 int indice1 ;
    	 int indice2;
    	 
    	 /*       principe 
     	 * le programme doit depuis le tableau de participants initial de realiser le tirage au sort de matches
     	 * et puis on simule les matche (on met ajours les resultats) et on stocke les equipes qualifée gagnant dans 
     	 * la liste qualifed qui sont  les
     	 * participant du tour suivant 
     	 */
    	 
    	 
    	 
    	while(nbToure<=numeroTours)
    	{
    		
                            // last person qualified = WINNER
    		  System.out.println("*********************************LE TOUR "+nbToure+" COMMANCE *******");	
    		  if (nbToure==numeroTours) { System.out.println("LE CHAMPION EST "+ qualifed.get((qualifed.size()-1)).getNomEquipe()); break;}
    	while( roster.size()>0)        
    		// tant que il ya des participant
    	{
    	 indice1 = r.nextInt(roster.size());                    // premier nbre tirer par tirage au sort 
    	 indice2 = r.nextInt(roster.size());                   // 2emme nbre tier par tirage au sort 
    	 Match m = new Match(roster.get(indice1),roster.get(indice2),nbToure);        // nb1 VS nb2 
    	if ((indice1 != indice2)&&(indice2 != indice1)&&(!temp.contains(m)))           
    	{  
  		

    		  temp.add(m) ; // we can add affichage du tirage au sort
      	
    		  System.out.println("**Le tirage au sort donne l'equipe  intitule  "
    		  		  +roster.get(indice1).getNomEquipe() +" ** VS ** "+ "l'equipe intitule  "+
    		  		   roster.get(indice2).getNomEquipe() );
    		  
    		  
    		  Equipe a = roster.get(indice1);
    		  Equipe b = roster.get(indice2);
    		 roster.remove(a);   // remove from tirage list pour this tour ;
       		 roster.remove(b);   
      		  
    		  if (m.getResultat().equals("nulle"))
    		  { 
    			 
    			  //System.out.println("NULLES-> **PENALTIES**"); 
    			  while(m.getResultat().equals("nulle"))
    			  {
           	m.setResultat(m.generateResultat()); //procede au pénalties puis affiche resultat de qui a gagné
    				
    			  }
    		
    		  } 
    		   if (m.getResultat().equals("victoire ")) {
    			  //System.out.println("VICTORY ");
    			  
    			  qualifed.remove(m.getEquipe2());  // remove de la liste qualifed qui ont perdu "disqualifié"
    			 
    		  }
    		  else if (m.getResultat().equals("Defaite"))
    		  {
    			  //System.out.println("LOSS");
    			  qualifed.remove(m.getEquipe1());  // remove de la liste qualifed qui ont perdu "disqualifié"

    		  }

    		  }
    		  
    		  
    	}
    	
    	nbToure++;
    	roster.clear(); // suppression
    	for (int k=0 ;k<qualifed.size();k++)
    	{roster.add(qualifed.get(k));}  // la liste roster prend les valeurs de qualifed (qui sont qualifié forme le Roster du tour suivant)
    	
    	

    	
    
       }
    	      
        matchTable = temp.toArray( new Match [temp.size()]); 
     // conversion de la liste final des matches jouée en un tableau
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