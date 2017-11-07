package progetto.server;

import progetto.server.events.MailAdapter;
import progetto.server.events.MailEvent;

public class EmailController extends MailAdapter {

	@Override
	public void mailArrivata(MailEvent e) {
		ServerApp.echo.println("--MailController--");
		ServerApp.echo.println("Evento: mailArrivata");
		if(e.getSource().getClass().equals(CasellaEMail.class)) {
			CasellaEMail cm = (CasellaEMail) e.getSource();
			ServerApp.echo.println("Sorgente evento: " + cm);
			ServerApp.echo.println("Indirizzo: " + cm.indirizzo);
		} else {
			ServerApp.echo.println("Sorgente evento sconosciuta. " + e.getSource());
		}
	}

	@Override
	public void mailSpedita(MailEvent e) {
		
	}

}
