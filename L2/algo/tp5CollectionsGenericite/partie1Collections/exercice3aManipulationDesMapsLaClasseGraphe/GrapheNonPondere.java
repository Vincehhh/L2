package tp5CollectionsGenericite.partie1Collections.exercice3aManipulationDesMapsLaClasseGraphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GrapheNonPondere {
	private Map<String, List<String>> leGraphe;

	public GrapheNonPondere() {
		this.leGraphe = new HashMap<>();
	}

	public void ajouterSommet(String sommet) {
		if (!leGraphe.containsKey(sommet)) {
			leGraphe.put(sommet, new ArrayList<String>());
		}
	}

	public void ajouterChemin(String depart, String arrivee) {
		this.ajouterSommet(depart);
		this.ajouterSommet(arrivee);

		List<String> sommetsArrivee = this.leGraphe.get(depart);

		if (!sommetsArrivee.contains(arrivee))
			sommetsArrivee.add(arrivee);
	}

	@Override
	public String toString() {
		String graphString = "Graphe : \n";

		Set<String> lesCles = this.leGraphe.keySet();

		for (String cle : lesCles) {
			graphString = graphString + "{" + cle + "},{";
			boolean ajout = false;
			for (String sommet : leGraphe.get(cle)) {
				graphString = graphString + sommet + ",";
				ajout = true;
			}
			if (ajout)
				graphString = graphString.substring(0, graphString.lastIndexOf(","));

			graphString = graphString + "}\n";
		}

		return graphString;
	}
}
