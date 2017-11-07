package progetto.remote;

import java.io.Serializable;

public class Mail implements Serializable{
	private static final long serialVersionUID = -940567170539931600L;
	public final int id;
	public final String mittente;
	public final String oggetto;
	public final String testo;
	public Mail(int id, String mittente, String oggetto, String testo) {
		super();
		this.id = id;
		this.mittente = mittente;
		this.oggetto = oggetto;
		this.testo = testo;
	}
}
