package exercice2;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class fenetreLitEntier extends JFrame implements ActionListener {
	private JLabel text = new JLabel("Entrez un nombre entier");
	private JTextField field = new JTextField(15);
	private String str;

	public fenetreLitEntier(String s) {
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
			Integer.parseInt(str);
			str += " est un entier !";
		} catch (NumberFormatException exception) {
			str += " n'est pas un entier !";
		}
		dispose();
		JOptionPane.showMessageDialog(null, str);
	}
}