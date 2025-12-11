package tp5CollectionsGenericite.partie2Genericite.exercice4GrapheGenerique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GrapheNonPondereGenerique<Sommet> {
	private HashMap<Sommet, List<Sommet>> leGraphe;

	public GrapheNonPondereGenerique() {
		this.leGraphe = new HashMap<Sommet, List<Sommet>>();
	}

	public void ajouterSommet(Sommet sommet) {
		if (!leGraphe.containsKey(sommet)) {
			leGraphe.put(sommet, new ArrayList<Sommet>());
		}
	}

	public void ajouterChemin(Sommet depart, Sommet arrivee) {
		this.ajouterSommet(depart);
		this.ajouterSommet(arrivee);

		List<Sommet> sommetsArrivee = this.leGraphe.get(depart);
		if (!sommetsArrivee.contains(depart))
			sommetsArrivee.add(arrivee);
	}

	@Override
	public String toString() {
		String graphString = "Graphe : \n";

		Set<Sommet> lesCles = this.leGraphe.keySet();

		for (Sommet cle : lesCles) {
			graphString = graphString + "{" + cle + "},{";
			boolean ajout = false;
			for (Sommet sommet : leGraphe.get(cle)) {
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
