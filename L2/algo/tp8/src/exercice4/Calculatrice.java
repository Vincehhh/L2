package exercice4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculatrice extends JFrame {
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPlus, bMoins, bFois, bEgal, bSur, bRAZ;

	private JPanel panelBoutons;
	private JPanel panelNumerique;
	private JPanel panelOperations;

	private JTextField zoneResultat;

	private int opd1;
	private int opd2;
	private int resultat;
	private char operation;
	private boolean newOp = false;

	public Calculatrice() {
		setTitle("Ma première Calculatrice");
		setSize(300, 220);

		declarationBoutons();
		placerBoutons();
		zoneResultat = new JTextField(10);
		zoneResultat.setText("0");

		this.getContentPane().add(BorderLayout.SOUTH, panelBoutons);
		this.getContentPane().add(BorderLayout.NORTH, zoneResultat);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void declarationBoutons() {
		b0 = new JButton("0");
		b0.addActionListener(new B0Listener());
		b1 = new JButton("1");
		b1.addActionListener(new B1Listener());
		b2 = new JButton("2");
		b2.addActionListener(new B2Listener());
		b3 = new JButton("3");
		b3.addActionListener(new B3Listener());
		b4 = new JButton("4");
		b4.addActionListener(new B4Listener());
		b5 = new JButton("5");
		b5.addActionListener(new B5Listener());
		b6 = new JButton("6");
		b6.addActionListener(new B6Listener());
		b7 = new JButton("7");
		b7.addActionListener(new B7Listener());
		b8 = new JButton("8");
		b8.addActionListener(new B8Listener());
		b9 = new JButton("9");
		b9.addActionListener(new B9Listener());
		bPlus = new JButton("+");
		bPlus.addActionListener(new BPlusListener());
		bMoins = new JButton("-");
		bMoins.addActionListener(new BMoinsListener());
		bFois = new JButton("*");
		bFois.addActionListener(new BFoisListener());
		bSur = new JButton("/");
		bSur.addActionListener(new BSurListener());
		bRAZ = new JButton("C");
		bRAZ.addActionListener(new BRAZListener());
		bEgal = new JButton("=");
		bEgal.addActionListener(new BEgalListener());
	}
	public void placerBoutons() {
		panelBoutons = new JPanel();

		panelNumerique = new JPanel();
		panelNumerique.setLayout(new GridLayout(4, 3));

		panelNumerique.add(b1);
		panelNumerique.add(b2);
		panelNumerique.add(b3);
		panelNumerique.add(b4);
		panelNumerique.add(b5);
		panelNumerique.add(b6);
		panelNumerique.add(b7);
		panelNumerique.add(b8);
		panelNumerique.add(b9);
		panelNumerique.add(b0);

		panelOperations = new JPanel();
		panelOperations.setLayout(new GridLayout(5, 1));

		panelOperations.add(bPlus);
		panelOperations.add(bMoins);
		panelOperations.add(bFois);
		panelOperations.add(bSur);
		panelOperations.add(bEgal);

		// panelOperations.add(bRAZ);

		panelBoutons.setLayout(new BorderLayout());
		panelBoutons.add(BorderLayout.NORTH, bRAZ);
		panelBoutons.add(BorderLayout.WEST, panelNumerique);
		panelBoutons.add(BorderLayout.EAST, panelOperations);
	}

	// les listners des boutons
	class B0Listener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			String text = zoneResultat.getText();
			if (!text.equals("0") && !newOp)
				zoneResultat.setText(text + "0");
			else {
				zoneResultat.setText("0");
				newOp = false;
			}
		}
	}

	class B1Listener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			String text = zoneResultat.getText();
			if (!text.equals("0") && !newOp)
				zoneResultat.setText(text + "1");
			else {
				zoneResultat.setText("1");
				newOp = false;
			}
		}
	}
	class B2Listener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			String text = zoneResultat.getText();
			if (!text.equals("0") && !newOp)
				zoneResultat.setText(text + "2");
			else {
				zoneResultat.setText("2");
				newOp = false;
			}
		}
	}

	class B3Listener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			String text = zoneResultat.getText();
			if (!text.equals("0") && !newOp)
				zoneResultat.setText(text + "3");
			else {
				zoneResultat.setText("3");
				newOp = false;
			}
		}
	}

	class B4Listener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			String text = zoneResultat.getText();
			if (!text.equals("0") && !newOp)
				zoneResultat.setText(text + "4");
			else {
				zoneResultat.setText("4");
				newOp = false;
			}
		}
	}
	class B5Listener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			String text = zoneResultat.getText();
			if (!text.equals("0") && !newOp)
				zoneResultat.setText(text + "5");
			else {
				zoneResultat.setText("5");
				newOp = false;
			}
		}
	}
	class B6Listener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			String text = zoneResultat.getText();
			if (!text.equals("0") && !newOp)
				zoneResultat.setText(text + "6");
			else {
				zoneResultat.setText("6");
				newOp = false;
			}
		}
	}
	class B7Listener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			String text = zoneResultat.getText();
			if (!text.equals("0") && !newOp)
				zoneResultat.setText(text + "7");
			else {
				zoneResultat.setText("7");
				newOp = false;
			}
		}
	}
	class B8Listener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			String text = zoneResultat.getText();
			if (!text.equals("0") && !newOp)
				zoneResultat.setText(text + "8");
			else {
				zoneResultat.setText("8");
				newOp = false;
			}
		}
	}
	class B9Listener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			String text = zoneResultat.getText();
			if (!text.equals("0") && !newOp)
				zoneResultat.setText(text + "9");
			else {
				zoneResultat.setText("9");
				newOp = false;
			}
		}
	}

	class BPlusListener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			if (opd1 == 0) {
				opd1 = Integer.parseInt(zoneResultat.getText());
			}
			operation = '+';
			zoneResultat.setText("0");
		}
	}

	class BMoinsListener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			opd1 = Integer.parseInt(zoneResultat.getText());
			operation = '-';
			zoneResultat.setText("0");
		}
	}

	class BFoisListener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			opd1 = Integer.parseInt(zoneResultat.getText());
			operation = '*';
			zoneResultat.setText("0");
		}
	}

	class BSurListener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			opd1 = Integer.parseInt(zoneResultat.getText());
			operation = '/';
			zoneResultat.setText("0");
		}
	}

	class BRAZListener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			opd1 = 0;
			opd2 = 0;
			operation = ' ';
			newOp = false;
			zoneResultat.setText("0");
		}
	}

	class BEgalListener implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			opd2 = Integer.parseInt(zoneResultat.getText());
			switch (operation) {
				case '+':
					resultat = opd1 + opd2;
					break;
				case '-':
					resultat = opd1 - opd2;
					break;
				case '*':
					resultat = opd1 * opd2;
					break;
				case '/': {
					if (opd2 == 0) {
						resultat = Integer.MIN_VALUE;
					} else
						resultat = opd1 / opd2;
				} break;

				default:
					resultat = 0;
			}
			if (resultat == Integer.MIN_VALUE) {
				zoneResultat.setText("ERROR : /0");
				zoneResultat.setBackground(Color.RED);
			} else
				zoneResultat.setText(resultat + "");
			newOp = true;
		}
	}
}