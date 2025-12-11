package tpExprLambda.exercice4;

import java.util.ArrayList;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Etudiant {
	private String nom;
	private String prenom;
	private ArrayList<Double> notes;

	Etudiant(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		notes = new ArrayList<Double>();
	}

	public void ajouteNote(double note) {
		notes.add(note);
	}

	public double moyenne2() { // a l'ancienne, non demande...
		double moy = 0;
		if (this.notes.size() > 0) {
			for (double n : this.notes) {
				moy += n;
			}
			moy = moy / this.notes.size();
		}
		return moy;
	}

	double moyenne() {
		return notes.stream().mapToDouble(x -> x).average().orElse(0);
		// on retourne soit :
		// la moyenne (average) du DoubleStream
		// notes.stream().mapToDouble(x -> x).average()
		// soit 0
		///.orElse(0)
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
