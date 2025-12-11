package tpExprLambda.exercice1;

public class Main {
	private static int i = 0;
	private int k = 0;

	public static void main(String[] args) {
		MaListe l = new MaListe();

		l.add(new Coord(3, 2));
		l.add(new Coord(1, 4));
		l.add(new Coord(2, 5));

		// Q1
		l.afficher(w -> "Coordonnees " + w.getX() + ", " + w.getY());
		// ou autre formatage pour l'affichage...
		// avec la meme fonction afficher de MaListe...
		l.afficher(w -> "Coord " + w.getX() + "--" + w.getY());

		// Q2 essai 1 -> probleme
		/*
		l.afficher(w -> {
			int j = 0;
			j = j + 1;
			return j + ". Coordonnees " + w.getX() + ", " + w.getY();
		});
		*/

		// Q2 essai 2 -> probleme
		/*
		k = 0;
		l.afficher(w -> {
			k = k + 1;
			return k + ". Coordonnees " + w.getX() + ", " + w.getY();
		});
		*/

		// Q2
		i = 0;
		l.afficher(w -> {
			i = i + 1;
			return i + ". Coordonnees " + w.getX() + ", " + w.getY();
		});
	}
}
