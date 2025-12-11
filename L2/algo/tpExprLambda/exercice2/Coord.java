package tpExprLambda.exercice2;

class Coord {
	private double x;
	private double y;
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
		return "[" + x + ", " + y + "]";
	}
}
