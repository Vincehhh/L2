package tp5CollectionsGenericite.partie1Collections.exercice3aManipulationDesMapsLaClasseGraphe;
// import
// tp5CollectionsGenericite.partie2Genericite.exercice4GrapheGenerique.GrapheNonPondereGenerique;

public class TestGrapheNonPondere {
	public static void main(String[] args) {
		// GrapheNonPondereGenerique<String> gNP = new GrapheNonPondereGenerique<>();
		GrapheNonPondere gNP = new GrapheNonPondere();

		System.out.println(gNP);

		System.out.println("Ajout du sommet A");

		gNP.ajouterSommet("A");

		System.out.println(gNP);

		System.out.println("Ajout du chemin A-B");

		gNP.ajouterChemin("A", "B");
		gNP.ajouterChemin("A", "D");
		gNP.ajouterChemin("C", "A");
		gNP.ajouterChemin("B", "C");
		System.out.println(gNP);
	}
}
