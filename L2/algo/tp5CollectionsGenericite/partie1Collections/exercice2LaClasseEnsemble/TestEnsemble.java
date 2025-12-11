package tp5CollectionsGenericite.partie1Collections.exercice2LaClasseEnsemble;

public class TestEnsemble {
	public static void main(String[] args) {
		Ensemble A = new Ensemble();
		Ensemble B = new Ensemble();
		Ensemble C = new Ensemble();
		A.ajoute(1);
		A.ajoute(2);
		A.ajoute(3);
		B.ajoute(3);
		B.ajoute(5);
		B.ajoute(7);
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
		// try {
		C = A.union(B);
		// } catch (CloneNotSupportedException exception) {
		// }
		System.out.println("union de A et B = " + C);
		Ensemble D = new Ensemble();
		D = A.intersection(B);
		System.out.println("intersection de A et B = " + D);
	}
}
