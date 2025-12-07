package exercice3;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Fenetre extends JFrame // implements ActionListener
{
	private JButton boutonEncore = new JButton("Encore ?");
	private JButton boutonStop = new JButton("Stop ?");
	private Fenetre fen;

	public Fenetre(String s) {
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		// boutonEncore.addActionListener(this);
		boutonEncore.addActionListener(new NewButtonListener());
		// boutonStop.addActionListener(this);
		boutonStop.addActionListener(new CloseButtonListener(this));
		getContentPane().add(boutonEncore);
		getContentPane().add(boutonStop);

		pack();
	}
	/* si on implemente les listener dans la même classe
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonEncore) {
			fen = new Fenetre("Question");
			fen.setVisible(true);
		} else
			dispose();
	}
	*/
}

// si on implemente une classe listener par bouton
class CloseButtonListener implements ActionListener {
	private JFrame frame;

	public CloseButtonListener(JFrame f) {
		frame = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.dispose();
	}
}

class NewButtonListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Fenetre fen = new Fenetre("Question");
		fen.setVisible(true);
	}
}