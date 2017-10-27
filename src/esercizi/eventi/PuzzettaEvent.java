package esercizi.eventi;

import java.util.EventObject;

public class PuzzettaEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	protected int livelloTossicita;
	
	public PuzzettaEvent(Object arg0, int livelloTossicita) {
		super(arg0);
		this.livelloTossicita = livelloTossicita;
	}

}
