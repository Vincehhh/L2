package src.model;

public class Move {
	public AxialCoordinate from;
	public AxialCoordinate to;
	Move(AxialCoordinate from, AxialCoordinate to) {
		this.from = from;
		this.to = to;
	}
}