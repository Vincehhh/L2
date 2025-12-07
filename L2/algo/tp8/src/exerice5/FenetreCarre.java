package exerice5;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FenetreCarre extends JFrame implements ActionListener {
	private JTextField tab[][];
	private JLabel tab2[];
	private int n;

	public FenetreCarre(String s, int n) {
		super(s);
		this.n = n;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(n + 2, n + 1));

		tab = new JTextField[n][n];
		tab2 = new JLabel[2 * n + 2];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) tab[i][j] = new JTextField("0", 3);

		for (int i = 0; i < 2 * n + 2; i++) tab2[i] = new JLabel("0");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) getContentPane().add(tab[i][j]);
			getContentPane().add(tab2[i]);
		}
		for (int j = n; j < 2 * n + 2; j++) getContentPane().add(tab2[j]);

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) tab[i][j].addActionListener(this);

		pack();
	}
	public void actionPerformed(ActionEvent e) {
		// somme de chaque ligne
		int somme;
		for (int i = 0; i < n; i++) {
			somme = 0;
			for (int j = 0; j < n; j++) somme += Integer.parseInt(tab[i][j].getText());
			tab2[i].setText("" + somme);
		}

		// somme de chaque colonne
		for (int i = 0; i < n; i++) {
			somme = 0;
			for (int j = 0; j < n; j++) somme += Integer.parseInt(tab[j][i].getText());
			tab2[n + i].setText("" + somme);
		}

		// somme diagonale
		somme = 0;
		for (int i = 0; i < n; i++) somme += Integer.parseInt(tab[i][i].getText());
		tab2[2 * n].setText("" + somme);

		// somme antidiagonale
		somme = 0;
		for (int i = 0; i < n; i++) somme += Integer.parseInt(tab[i][n - 1 - i].getText());
		tab2[2 * n + 1].setText("" + somme);
	}
}