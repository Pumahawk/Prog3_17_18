package esercizi.iostream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComposInput {
	/*
	 * Legge i dati da stdin sfruttando la composizione di oggetti Read
	 * (BufferedReader(InputStreamReader)).
	 */
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Input: ");
			String stringa = in.readLine();
			System.out.println("Out: " + stringa);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
