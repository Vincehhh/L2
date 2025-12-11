package tp5CollectionsGenericite.partie1Collections.exercice3bManipulationDesMapsLaClasseGraphe;
// import tp5CollectionsGenericite.partie2Genericite.exercice4GrapheGenerique.Graphe;

public class TestGraphePondere {
	public static void main(String[] args) {
		// Graphe<String, Integer> gP = new Graphe<>();
		GraphePondere gP = new GraphePondere();

		System.out.println(gP);

		System.out.println("Ajout du sommet A");

		gP.ajouterSommet("A");

		System.out.println(gP);

		System.out.println("Ajout du chemin A-B avec poids 2");

		gP.ajouterChemin("A", "B", 1);
		gP.ajouterChemin("A", "D", 4);
		gP.ajouterChemin("C", "A", 2);
		gP.ajouterChemin("B", "C", 3);
		System.out.println(gP);
	}
}
