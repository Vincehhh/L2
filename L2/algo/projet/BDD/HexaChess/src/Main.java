package src;

import src.model.Board;
import src.ui.HexPanel;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new HexPanel(board));
		frame.pack();
		frame.setVisible(true);
	}
}