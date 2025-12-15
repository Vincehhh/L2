package src.ui;

import src.model.AxialCoordinate;
import src.model.Board;
import src.model.Piece;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Path2D;
import java.util.List;

class HexRenderer {
	private static final Color SANDYBROWN = new Color(232, 171, 111);
	private static final Color NAVAJOWHITE = new Color(255, 206, 158);
	private static final Color PERU = new Color(209, 139, 71);
	private static final Color LEGOYELLOW = new Color(255, 215, 0, 160);
	private static final Color GREEN = new Color(46, 218, 119, 160);
	private static final Color[] HEX_COLORS = {SANDYBROWN, NAVAJOWHITE, PERU};
	private static final int[][] HEX_NEIGHBOR_OFFSETS = {
		{-1, -1}, {0, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 0}};
	private HexGeometry geometry;
	private Board board;
	HexRenderer(HexGeometry geometry, Board board) {
		this.geometry = geometry;
		this.board = board;
	}
	private void drawPieceImage(Graphics2D g2d, int x, int y, Image img) {
		int size = (int) (geometry.getHexSize() * 1.5);
		int offset = size / 2;
		g2d.drawImage(img, x - offset, y - offset, size, size, null);
	}
	private void drawPieceFallback(Graphics2D g2d, int x, int y, Piece p) {
		int size = (int) geometry.getHexSize();
		int offset = size / 2;
		g2d.setColor(p.isWhite ? Color.WHITE : Color.BLACK);
		g2d.fillOval(x - offset, y - offset, size, size);
		g2d.setColor(p.isWhite ? Color.BLACK : Color.WHITE);
		g2d.setStroke(new BasicStroke(2));
		g2d.drawOval(x - offset, y - offset, size, size);
		g2d.setFont(g2d.getFont().deriveFont((float) (size * 0.666)));
		String label = String.valueOf(Character.toUpperCase(p.type.code));
		int textWidth = g2d.getFontMetrics().stringWidth(label);
		int textHeight = g2d.getFontMetrics().getAscent();
		g2d.drawString(label, x - textWidth / 2 + 1, y + textHeight / 3 + 1);
	}
	private void drawPiece(Graphics2D g2d, int x, int y, Piece p) {
		Image img = PieceImageLoader.get((p.isWhite ? "w" : "b") + p.type.code);
		if (img != null)
			drawPieceImage(g2d, x, y, img);
		else
			drawPieceFallback(g2d, x, y, p);
	}
	/*
	private void drawCoordinates(Graphics2D g2d, int x, int y, AxialCoordinate coord) {
		int size = (int) geometry.getHexSize();
		g2d.setColor(Color.RED);
		g2d.setFont(g2d.getFont().deriveFont((float) (size * 0.666)));
		String label = coord.q + "," + coord.r;
		int textWidth = g2d.getFontMetrics().stringWidth(label);
		int textHeight = g2d.getFontMetrics().getAscent();
		g2d.drawString(label, x - textWidth / 2, y + textHeight / 3);
	}
	*/
	void drawHex(Graphics2D g2d, int cx, int cy, AxialCoordinate coord, AxialCoordinate selected,
		List<AxialCoordinate> highlighted) {
		Point center = geometry.hexToPixel(coord.q, coord.r, cx, cy);
		Path2D hex = geometry.createHexPath(center);
		g2d.setColor(HEX_COLORS[Math.floorMod(coord.q + coord.r, 3)]);
		g2d.fill(hex);
		g2d.draw(hex);
		if (coord.equals(selected)) {
			g2d.setColor(LEGOYELLOW);
			g2d.fill(hex);
		} else if (highlighted.contains(coord)) {
			g2d.setColor(GREEN);
			g2d.fill(hex);
		}
		Piece p = board.getPiece(coord);
		if (p != null)
			drawPiece(g2d, center.x, center.y, p);
		// drawCoordinates(g2d, center.x, center.y, coord);
	}
	private void drawCellBorder(Graphics2D g2d, int cx, int cy, int q, int r) {
		AxialCoordinate coord = new AxialCoordinate(q, r);
		if (!coord.isValid())
			return;
		Point center = geometry.hexToPixel(q, r, cx, cy);
		double radius = geometry.getHexSize();
		for (int i = 0; i < 6; i++) {
			AxialCoordinate neighbor =
				new AxialCoordinate(q + HEX_NEIGHBOR_OFFSETS[i][0], r + HEX_NEIGHBOR_OFFSETS[i][1]);
			if (neighbor.isValid())
				continue;
			int v1 = (i + 4) % 6;
			int v2 = (i + 5) % 6;
			int x1 = (int) (center.x + radius * HexGeometry.HEX_COS[v1]);
			int y1 = (int) (center.y + radius * HexGeometry.HEX_SIN[v1]);
			int x2 = (int) (center.x + radius * HexGeometry.HEX_COS[v2]);
			int y2 = (int) (center.y + radius * HexGeometry.HEX_SIN[v2]);
			g2d.drawLine(x1, y1, x2, y2);
		}
	}
	void drawBoardBorder(Graphics2D g2d, int cx, int cy) {
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(3));
		for (int q = -5; q <= 5; q++)
			for (int r = -5; r <= 5; r++) drawCellBorder(g2d, cx, cy, q, r);
	}
}