package progetto.server;

import java.io.PrintStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerApp {

	static private EmailServerImpl server;
	static public final int portRMIRegistry = 1099;
	static public final PrintStream echo = System.out;
	
	public static EmailServerImpl getServer() {
		return server;
	}
	
	public static boolean initServer() {
		if(!avviaRMIRegistry()) {
			echo.println("Impossibile inizializzare registro. Porta "
					+ portRMIRegistry + " occupata.");
			System.exit(-1);
		}
		try {
			server = new EmailServerImpl();
			EmailServerImpl.serverActive = server;
		} catch (RemoteException e) {
			e.printStackTrace();
			echo.println("Impossibile inizializzare il server. Lanciata una RemoteException.");
			System.exit(-1);
		}
		try {
			Naming.rebind("//localhost/MailServer", server);
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
			echo.println("Impossibile fare binding del server.");
			System.exit(-1);
		}
		return true;
	}
	
	protected static boolean avviaRMIRegistry() {
		try {
			LocateRegistry.createRegistry(1099);
			return true;
		} catch (RemoteException e) {
			return false;
		}
	}
	
	public static void main(String[] args) throws RemoteException {
		echo.println("Avvio metodo main.");
		echo.println("Inizializzazione server metodo main.");
		initServer();
		ServerApp.server.openCasellaPostaElettronica("ind1");
		ServerApp.server.openCasellaPostaElettronica("ind2");
	}

}
