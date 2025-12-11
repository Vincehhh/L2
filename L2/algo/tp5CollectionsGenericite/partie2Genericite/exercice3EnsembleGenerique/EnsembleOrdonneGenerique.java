package tp5CollectionsGenericite.partie2Genericite.exercice3EnsembleGenerique;

import java.util.TreeSet;

public class EnsembleOrdonneGenerique<E extends Comparable<E>> {
	private TreeSet<E> elements;

	public EnsembleOrdonneGenerique() {
		this.elements = new TreeSet<>();
	}

	public void ajoute(E a) {
		this.elements.add(a);
	}

	public int taille() {
		return this.elements.size();
	}

	/*public E getElement(int index) throws IndexOutOfBoundsException {
		return this.elements.get(index);
	}*/

	public EnsembleOrdonneGenerique<E> union(EnsembleOrdonneGenerique<E> e)
		throws CloneNotSupportedException {
		EnsembleOrdonneGenerique<E> u = new EnsembleOrdonneGenerique<>();
		u.elements.addAll(this.elements);
		u.elements.addAll(e.elements);

		return u;
	}

	public EnsembleOrdonneGenerique<E> intersection(EnsembleOrdonneGenerique<E> e) {
		EnsembleOrdonneGenerique<E> u = new EnsembleOrdonneGenerique<>();
		for (E elt : this.elements) {
			if (e.contains(elt))
				u.ajoute(elt);
		}
		return u;
	}

	public boolean contains(E elt) {
		return this.elements.contains(elt);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		EnsembleOrdonneGenerique<E> u = new EnsembleOrdonneGenerique<>();
		u.elements.addAll(this.elements);
		return u;
	}

	@Override
	public String toString() {
		return this.elements.toString();
	}
}
