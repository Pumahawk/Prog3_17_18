package esercizi.iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EsFileReader {
	
	static final String FILE = "data/data.txt";
	/*
	 * Semplicemente stampa il contenuto di un file utilizzando
	 * la classe FileReader.
	 * 
	 */
	public static void main(String[] args) {
		FileReader in;
		try {
			in = new FileReader(FILE);
			int data;
			try {
				while ((data = in.read()) != -1) {
					System.out.print((char)data);
				}
				in.close();
			} catch (IOException e) {
				System.out.println("Errore IO");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Impossibile aprire il file: " + FILE);
			e.printStackTrace();
		}
	}

}
