package tp5CollectionsGenericite.partie1Collections.exercice3bManipulationDesMapsLaClasseGraphe;

import java.util.HashMap;
import java.util.Set;

public class GraphePondere {
	private HashMap<String, HashMap<String, Integer>> leGraphe;

	public GraphePondere() {
		this.leGraphe = new HashMap<String, HashMap<String, Integer>>();
	}

	public void ajouterSommet(String sommet) {
		if (!leGraphe.containsKey(sommet)) {
			leGraphe.put(sommet, new HashMap<String, Integer>());
		}
	}

	public void ajouterChemin(String depart, String arrivee, int poids) {
		this.ajouterSommet(depart);
		this.ajouterSommet(arrivee);

		HashMap<String, Integer> sommetsArrivee = this.leGraphe.get(depart);

		if (sommetsArrivee.containsKey(arrivee))
			sommetsArrivee.replace(arrivee, poids);
		else
			sommetsArrivee.put(arrivee, poids);
	}

	public void ajouterCheminSiAbsentMAJSiExistant(String depart, String arrivee, int distance) {
		this.ajouterChemin(depart, arrivee, distance);
	}

	public int distance(String depart, String arrivee) {
		if (leGraphe.containsKey(depart)) {
			HashMap<String, Integer> sommetsArrivee = this.leGraphe.get(depart);
			if (sommetsArrivee.containsKey(arrivee))
				return sommetsArrivee.get(arrivee);
		}
		return -1;
	}

	@Override
	public String toString() {
		String graphString = "Graphe : \n";

		Set<String> lesCles = this.leGraphe.keySet();

		for (String cle : lesCles) {
			graphString = graphString + "{" + cle + "},{";
			boolean ajout = false;

			for (String sommet : leGraphe.get(cle).keySet()) {
				graphString =
					graphString + "(" + sommet + "," + leGraphe.get(cle).get(sommet) + "),";
				ajout = true;
			}

			if (ajout)
				graphString = graphString.substring(0, graphString.lastIndexOf(","));

			graphString = graphString + "}\n";
		}

		return graphString;
	}
}
