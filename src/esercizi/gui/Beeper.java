package esercizi.gui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Beeper extends JFrame implements ActionListener{
	private static final long serialVersionUID = -5676419148653260081L;

	JButton button;
	JPanel panel;
	
	
	public Beeper() throws HeadlessException {
		super("Beeper");
		button = new JButton("CLick me!");
		panel = new JPanel();
		panel.add(button);
		add(panel);
		pack();
		button.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Beep!");
		
	}

	public static void main(String[] args) {
		new Beeper().setVisible(true);
	}

}
