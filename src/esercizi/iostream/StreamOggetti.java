package esercizi.iostream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StreamOggetti {
	
	public static final String FILE = "data/oggetto.bin";
	
	public static class Oggetto implements Serializable {
		private static final long serialVersionUID = 4810277243453662716L;
		public String a;
		public String b;
		public Oggetto(String a, String b) {
			super();
			this.a = a;
			this.b = b;
		}
	}
	public static void main(String[] args) {
		System.out.println("Avvio programma StreamOggetti.");
		File f = new File(FILE);
		ObjectOutputStream out = null;
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			Oggetto o = new Oggetto("Lorenzo", "Gandino");
			Oggetto o2 = new Oggetto("Davide", "Cera");
			out = new ObjectOutputStream(new FileOutputStream(f));
			System.out.println("Scrittura oggetto.");
			out.writeObject(o);
			out.writeObject(o2);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					return;
				};
		}
	}
}
