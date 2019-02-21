package code;

public class Spieler {

	private static int i = 0;
	private int nummer;
	private String vorname;
	private String nachname;
	private String adresse;
	private String plz;
	private String ort;
	private String email;

	private int[] runde;
	private int[] tischnummer;
	private int[] rundeP;
	private int[] rundeM;
	private int[] solo;

	private int gesamt;
	private int gesamtM;
	private int gesamtP;

	private int soli;

	// Getter&Setter Array nach Index

	public int getRunde(int i) {
		return runde[i];
	}

	public void setRunde(int i, int val) {
		this.runde[i] = val;
	}

	public int getTischnummer(int i) {
		return tischnummer[i];
	}

	public void setTischnummer(int i, int val) {
		this.tischnummer[i] = val;
	}

	public int getRundeP(int i) {
		return rundeP[i];
	}

	public void setRundeP(int i, int val) {
		this.rundeP[i] = val;
	}

	public int getRundeM(int i) {
		return rundeM[i];
	}

	public void setRundeM(int i, int val) {
		this.rundeM[i] = val;
	}

	public int getSolo(int i) {
		return solo[i];
	}

	public void setSolo(int i, int val) {
		this.solo[i] = val;
	}

	// Getter&Setter

	public int[] getRunde() {
		return runde;
	}

	public void setRunde(int[] runde) {
		this.runde = runde;
	}

	public int[] getTischnummer() {
		return tischnummer;
	}

	public void setTischnummer(int[] tischnummer) {
		this.tischnummer = tischnummer;
	}

	public int[] getSolo() {
		return solo;
	}

	public void setSolo(int[] solo) {
		this.solo = solo;
	}

	public int[] getRundeP() {
		return rundeP;
	}

	public void setRundeP(int[] rundeP) {
		this.rundeP = rundeP;
	}

	public int[] getRundeM() {
		return rundeM;
	}

	public void setRundeM(int[] rundeM) {
		this.rundeM = rundeM;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGesamt() {
		return gesamt;
	}

	public void setGesamt(int gesamt) {
		this.gesamt = gesamt;
	}

	public int getGesamtM() {
		return gesamtM;
	}

	public void setGesamtM(int gesamtM) {
		this.gesamtM = gesamtM;
	}

	public int getGesamtP() {
		return gesamtP;
	}

	public void setGesamtP(int gesamtP) {
		this.gesamtP = gesamtP;
	}

	public int getSoli() {
		return soli;
	}

	public void setSoli(int soli) {
		this.soli = soli;
	}

	public int getNummer() {
		return nummer;
	}

	// Konstruktoren

	public Spieler() {
		this.nummer = i + 1;
		i++;
		initArrays();
	}

	public Spieler(String vorname, String nachname) {
		this.nummer = i + 1;
		i++;
		this.vorname = vorname;
		this.nachname = nachname;
		initArrays();
	}

	public Spieler(String vorname, String nachname, String adresse, String plz,
			String ort, String email) {
		this.nummer = i + 1;
		i++;
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = adresse;
		this.plz = plz;
		this.ort = ort;
		this.email = email;
		initArrays();
	}

	// Method

	private void initArrays() {

		runde = new int[10];
		rundeM = new int[10];
		rundeP = new int[10];
		tischnummer = new int[10];
		solo = new int [10];
	}

}
