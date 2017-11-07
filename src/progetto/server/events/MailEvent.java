package progetto.server.events;

import java.util.EventObject;

import progetto.remote.Mail;

public class MailEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	private final Mail mail;

	public MailEvent(Object arg0, Mail mail) {
		super(arg0);
		this.mail = mail;
	}
	
	public Mail getMail() {
		return this.mail;
	}

}
