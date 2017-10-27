package esercizi.eventi;

public class Naso implements PuzzettaListener {

	@Override
	public void puzzettaSganciata(PuzzettaEvent e) {
		System.out.println("Che schifo! Tossicità: " + e.livelloTossicita);
	}

}
