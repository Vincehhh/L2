package tpExprLambda.exercice3;

class Coord {
	private double x;
	private double y;

	static int i = 0;

	Coord(double x, double y) {
		this.x = x;
		this.y = y;
	}
	double getX() {
		return x;
	}
	double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		Coord c = (Coord) obj;
		System.out.println("-> Appel de equals entre " + this.toString() + " et " + c.toString());
		System.out.println("************************");
		System.out.println(c.x == this.x && c.y == this.y);
		return c.x == this.x && c.y == this.y;
	}

	@Override
	public int hashCode() {
		System.out.println("-> Appel de hashCode sur " + this.toString());
		System.out.println("************************");
		System.out.println(this.x + this.y * 31);
		// hashCode cours...
		// return (int) (this.x + this.y * 31);

		// hashCode constant ;
		// System.out.println(0);
		// return 0;

		// hashCode toujours different
		return i++;
	}
}
