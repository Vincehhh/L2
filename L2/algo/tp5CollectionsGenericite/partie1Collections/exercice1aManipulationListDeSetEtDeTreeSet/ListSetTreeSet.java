package tp5CollectionsGenericite.partie1Collections.exercice1aManipulationListDeSetEtDeTreeSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ListSetTreeSet {
	public static void main(String[] args) {
		List<Integer> listInt = new ArrayList<>();
		Set<Integer> setInt = new HashSet<>();
		TreeSet<Integer> treeSetInt = new TreeSet<>();

		System.out.print("Tirage : ");

		for (int i = 0; i < 10; i++) {
			int tirage = (int) (10 * Math.random());
			System.out.print(tirage + ", ");
			listInt.add(tirage);
			setInt.add(tirage);
			treeSetInt.add(tirage);

			/*System.out.println("\nList : " + listInt.toString());
			System.out.println("Set : " + setInt.toString());
			System.out.println("TreeSet : " + treeSetInt.toString());*/
		}

		System.out.println("\nList : " + listInt.toString());
		System.out.println("Set : " + setInt.toString());
		System.out.println("TreeSet : " + treeSetInt.toString());
	}
}
