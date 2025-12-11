package tp5CollectionsGenericite.partie2Genericite.exercice4GrapheGenerique;

import java.util.HashMap;
import java.util.Set;

public class Graphe<Sommet, Distance> {
	private HashMap<Sommet, HashMap<Sommet, Distance>> leGraphe;

	public Graphe() {
		this.leGraphe = new HashMap<Sommet, HashMap<Sommet, Distance>>();
	}

	public void ajouterSommet(Sommet nomS) {
		if (!leGraphe.containsKey(nomS)) {
			leGraphe.put(nomS, new HashMap<Sommet, Distance>());
		}
	}

	public void ajouterChemin(Sommet depart, Sommet arrivee, Distance distance) {
		this.ajouterSommet(depart);
		this.ajouterSommet(arrivee);

		HashMap<Sommet, Distance> sommetsArrivee = this.leGraphe.get(depart);

		if (sommetsArrivee.containsKey(arrivee))
			sommetsArrivee.replace(arrivee, distance);
		else
			sommetsArrivee.put(arrivee, distance);
	}

	public void ajouterCheminSiAbsentMAJSiExistant(
		Sommet depart, Sommet arrivee, Distance distance) {
		this.ajouterChemin(depart, arrivee, distance);
	}

	public Distance distance(Sommet depart, Sommet arrivee) {
		if (leGraphe.containsKey(depart)) {
			HashMap<Sommet, Distance> sommetsArrivee = this.leGraphe.get(depart);
			if (sommetsArrivee.containsKey(arrivee))
				return sommetsArrivee.get(arrivee);
		}
		return null;
	}

	@Override
	public String toString() {
		String graphString = "Graphe : \n";

		Set<Sommet> lesCles = this.leGraphe.keySet();

		for (Sommet cle : lesCles) {
			graphString = graphString + "{" + cle + "},{";
			boolean ajout = false;

			for (Sommet sommet : leGraphe.get(cle).keySet()) {
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
