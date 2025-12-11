package tp5CollectionsGenericite.partie2Genericite.exercice3EnsembleGenerique;

import java.util.ArrayList;

public class EnsembleGenerique<T> implements Cloneable {
	private ArrayList<T> elements;

	public EnsembleGenerique() {
		this.elements = new ArrayList<>();
	}

	public void ajoute(T a) {
		this.elements.add(a);
	}

	public int taille() {
		return this.elements.size();
	}

	public T getElement(int i) throws IndexOutOfBoundsException {
		return this.elements.get(i);
	}

	@Override
	public String toString() {
		if (this.elements.isEmpty())
			return "ensemble vide";
		return this.elements.toString();
	}

	public ArrayList<T> getElements() {
		return this.elements;
	}

	public EnsembleGenerique<T> union(EnsembleGenerique<T> e) throws CloneNotSupportedException {
		EnsembleGenerique<T> u = new EnsembleGenerique<>();
		u.elements.addAll(this.elements);
		u.elements.addAll(e.elements);

		return u;
	}

	public EnsembleGenerique<T> intersection(EnsembleGenerique<T> e) {
		EnsembleGenerique<T> u = new EnsembleGenerique<>();
		for (T elt : this.elements) {
			if (e.contains(elt))
				u.ajoute(elt);
		}
		return u;
	}

	public boolean contains(T i) {
		return this.elements.contains(i);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		EnsembleGenerique<T> u = new EnsembleGenerique<>();
		u.elements.addAll(this.elements);
		return u;
	}
}
