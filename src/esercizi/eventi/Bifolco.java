package esercizi.eventi;

import javax.swing.event.EventListenerList;

public class Bifolco {
	
	String nome;
	protected EventListenerList eventList = new EventListenerList();
	
	public Bifolco(String nome) {
		super();
		this.nome = nome;
	}

	public void addPuzzettaListener(PuzzettaListener l) {
		eventList.add(PuzzettaListener.class, l);
	}
	
	public void removePuzzettaListener(PuzzettaListener l) {
		eventList.remove(PuzzettaListener.class, l);
	}
	
	protected void firePuzzettaEvent(PuzzettaEvent e) {
		PuzzettaListener list[] = eventList.getListeners(PuzzettaListener.class);
		for(PuzzettaListener ev : list) {
			ev.puzzettaSganciata(e);
		}
	}
	
	public void sgancia() {
		firePuzzettaEvent(new PuzzettaEvent(this, 100));
		
		System.out.println(this.nome + " ha fatto una puzzetta ");
	}
	public static void main(String[] args) {
		Bifolco persona0 = new Bifolco("Mario");
		persona0.addPuzzettaListener(new Naso());
		
		persona0.sgancia();
	}
}
