package esercizi.gui.infofile;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class InfoFile extends JFrame {
	private static final long serialVersionUID = 4253708743409209108L;
	
	JPanel panel;
	JPanel listFile;
	JPanel infoFile;
	String[] data;
	JLabel info = new JLabel();
	
	JList<String> list;

	public InfoFile() throws HeadlessException {
		super("InfoFile");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		listFile = new JPanel();
		infoFile = new JPanel();
		BorderLayout ly = new BorderLayout();
		panel.setLayout(ly);
		
		setListFile();
		setInfoFile();
		
		infoFile.add(info);
		panel.add(listFile, BorderLayout.WEST);
		panel.add(infoFile, BorderLayout.EAST);
		add(panel);
		pack();
	}

	private void setListFile() {
		data = new String[2];
		data[0] = "Test";
		data[1] = "Test1";
		list = new JList<String>(data);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);

		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 400));
		this.listFile.add(listScroller);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
		        @SuppressWarnings("unchecked")
				JList<String> list = (JList<String>)evt.getSource();
		        int index = list.locationToIndex(evt.getPoint());
		        System.out.println(data[index]);
		        setInfoFile(data[index]);
		    }
		});
		
	}
	
	private void setInfoFile(String info) {
		//this.infoFile.removeAll();
		this.info.setText(info);
		this.infoFile.setPreferredSize(new Dimension(250, 400));
		this.validate();
	}
	private void setInfoFile() {
		this.infoFile.add(this.info);
		setInfoFile(" ");
	}

	public static void main(String[] args) {
		new InfoFile().setVisible(true);
	}
	
}
