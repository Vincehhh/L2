package tpExprLambda.exercice5;

import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Etudiant etudiants[] = {new Etudiant("Codd", "Edgar", 18, 17, 18),
			new Etudiant("Backus", "John", 18, 17.5, 19),
			new Etudiant("Nygaard", "Kristen", 16, 20, 19),
			new Etudiant("Naur", "Peter", 18, 20, 17),
			new Etudiant("Turing", "Alan", 20, 20, 20)};

		// Test moyenne
		Stream.of(etudiants).forEach(
			e -> System.out.println(e.getNom() + " " + e.getPrenom() + " " + e.moyenne()));
		Stream.of(etudiants).forEach(
			e -> System.out.println(e.getNom() + " " + e.getPrenom() + " " + e.moyenne2()));

		// Question 1
		System.out.println("##Q1v1##");
		Stream.of(etudiants)
			.sorted((e1, e2) -> {
				if (e1.moyenne() < e2.moyenne())
					return 1;
				else
					return -1;
			})
			.forEach(e -> System.out.println(e));
		// idem avec moyenne2...
		Stream.of(etudiants)
			.sorted((e1, e2) -> {
				if (e1.moyenne2() < e2.moyenne2())
					return 1;
				else
					return -1;
			})
			.forEach(e -> System.out.println(e));
		// ou
		System.out.println("##Q1v2##");
		Stream.of(etudiants)
			.sorted(Comparator.comparing(e -> - e.moyenne()))
			.forEach(e -> System.out.println(e));

		// Question 2
		System.out.println("##Q2##");
		Stream.of(etudiants)
			.sorted((e1, e2) -> {
				if (e1.moyenne() < e2.moyenne())
					return 1;
				else
					return -1;
			})
			.limit(3)
			.forEach(System.out::println);

		// Question 3
		System.out.println("##Q3##");
		//
		// map(Function) : applique la Function fournie en parametre
		// pour transformer l'element en creant un nouveau element
		// flatMap(Function) : applique la Function fournie en parametre
		// pour transformer l'element en un flux de zero, un ou plusieurs elements
		OptionalDouble moyenne =
			Stream.of(etudiants).flatMap(x -> x.notesAsStream()).mapToDouble(x -> x).average();
		if (moyenne.isPresent()) {
			// moyenne est un OptionalDouble car pas de orelse... ci dessus
			// ispresent() est une methode
			System.out.println("La moyenne generale est " + moyenne.getAsDouble());
		}
	}
}
