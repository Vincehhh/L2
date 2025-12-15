package src.model;

import java.util.Objects;

public class AxialCoordinate {
	public int q;
	public int r;
	public AxialCoordinate(int q, int r) {
		this.q = q;
		this.r = r;
	}
	public AxialCoordinate add(int dq, int dr) {
		return new AxialCoordinate(q + dq, r + dr);
	}
	public boolean isValid() {
		return Math.abs(q) <= 5 && Math.abs(r) <= 5 && Math.abs(q - r) <= 5;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AxialCoordinate coord))
			return false;
		return q == coord.q && r == coord.r;
	}
	@Override
	public int hashCode() {
		return Objects.hash(q, r);
	}
}