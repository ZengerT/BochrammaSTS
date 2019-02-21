package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import verifierAndValidator.EmailValidator;

import code.Spieler;
import docs.AdressDocument;
import docs.IntegerDocument;
import docs.StringDocument;
import hmi.SpielerAnlegen;

public class ControllerSpielerAnlegen {

	private String vorname;
	private String nachname;
	private String adresse;
	private String ort;
	private String plz;
	private String mail;
	private Spieler neu;
	private SpielerAnlegen currentSpielerAnlegen;

	// Getter&Setter, Konstruktor

	public SpielerAnlegen getCurrentSpielerAnlegen() {
		return currentSpielerAnlegen;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setCurrentSpielerAnlegen(SpielerAnlegen currentSpielerAnlegen) {
		this.currentSpielerAnlegen = currentSpielerAnlegen;
	}

	public Spieler getNeu() {
		return neu;
	}

	public void setNeu(Spieler neu) {
		this.neu = neu;
	}

	public ControllerSpielerAnlegen(JFrame main) {

		this.currentSpielerAnlegen = new SpielerAnlegen(main);
		addDoc();
		addListener();
		okNotPossible();

		this.currentSpielerAnlegen.setVisible(true);

	}

	// Methoden

	public void addDoc() {
		this.currentSpielerAnlegen.getInputVorname().setDocument(
				new StringDocument(24));
		this.currentSpielerAnlegen.getInputNachname().setDocument(
				new StringDocument(36));
		this.currentSpielerAnlegen.getInputAdresse().setDocument(
				new AdressDocument(72));
		this.currentSpielerAnlegen.getInputOrt().setDocument(
				new StringDocument(32));
		this.currentSpielerAnlegen.getInputPLZ().setDocument(
				new IntegerDocument(5));
		// this.currentSpielerAnlegen.getInputMail().setDocument();

	}

	public void addListener() {
		this.currentSpielerAnlegen.getInputMail().addFocusListener(
				new emailListener());
		this.currentSpielerAnlegen.setokButtonListener(new okSAListener());
		this.currentSpielerAnlegen
				.setCancelButtonListener(new cancelSAListener());
		this.currentSpielerAnlegen.setTextFieldListener(
				this.currentSpielerAnlegen.getInputVorname(),
				new isEmptyListener());
		this.currentSpielerAnlegen.setTextFieldListener(
				this.currentSpielerAnlegen.getInputNachname(),
				new isEmptyListener());
	}

	public void okNotPossible() {
		getCurrentSpielerAnlegen().getOkButton().setEnabled(false);
	}

	public void okPossible() {
		getCurrentSpielerAnlegen().getOkButton().setEnabled(true);
	}

	// Listener

	class okSAListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			vorname = currentSpielerAnlegen.getInputVorname().getText();
			nachname = currentSpielerAnlegen.getInputNachname().getText();
			adresse = currentSpielerAnlegen.getInputAdresse().getText();
			plz = currentSpielerAnlegen.getInputPLZ().getText();
			ort = currentSpielerAnlegen.getInputOrt().getText();
			// if empty mit anderen Konstruktor implementieren! Eleganter!!!
			mail = currentSpielerAnlegen.getInputMail().getText();
			neu = new Spieler(vorname, nachname);
			if (adresse != null) {
				neu.setAdresse(adresse);
			}
			if (mail != null) {
				neu.setEmail(mail);
			}
			if (ort != null && plz != null) {
				neu.setOrt(ort);
				neu.setPlz(plz);
			}
			currentSpielerAnlegen.dispose();
		}

	}

	class cancelSAListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			currentSpielerAnlegen.dispose();

		}

	}

	class isEmptyListener implements DocumentListener {

		Document doc;

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			int vorname = currentSpielerAnlegen.getInputVorname().getDocument()
					.getLength();
			int nachname = currentSpielerAnlegen.getInputNachname()
					.getDocument().getLength();
			if (vorname > 0 && nachname > 0) {
				okPossible();

			} else {
				okNotPossible();
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			int vorname = currentSpielerAnlegen.getInputVorname().getDocument()
					.getLength();
			int nachname = currentSpielerAnlegen.getInputNachname()
					.getDocument().getLength();
			if (vorname <= 0 || nachname <= 0) {
				okNotPossible();
			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class emailListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			EmailValidator validator = new EmailValidator();
			String email = currentSpielerAnlegen.getInputMail().getText();
			if (!validator.validate(email)) {
				currentSpielerAnlegen.getInputMail().setText("");
			}
		}

	}

}
