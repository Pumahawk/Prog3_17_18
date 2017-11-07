package progetto.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MailServer extends Remote{
	public CasellaPostaElettronica openCasellaPostaElettronica(String email) throws RemoteException;
}
