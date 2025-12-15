package src.model;

public enum PieceType {
	KING(200, 'k'),
	QUEEN(9, 'q'),
	ROOK(5, 'r'),
	BISHOP(3, 'b'),
	KNIGHT(3, 'n'),
	PAWN(1, 'p');
	public int value;
	public char code;
	PieceType(int value, char code) {
		this.value = value;
		this.code = code;
	}
}