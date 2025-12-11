package tp5CollectionsGenericite.partie2Genericite.exercice1Triplet;

import java.util.ArrayList;

public class TestTriplet {
	public static void main(String[] args) {
		Triplet<Integer> tripletEntier = new Triplet<>(1, 5, 25);

		System.out.println("Triplet d'entiers : " + tripletEntier);

		Triplet<String> tripletString = new Triplet<>("Un", "Deux", "Trois");

		System.out.println("Triplet de chaine de caractères : " + tripletString);

		ArrayList<String> testTab = new ArrayList<>();

		testTab.add("un");
		testTab.add("deux");

		System.out.println(testTab);
	}
}
