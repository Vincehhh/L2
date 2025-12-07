package exerice5;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FenetreLitEntier extends JFrame implements ActionListener {
	private JLabel text = new JLabel("Entrez un nombre entier");
	private JTextField field = new JTextField(15);
	private String str;
	private static int n;

	public FenetreLitEntier(String s) {
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(text);
		getContentPane().add(field);
		field.addActionListener(this);
		pack();
	}
	public void actionPerformed(ActionEvent e) {
		str = field.getText();
		try {
			n = Integer.parseInt(str);
			if (n % 2 == 0) {
				str += " n'est pas un entier impair !";
				JOptionPane.showMessageDialog(null, str);
				return;
			}
			dispose();
			FenetreCarre fen2 = new FenetreCarre("Carré Magique", FenetreLitEntier.n);
			fen2.setVisible(true);
		} catch (NumberFormatException exception) {
			str += " n'est pas un entier !";
			JOptionPane.showMessageDialog(null, str);
		}
	}
}