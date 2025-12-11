package tp5CollectionsGenericite.partie1Collections.exercice2LaClasseEnsemble;

import java.util.ArrayList;

public class Ensemble implements Cloneable {
	private ArrayList<Integer> elements;

	public Ensemble() {
		this.elements = new ArrayList<>();
	}

	public void ajoute(int a) {
		this.elements.add(a);
	}

	public int taille() {
		return this.elements.size();
	}

	public int getElement(int i) throws IndexOutOfBoundsException {
		// if (this.elements.size() < index)
		//	return -1;
		return this.elements.get(i);
	}

	@Override
	public String toString() {
		if (this.elements.isEmpty())
			return "ensemble vide";
		return this.elements.toString();
	}

	public Ensemble union(Ensemble e) { // throws CloneNotSupportedException {
		Ensemble u = new Ensemble();

		for (int elt : this.elements) {
			if (!u.contains(elt))
				u.ajoute(elt);
		}
		// u.elements.addAll(this.elements);
		// Ensemble u = (Ensemble) this.clone();
		for (int elt : e.elements) {
			if (!u.contains(elt))
				u.ajoute(elt);
		}
		return u;
	}

	public Ensemble intersection(Ensemble e) {
		Ensemble u = new Ensemble();
		for (int elt : this.elements) {
			if (e.contains(elt) && !u.contains(elt))
				u.ajoute(elt);
		}
		return u;
	}

	public ArrayList<Integer> getElements() {
		return this.elements;
	}

	public boolean contains(int i) {
		return this.elements.contains(i);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Ensemble u = new Ensemble();
		u.elements.addAll(this.elements);
		return u;
	}
}
