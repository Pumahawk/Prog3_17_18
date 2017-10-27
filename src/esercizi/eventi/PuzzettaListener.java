package esercizi.eventi;

import java.util.EventListener;

public interface PuzzettaListener extends EventListener {
	public void puzzettaSganciata(PuzzettaEvent e);
}
