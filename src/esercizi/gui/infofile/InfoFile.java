package esercizi.gui.infofile;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class InfoFile extends JFrame {
	private static final long serialVersionUID = 4253708743409209108L;
	
	DefaultListModel<String> listFile = new DefaultListModel<>();
	
	public InfoFile() {
		setLayout(new GridLayout(1,2));
		setSize(200, 200);
		
		JList<String> list = new JList<>(listFile);
		list.setLayoutOrientation(JList.VERTICAL);

		listFile.addElement("TEST0");
		listFile.addElement("TEST1");
		listFile.addElement("TEST2");

		JPanel sinistra = new JPanel();
		JPanel destra = new JPanel();

		sinistra.setLayout(new GridLayout(1,1));
		destra.setLayout(new GridLayout(1,1));
		
		sinistra.add(list);
		
		add(sinistra);
		add(destra);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		(new InfoFile()).setVisible(true);
	}
	
}
