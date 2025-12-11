package tp5CollectionsGenericite.partie2Genericite.exercice2TripletHybride;

public class TestTripletHybride {
	public static void main(String[] args) {
		TripletH<Integer, Integer, String> tripletEntier = new TripletH<>(1, 5, "Vingt Cinq");

		System.out.println("Triplet d'entiers : " + tripletEntier);

		TripletH<String, String, String> tripletString = new TripletH<>("Un", "Deux", "Trois");

		System.out.println("Triplet de chaine de caractères : " + tripletString);
	}
}
