package esercizi.thread;

import java.io.IOException;
import java.io.Writer;

public class Stampante {
	protected Writer writer;
	protected boolean free;

	public Stampante(Writer writer) {
		super();
		this.writer = writer;
		this.free = true;
	}
	
	public synchronized void stampa(String s) {
		
		while(!free) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.free = false;
		
		try {
			writer.write(s.toCharArray());
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Impossibile stampare: " + s);
		}
		this.free = true;
		notifyAll();
	}
	
}
