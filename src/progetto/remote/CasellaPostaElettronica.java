package progetto.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import progetto.server.events.MailListener;

public interface CasellaPostaElettronica extends Remote {
	public static interface CasellaInfo {
		public String getIndirizzo();
	}
	public List<Mail> getAllEmail() throws RemoteException;
	public Mail getEmailById(int id) throws RemoteException;
	public boolean inviaEmail(String destinatario, Mail email) throws RemoteException;
	public boolean inviaEmail(List<String> destinatari, Mail email) throws RemoteException;
	public CasellaInfo getInfo() throws RemoteException;
}
