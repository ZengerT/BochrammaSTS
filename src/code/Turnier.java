package code;

import java.util.ArrayList;

public class Turnier {

	private String turniername;
	private String veranstalter;
	private String plz;
	private String ort;
	private String datum;
	private ArrayList<Spieler> turnierlisteSpieler;

	// Getter&Setter

	public String getTurniername() {
		return turniername;
	}

	public void setTurniername(String turniername) {
		this.turniername = turniername;
	}

	public String getVeranstalter() {
		return veranstalter;
	}

	public void setVeranstalter(String veranstalter) {
		this.veranstalter = veranstalter;
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

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public ArrayList<Spieler> getTurnierlisteSpieler() {
		return turnierlisteSpieler;
	}

	public void setTurnierlisteSpieler(ArrayList<Spieler> tunierlisteSpieler) {
		this.turnierlisteSpieler = tunierlisteSpieler;
	}

	// Konsturktoren

	public Turnier() {
		turnierlisteSpieler = new ArrayList<Spieler>();
	}

	public Turnier(String tuniername, String veranstalter, String plz,
			String ort, String datum) {
		this.turniername = tuniername;
		this.veranstalter = veranstalter;
		this.plz = plz;
		this.ort = ort;
		this.datum = datum;
		turnierlisteSpieler = new ArrayList<Spieler>();
	}

	// Methoden

	public void hinzufuegenTurnierlisteSpieler(Spieler s) {
		this.turnierlisteSpieler.add(s);
	}

}
