package src.ui;

import src.model.AI;
import src.model.AxialCoordinate;
import src.model.Board;
import src.model.Move;
import src.model.Piece;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class HexPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Board board;
	private AI ai = new AI();
	private HexGeometry geometry = new HexGeometry(32);
	private HexRenderer renderer;
	private AxialCoordinate selected;
	private List<AxialCoordinate> highlighted = new ArrayList<>();
	public HexPanel(Board board) {
		this.board = board;
		this.renderer = new HexRenderer(geometry, board);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(666, 666));
		PieceImageLoader.loadImages();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				handleMouseClick(event.getX(), event.getY());
			}
		});
	}
	private void drawBoard(Graphics2D g2d, int cx, int cy) {
		for (int q = -5; q <= 5; q++)
			for (int r = -5; r <= 5; r++) {
				AxialCoordinate coord = new AxialCoordinate(q, r);
				if (coord.isValid())
					renderer.drawHex(g2d, cx, cy, coord, selected, highlighted);
			}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int cx = getWidth() / 2;
		int cy = getHeight() / 2;
		drawBoard(g2d, cx, cy);
		renderer.drawBoardBorder(g2d, cx, cy);
	}
	private void deselect() {
		selected = null;
		highlighted.clear();
		repaint();
	}
	private void executeMove(AxialCoordinate target) {
		board.movePiece(selected, target);
		deselect();
		Move bestMove = ai.getBestMove(board);
		if (bestMove != null)
			board.movePiece(bestMove.from, bestMove.to);
	}
	private void selectPiece(AxialCoordinate coord) {
		selected = coord;
		highlighted.clear();
		for (Move m : board.listMoves(board.isWhiteTurn))
			if (m.from.equals(coord))
				highlighted.add(m.to);
		repaint();
	}
	private void handleMouseClick(int x, int y) {
		int cx = getWidth() / 2;
		int cy = getHeight() / 2;
		AxialCoordinate clicked = geometry.pixelToHex(x, y, cx, cy);
		if (!clicked.isValid()) {
			deselect();
			return;
		}
		if (selected != null && highlighted.contains(clicked)) {
			executeMove(clicked);
			return;
		}
		Piece p = board.getPiece(clicked);
		if (p != null && p.isWhite == board.isWhiteTurn)
			selectPiece(clicked);
		else
			deselect();
	}
}