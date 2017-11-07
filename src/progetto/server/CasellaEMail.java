package progetto.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.event.EventListenerList;
import progetto.remote.CasellaPostaElettronica;
import progetto.remote.Mail;
import progetto.server.events.MailEvent;
import progetto.server.events.MailListener;

public class CasellaEMail extends UnicastRemoteObject implements CasellaPostaElettronica{
	
	public static class CasellaInfoImpl implements CasellaInfo, Serializable {

		private static final long serialVersionUID = 1L;
		String indirizzo;
		public CasellaInfoImpl(String indirizzo) throws RemoteException {
			super();
			this.indirizzo = indirizzo;
		}
		@Override
		public String getIndirizzo() {
			return indirizzo;
		}
		
	}

	private static final long serialVersionUID = 1L;
	protected EmailServerImpl server;
	AtomicInteger idCounter;
	protected String indirizzo;
	protected List<Mail> emailList = new LinkedList<>();
	private EventListenerList eventList = new EventListenerList();

	protected CasellaEMail(String indirizzo, EmailServerImpl server) throws RemoteException {
		super();
		this.indirizzo = indirizzo;
		this.server = server;
		idCounter = new AtomicInteger(0);
	}
	
	protected CasellaEMail(String nome) throws RemoteException {
		this(nome, EmailServerImpl.serverActive);
	}

	@Override
	public List<Mail> getAllEmail() throws RemoteException {
		List<Mail> l = new LinkedList<>();
		synchronized(this.emailList) {
			l.addAll(this.emailList);
		}
		return l;
	}

	@Override
	public Mail getEmailById(int id) throws RemoteException {
		for(Mail m : emailList) {
			if(m.id == id)
				return m;
		}
		return null;
	}

	@Override
	public boolean inviaEmail(String destinatario, Mail email) throws RemoteException {
		CasellaEMail c = this.server.casellePosta.get(destinatario);
		c.addMail(email);
		c.fireMailArrivata(new MailEvent(this, email));
		this.fireMailSpedita(new MailEvent(this, email));
		return true;
	}

	@Override
	public boolean inviaEmail(List<String> destinatari, Mail email) throws RemoteException {
		for(String indirizzo : destinatari) {
			inviaEmail(indirizzo, email);
		}
		return true;
	}
	
	public void addMailListener(MailListener listener) throws RemoteException {
		eventList.add(MailListener.class, listener);
	}

	protected void fireMailArrivata(MailEvent e) {
		for(MailListener l : eventList.getListeners(MailListener.class)) {
			l.mailArrivata(e);
		}
	}
	
	protected void fireMailSpedita(MailEvent e) {
		for(MailListener l : eventList.getListeners(MailListener.class)) {
			l.mailSpedita(e);
		}
	}
	
	public void addMail(Mail m) {
		synchronized (this.emailList) {
			this.emailList.add(m);
			this.idCounter.incrementAndGet();
		}
	}

	@Override
	public CasellaInfo getInfo() throws RemoteException {
		return new CasellaInfoImpl(this.indirizzo);
	}

}
