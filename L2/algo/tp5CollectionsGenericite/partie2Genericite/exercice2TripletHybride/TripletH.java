package tp5CollectionsGenericite.partie2Genericite.exercice2TripletHybride;

public class TripletH<P, D, T> {
	private P premier;
	private D deuxieme;
	private T troisieme;

	public TripletH(P premier, D deuxieme, T troisieme) {
		this.premier = premier;
		this.deuxieme = deuxieme;
		this.troisieme = troisieme;
	}

	/**
	 * @return the premier
	 */
	public P getPremier() {
		return premier;
	}

	/**
	 * @return the deuxieme
	 */
	public D getDeuxieme() {
		return deuxieme;
	}

	/**
	 * @return the troisieme
	 */
	public T getTroisieme() {
		return troisieme;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TripletH [premier=" + premier + ", deuxieme=" + deuxieme
			+ ", troisieme=" + troisieme + "]";
	}
}
