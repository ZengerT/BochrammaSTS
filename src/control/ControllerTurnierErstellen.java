package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import docs.AllAllowedDocument;
import docs.IntegerDocument;
import docs.StringDocument;

import hmi.TurnierErstellen;

public class ControllerTurnierErstellen {

	private TurnierErstellen currentTurnierErstellen;

	private String name;
	private String veranstalter;
	private String datum;
	private String plz;
	private String ort;

	// Getter&Setter, Konstruktor

	public TurnierErstellen getCurrentTurnierErstellen() {
		return currentTurnierErstellen;
	}

	public void setCurrentTurnierErstellen(
			TurnierErstellen currentTurnierErstellen) {
		this.currentTurnierErstellen = currentTurnierErstellen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVeranstalter() {
		return veranstalter;
	}

	public void setVeranstalter(String veranstalter) {
		this.veranstalter = veranstalter;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public ControllerTurnierErstellen(JFrame main) {

		this.currentTurnierErstellen = new TurnierErstellen(main);
		addDocs();
		addListener();
		okNotPossible();
		this.currentTurnierErstellen.setVisible(true);
	}

	// Methoden

	public void erstellen() {
		name = currentTurnierErstellen.getInputName().getText();
		veranstalter = currentTurnierErstellen.getInputVeranstalter().getText();
		datum = currentTurnierErstellen.getInputDatum().getText();
		plz = currentTurnierErstellen.getInputPLZ().getText();
		ort = currentTurnierErstellen.getInputOrt().getText();
		currentTurnierErstellen.dispose();
	}

	public void okNotPossible() {
		getCurrentTurnierErstellen().getOkButton().setEnabled(false);
	}

	public void okPossible() {
		getCurrentTurnierErstellen().getOkButton().setEnabled(true);
	}

	public void addListener() {
		this.currentTurnierErstellen.setokButtonListener(new okTEListener());
		this.currentTurnierErstellen
				.setCancelButtonListener(new cancelTEListener());
		this.currentTurnierErstellen.setTextFieldListener(
				this.currentTurnierErstellen.getInputName(),
				new isEmptyListener());
		this.currentTurnierErstellen.setTextFieldListener(
				this.currentTurnierErstellen.getInputVeranstalter(),
				new isEmptyListener());
		this.currentTurnierErstellen.setTextFieldListener(
				this.currentTurnierErstellen.getInputDatum(),
				new isEmptyListener());
		this.currentTurnierErstellen.setTextFieldListener(
				this.currentTurnierErstellen.getInputPLZ(),
				new isEmptyListener());
		this.currentTurnierErstellen.setTextFieldListener(
				this.currentTurnierErstellen.getInputOrt(),
				new isEmptyListener());
	}

	public void addDocs() {

		this.currentTurnierErstellen.getInputPLZ().setDocument(
				new IntegerDocument(5));
		this.currentTurnierErstellen.getInputOrt().setDocument(
				new StringDocument(32));
		this.currentTurnierErstellen.getInputName().setDocument(
				new AllAllowedDocument(128));
		this.currentTurnierErstellen.getInputVeranstalter().setDocument(
				new AllAllowedDocument(128));

	}

	// Listener

	class okTEListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			erstellen();
		}

	}

	class cancelTEListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			currentTurnierErstellen.dispose();

		}

	}

	class isEmptyListener implements DocumentListener {

		Document doc;

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			int name = currentTurnierErstellen.getInputName().getDocument()
					.getLength();
			int veranstalter = currentTurnierErstellen.getInputVeranstalter()
					.getDocument().getLength();
			int datum = currentTurnierErstellen.getInputDatum().getDocument()
					.getLength();
			int plz = currentTurnierErstellen.getInputPLZ().getDocument()
					.getLength();
			int ort = currentTurnierErstellen.getInputOrt().getDocument()
					.getLength();
			if (name > 0 && veranstalter > 0 && datum > 0 && plz > 0 && ort > 0) {
				okPossible();

			} else {
				okNotPossible();
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			int name = currentTurnierErstellen.getInputName().getDocument()
					.getLength();
			System.out.println(name);
			int veranstalter = currentTurnierErstellen.getInputVeranstalter()
					.getDocument().getLength();
			int datum = currentTurnierErstellen.getInputDatum().getDocument()
					.getLength();
			int plz = currentTurnierErstellen.getInputPLZ().getDocument()
					.getLength();
			int ort = currentTurnierErstellen.getInputOrt().getDocument()
					.getLength();
			if (name <= 0 || veranstalter <= 0 || datum <= 0 || plz <= 0
					|| ort <= 0) {
				okNotPossible();
			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
