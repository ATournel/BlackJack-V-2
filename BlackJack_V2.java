import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class BlackJack_V2 {
	
	public static void partie() {
		String nextG;
		do {	
		nextG = "y";
		System.out.println("Nouvelle partie:\n\n");
//Creation des cartes et du deck, assignation des valeurs des cartes
		String[] colors= {"Carreau", "Coeur", "Trèfle", "Pique"};
		String[] ranks= {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Reine", "Roi"};
		ArrayList<String> deck = new ArrayList<String>();
		ArrayList<String> bank = new ArrayList<String>();
		ArrayList<String> joueur = new ArrayList<String>();
		Map<String, Integer> deckV = new HashMap<String, Integer>();
		int x;
		int y;
		int v=1;
		for (x=0; x<=3; x++) {
			for (y=0; y<=12; y++) {
				deckV.put(ranks[y]+" de "+colors[x], v );
				deck.add(ranks[y] + " de " + colors[x]);
				v++;
			}
			v=1;
		}
//Valeur des têtes à 10
		deckV.put("Valet de Carreau", 10);
		deckV.put("Reine de Carreau", 10);
		deckV.put("Roi de Carreau", 10);
		deckV.put("Valet de Coeur", 10);
		deckV.put("Reine de Coeur", 10);
		deckV.put("Roi de Coeur", 10);
		deckV.put("Valet de Trèfle", 10);
		deckV.put("Reine de Trèfle", 10);
		deckV.put("Roi de Trèfle", 10);
		deckV.put("Valet de Pique", 10);
		deckV.put("Reine de Pique", 10);
		deckV.put("Roi de Pique", 10);
		//System.out.println(deckV.entrySet());
		//System.out.println(deck);
		
//Shuffle du deck
		Collections.shuffle(deck);
		//System.out.println(deck);
		
//Distribution des cartes et compter leur valeur
		int valeurJ;
		int valeurB;
		for(int z=0; z<2; z++) {
		joueur.add(deck.get(0));
		deck.remove(0);
		bank.add(deck.get(0));
		deck.remove(0);
		}
		valeurJ=deckV.get(joueur.get(0)) + deckV.get(joueur.get(1));
		valeurB=deckV.get(bank.get(0)) + deckV.get(bank.get(1));
		if(valeurJ<=11) {
			deckV.put("As de Carreau", 11);
			deckV.put("As de Trèfle", 11);
			deckV.put("As de Pique", 11);
			deckV.put("As de Coeur", 11);	
			valeurJ=deckV.get(joueur.get(0)) + deckV.get(joueur.get(1));
		}
		if(valeurB<=11) {
			deckV.put("As de Carreau", 11);
			deckV.put("As de Trèfle", 11);
			deckV.put("As de Pique", 11);
			deckV.put("As de Coeur", 11);
			valeurB=deckV.get(bank.get(0)) + deckV.get(bank.get(1));
		}
			
		System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
		System.out.println("Main de la Banque: " + bank.get(0) + ".\n" + " Valeur des cartes: " + deckV.get(bank.get(0)) + ".\n");
		
		
//Redistribuer des cartes
		
		
//Joueur
		Scanner scJoueur = new Scanner(System.in);
	do {	
		System.out.println("\nNouvelle carte?\nPress 'Y' for yes or 'N' for no.\n");		
		String carteSup = scJoueur.next();
		if (joueur.size()==2) {
			if(carteSup.equals("y")) {
				joueur.add(deck.get(0));
				deck.remove(0);
				valeurJ=valeurJ + deckV.get(joueur.get(2));
				if(valeurJ<=11) {
					deckV.put("As de Carreau", 11);
					deckV.put("As de Trèfle", 11);
					deckV.put("As de Pique", 11);
					deckV.put("As de Coeur", 11);
					System.out.println("Le joueur tire une nouvelle carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ", " + joueur.get(2) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
					
				}
				else {
					System.out.println("Le joueur tire une nouvelle carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ", " + joueur.get(2) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
				}
			}
			else {
				if(valeurJ<=11) {
					deckV.put("As de Carreau", 11);
					deckV.put("As de Trèfle", 11);
					deckV.put("As de Pique", 11);
					deckV.put("As de Coeur", 11);
					System.out.println("Le joueur ne tire pas de carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
				}
				else {
					System.out.println("Le joueur ne tire pas de carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
				}
			}
		}
		else if(joueur.size()==3) {
			if(carteSup.equals("y")) {
				joueur.add(deck.get(0));
				deck.remove(0);
				valeurJ=valeurJ + deckV.get(joueur.get(3));
				if(valeurJ<=11) {
					deckV.put("As de Carreau", 11);
					deckV.put("As de Trèfle", 11);
					deckV.put("As de Pique", 11);
					deckV.put("As de Coeur", 11);
					System.out.println("Le joueur tire une nouvelle carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ", " + joueur.get(2) + ", " + joueur.get(3) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
					
				}
				else {
					System.out.println("Le joueur tire une nouvelle carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ", " + joueur.get(2) + ", " + joueur.get(3) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
				}
			}
			else {
				if(valeurJ<=11) {
					deckV.put("As de Carreau", 11);
					deckV.put("As de Trèfle", 11);
					deckV.put("As de Pique", 11);
					deckV.put("As de Coeur", 11);
					System.out.println("Le joueur ne tire pas de carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ", " + joueur.get(2) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
				}
				else {
					System.out.println("Le joueur ne tire pas de carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ", " + joueur.get(2) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
				}
			}
		}
		
		else {
			if(carteSup.equals("y")) {
				joueur.add(deck.get(0));
				deck.remove(0);
				valeurJ=valeurJ + deckV.get(joueur.get(4));
				if(valeurJ<=11) {
					deckV.put("As de Carreau", 11);
					deckV.put("As de Trèfle", 11);
					deckV.put("As de Pique", 11);
					deckV.put("As de Coeur", 11);
					System.out.println("Le joueur tire une nouvelle carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ", " + joueur.get(2) + ", " + joueur.get(3) + ", " + joueur.get(4) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
					
				}
				else {
					System.out.println("Le joueur tire une nouvelle carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ", " + joueur.get(2) + ", " + joueur.get(3) + ", " + joueur.get(4) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
				}
			}
			else {
				if(valeurJ<=11) {
					deckV.put("As de Carreau", 11);
					deckV.put("As de Trèfle", 11);
					deckV.put("As de Pique", 11);
					deckV.put("As de Coeur", 11);
					System.out.println("Le joueur ne tire pas de carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ", " + joueur.get(2) + ", " + joueur.get(3) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
				}
				else {
					System.out.println("Le joueur ne tire pas de carte.");
					System.out.println("Main du Joueur: " + joueur.get(0) + ", " + joueur.get(1) + ", " + joueur.get(2) + ", " + joueur.get(3) + ".\n" + " Valeur des cartes: " + valeurJ + ".\n");
				}
			}
		}
		
	}while(valeurJ<15);	
	
		
		
//Bank
		do {
			if(bank.size()==2) {
				if(valeurB<=11){
					deckV.put("As de Carreau", 11);
					deckV.put("As de Trèfle", 11);
					deckV.put("As de Pique", 11);
					deckV.put("As de Coeur", 11);
					if(valeurB<15) {
						bank.add(deck.get(0));
						deck.remove(0);
						valeurB=valeurB + deckV.get(bank.get(2));
						System.out.println("La banque tire une nouvelle carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ", " + bank.get(2) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
					else {
						System.out.println("La banque ne tire pas de carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
				}
				else {
					deckV.put("As de Carreau", 1);
					deckV.put("As de Trèfle", 1);
					deckV.put("As de Pique", 1);
					deckV.put("As de Coeur", 1);
					if(valeurB<15) {
						bank.add(deck.get(0));
						deck.remove(0);
						valeurB=valeurB + deckV.get(bank.get(2));
						System.out.println("La banque tire une nouvelle carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ", " + bank.get(2) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
					else {
						System.out.println("La banque ne tire pas de carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
				}
			}
			else if(bank.size()==3) {
				if(valeurB<=11){
					deckV.put("As de Carreau", 11);
					deckV.put("As de Trèfle", 11);
					deckV.put("As de Pique", 11);
					deckV.put("As de Coeur", 11);
					if(valeurB<15) {
						bank.add(deck.get(0));
						deck.remove(0);
						valeurB=valeurB + deckV.get(bank.get(3));
						System.out.println("La banque tire une nouvelle carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ", " + bank.get(2) + ", " + bank.get(3) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
					else {
						System.out.println("La banque ne tire pas de carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ", " + bank.get(2) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
				}
				else {
					deckV.put("As de Carreau", 1);
					deckV.put("As de Trèfle", 1);
					deckV.put("As de Pique", 1);
					deckV.put("As de Coeur", 1);
					if(valeurB<15) {
						bank.add(deck.get(0));
						deck.remove(0);
						valeurB=valeurB + deckV.get(bank.get(3));
						System.out.println("La banque tire une nouvelle carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ", " + bank.get(2) + ", " + bank.get(3) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
					else {
						System.out.println("La banque ne tire pas de carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ", " + bank.get(2) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
				}
			}
			else {
				if(valeurB<=11){
					deckV.put("As de Carreau", 11);
					deckV.put("As de Trèfle", 11);
					deckV.put("As de Pique", 11);
					deckV.put("As de Coeur", 11);
					if(valeurB<15) {
						bank.add(deck.get(0));
						deck.remove(0);
						valeurB=valeurB + deckV.get(bank.get(4));
						System.out.println("La banque tire une nouvelle carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ", " + bank.get(2) + ", " + bank.get(3) + ", " + bank.get(4) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
					else {
						System.out.println("La banque ne tire pas de carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ", " + bank.get(2) + ", " + bank.get(3) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
				}
				else {
					deckV.put("As de Carreau", 1);
					deckV.put("As de Trèfle", 1);
					deckV.put("As de Pique", 1);
					deckV.put("As de Coeur", 1);
					if(valeurB<15) {
						bank.add(deck.get(0));
						deck.remove(0);
						valeurB=valeurB + deckV.get(bank.get(2));
						System.out.println("La banque tire une nouvelle carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ", " + bank.get(2) + ", " + bank.get(3) + ", " + bank.get(4) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
					else {
						System.out.println("La banque ne tire pas de carte.");
						System.out.println("Main de la Banque: " + bank.get(0) + ", " + bank.get(1) + ", " + bank.get(2) + ", " + bank.get(3) + ".\n" + " Valeur des cartes: " + valeurB + ".\n");
					}
				}
			}
		}while(valeurB<15);
		
//Victoire
		if(valeurJ>=valeurB && valeurJ<22) {
			if (valeurJ==21){
				System.out.println("!!!!! BlackJack !!!!!\n");
			}
			System.out.println("Partie terminée! Le joueur gagne avec " + valeurJ  + " points contre " + valeurB  + " points!");
		}
		else if(valeurB>valeurJ && valeurB<22) {
			System.out.println("Partie terminée! La banque gagne avec " + valeurB  + " points contre " + valeurJ  + " points!");
		}
		else if(valeurJ<=21 && valeurB>22){
			System.out.println("Partie terminée! Le joueur gagne avec " + valeurJ  + " points contre " + valeurB  + " points!");
		}
		else {
			System.out.println("Partie terminée! La banque gagne avec " + valeurB  + " points contre " + valeurJ  + " points!");
		}
		System.out.println("\nNouvelle partie?\nPress 'Y' for yes or 'N' for no.");
		Scanner nextGame = new Scanner(System.in);
		nextG = nextGame.next();
	} while (nextG.equals("y"));
	System.out.println("Jeu terminé!\nMerci d'avoir joué!\nPour faire un don, allez sur KickStarter!");
}
	
	
	

	
	public static void main(String[] args) {
		partie();

	}

}
