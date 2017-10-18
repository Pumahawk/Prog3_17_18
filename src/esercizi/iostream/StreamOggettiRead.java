package esercizi.iostream;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import esercizi.iostream.StreamOggetti.Oggetto;

public class StreamOggettiRead {
	public static void main(String[] args) {
		System.out.println("Avvio programma StreamOggettiRead.");
		File f = new File(StreamOggetti.FILE);
		ObjectInputStream in = null;
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			Oggetto o;
			in = new ObjectInputStream(new FileInputStream(f));
			System.out.println("Inizio lettura oggetti.");
			try {
				for(int i = 0;;i++) {
					o = (Oggetto) in.readObject();
					System.out.println(i + ": " + o.a + ", " + o.b);
				}
			} catch (EOFException e) {}
			System.out.println("Fine lettura oggetti.");
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			if(in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					return;
				};
		}
	}
}
