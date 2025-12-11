package tpExprLambda.exercice1;

import java.util.ArrayList;
import java.util.function.Function;

public class MaListe {
	private ArrayList<Coord> liste = new ArrayList<Coord>();

	public void add(Coord c) {
		liste.add(c);
	}

	// sans expr lambda...
	public void afficher1() {
		for (Coord c : liste) {
			System.out.println(c.getX() + "-" + c.getY());
		}
	}

	// RAPPEL
	// Expression lambda permet d'encapsuler un traitement pour etre passe
	// a d'autres traitements
	// "Raccourci" syntaxique aux classes anonymes internes pour une interface
	// qui ne possede ###qu'une seule methode abstraite###
	///(-> interface fonctionnelle)
	// java.util.function
	// propose des interfaces fonctionnelles "courante"
	// Interface Function : une fonction unaire qui permet de realiser une "transformation"
	// Attend un ou plusieurs parametres et renvoie une valeur
	// methode : apply()
	// Interface Consumer : une fonction qui permet de realiser une action.
	// Ne renvoie pas de valeur et attend un ou plusieurs parametres
	// methode: accept()
	// Interface Predicate : une fonction qui attend un ou plusieurs parametres
	// et renvoie un booleen
	// methode : test()
	// Supplier : une fonction qui renvoie une instance.
	// Pas de parametres, renvoie une valeur.
	// methode: get()

	// Function : fonction unaire
	// Permet de realiser une "transformation"
	// Attend un ou plusieurs parametres et renvoie une valeur
	// -> Methode: apply()
	public void afficher(Function<Coord, String> f) {
		// => f represente la fonction qui utilise
		// des types generiques
		// <Coord, String> represente les 2
		//"parametres" (Coord en entree, String retourne)
		for (Coord c : liste) {
			System.out.println(f.apply(c));
		}
	}
}
