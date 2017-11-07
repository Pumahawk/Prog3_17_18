package progetto.server.events;

import java.util.EventListener;

public interface MailListener extends EventListener {
	public void mailArrivata(MailEvent e);
	public void mailSpedita(MailEvent e);
}
