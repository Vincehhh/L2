package tp5CollectionsGenericite.partie2Genericite.exercice1Triplet;

public class Triplet<T> {
	private T premier;
	private T deuxieme;
	private T troisieme;

	public Triplet(T p, T d, T t) {
		this.premier = p;
		this.deuxieme = d;
		this.troisieme = t;
	}

	public T getPremier() {
		return premier;
	}

	public T getDeuxieme() {
		return deuxieme;
	}

	public T getTroisieme() {
		return troisieme;
	}

	public void affiche() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Triplet [premier=" + premier + ", deuxieme=" + deuxieme + ", troisieme=" + troisieme
			+ "]";
	}
}
