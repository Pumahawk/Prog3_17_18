package esercizi.iostream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EsFileScanner {
	
	static final String FILE = "data/data.txt";
	/*
	 * Semplicemente stampa il contenuto di un file utilizzando
	 * la classe Scanner.
	 * 
	 */
	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new File(FILE));
			String data;
			while (in.hasNextLine()) {
				data = in.nextLine();
				System.out.println(data);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Impossibile aprire il file: " + FILE);
			e.printStackTrace();
		}
	}

}
