package tpExprLambda.exercice4;

public class Main {
	public static void main(String[] args) {
		Etudiant etudiant = new Etudiant("Turing", "Alan");

		etudiant.ajouteNote(17);
		etudiant.ajouteNote(20);
		System.out.println(etudiant.moyenne());
		etudiant.ajouteNote(19.5);
		System.out.println(etudiant.moyenne());
	}
}
