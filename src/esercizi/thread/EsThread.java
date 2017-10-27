package esercizi.thread;

import java.io.OutputStreamWriter;

public class EsThread {

	public static void syncPrint(String a, String b) {
		Stampante s = new Stampante(new OutputStreamWriter(System.out));
		Thread aT = new Thread(() ->  {
			s.stampa(a);
			System.out.println();
		});
		Thread bT = new Thread(() ->  {
			s.stampa(b);
			System.out.println();
		});
		
		aT.start();
		bT.start();
		try {
			aT.join();
			bT.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void asyncPrint(String a, String b) {

		Thread aT = new Thread(() ->  {
			for(char c : a.toCharArray())
				System.out.print(c);
			System.out.println();
		});
		Thread bT = new Thread(() ->  {
			for(char c : b.toCharArray())
				System.out.print(c);
			System.out.println();
		});
		
		aT.start();
		bT.start();
		try {
			aT.join();
			bT.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}
	
	public static void main(String[] args) {
		
		int n = 300;
		String s1 = longStringGen('a', n);
		String s2 = longStringGen('b', n);
		
		System.out.println("Inizio stampa asincrona");
		asyncPrint(s1, s2);
		System.out.println("Fine stampa asincrona");
		System.out.println("Inizio stampa sincrona");
		syncPrint(s1, s2);
		System.out.println("Fine stampa sincrona");
		
	}

	public static String longStringGen(char c, int n) {
		String s = "";
		for(int i = 0; i < n; i++) {
			s += c;
		}
		
		return s;
	}
}
