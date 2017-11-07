package progetto.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import progetto.remote.CasellaPostaElettronica;
import progetto.remote.Mail;
import progetto.remote.MailServer;

public class ClientMailApp {
	private static MailServer serverMail;
	public static MailServer getServerMail() {
		return serverMail;
	}
	
	private static MailServer connectServer() {
		try {
			MailServer s =
					(MailServer)Naming.lookup("//localhost/MailServer");
			return s;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) throws RemoteException {
		if((serverMail = connectServer()) == null) {
			System.out.println("Impossibile connettersi al server.");
			System.exit(-1);
		}
		CasellaPostaElettronica ch = serverMail.openCasellaPostaElettronica("ind2");
		ch.inviaEmail("ind2", new Mail(1, ch.getInfo().getIndirizzo(), "oggetto", "testo"));
		for(Mail m : ch.getAllEmail())
			System.out.println(m.oggetto);
	}
}
