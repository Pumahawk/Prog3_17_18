package progetto.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import progetto.remote.CasellaPostaElettronica;
import progetto.remote.MailServer;

public class EmailServerImpl extends UnicastRemoteObject implements MailServer{
	public static EmailServerImpl serverActive;
	private static final long serialVersionUID = 1L;
	public final  Map<String, CasellaEMail> casellePosta;
	
	protected EmailServerImpl() throws RemoteException {
		super();
		casellePosta = new HashMap<>();
	}

	@Override
	public CasellaPostaElettronica openCasellaPostaElettronica(String email) throws RemoteException {
		if(casellePosta.containsKey(email))
			return casellePosta.get(email);
		else {
			CasellaEMail ch = createCasella(email);
			ch.addMailListener(new EmailController());
			return ch;
		}
		
	}
	protected CasellaEMail createCasella(String casella) throws RemoteException {
		CasellaEMail c = new CasellaEMail(casella);
		synchronized(casellePosta) {
			casellePosta.put(casella, c);
		}
		return c;
	}

}
