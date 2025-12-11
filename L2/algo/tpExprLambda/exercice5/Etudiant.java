package tpExprLambda.exercice5;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Etudiant {
	private String nom;
	private String prenom;
	private double[] notes;

	Etudiant(String nom, String prenom, double... notes) {
		this.nom = nom;
		this.prenom = prenom;
		this.notes = notes;
	}
	/* Ex4
	double moyenne() {
		return notes.stream().mapToDouble(x -> x).average().orElse(0);
	}
	*/
	double moyenne() {
		return DoubleStream.of(notes).average().orElse(0);
	}
	// ou comme Ex2 on transforme le tableau notes [] en Arrays puis
	// on fait la moy de chaque elet
	double moyenne2() {
		return Arrays.stream(notes).average().orElse(0);
	}

	Stream<Double> notesAsStream() {
		// boxed() permet de transformer un Stream primitif
		// en Stream<T> avec T un Integer, un Long ou un Double
		return Arrays.stream(notes).boxed();
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

	public double[] getNotes() {
		return notes;
	}

	public void setNotes(double[] notes) {
		this.notes = notes;
	}

	public String toString() {
		return nom + " " + prenom;
	}
}
