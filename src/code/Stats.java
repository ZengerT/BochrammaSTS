package code;

public class Stats {

	private int spielerVal;
	private int insgesamtPlusVal;
	private int insgesamtMinusVal;
	private int soliVal;
	private double midlVal;
	private double plusMidlVal;
	private double minusMidlVal;

	// Getter&Setter

	public int getSpielerVal() {
		return spielerVal;
	}

	public void setSpielerVal(int spielerVal) {
		this.spielerVal = spielerVal;
	}

	public int getInsgesamtPlusVal() {
		return insgesamtPlusVal;
	}

	public void setInsgesamtPlusVal(int insgesamtPlusVal) {
		this.insgesamtPlusVal = insgesamtPlusVal;
	}

	public int getInsgesamtMinusVal() {
		return insgesamtMinusVal;
	}

	public void setInsgesamtMinusVal(int insgesamtMinusVal) {
		this.insgesamtMinusVal = insgesamtMinusVal;
	}

	public int getSoliVal() {
		return soliVal;
	}

	public void setSoliVal(int soliVal) {
		this.soliVal = soliVal;
	}

	public double getMidlVal() {
		return midlVal;
	}

	public void setMidlVal(double midlVal) {
		this.midlVal = midlVal;
	}

	public double getPlusMidlVal() {
		return plusMidlVal;
	}

	public void setPlusMidlVal(double plusMidlVal) {
		this.plusMidlVal = plusMidlVal;
	}

	public double getMinusMidlVal() {
		return minusMidlVal;
	}

	public void setMinusMidlVal(double minusMidlVal) {
		this.minusMidlVal = minusMidlVal;
	}

	// Statistiken
	
	public void clearStat(){
		spielerVal = 0;
		soliVal = 0;
		insgesamtPlusVal = 0;
		insgesamtMinusVal = 0;
	}

	public void calculateMidVal() {
		midlVal = (double) (insgesamtPlusVal - insgesamtMinusVal) / spielerVal;
	}

	public void calculatePlusMidVal() {
		plusMidlVal = (double) insgesamtPlusVal / spielerVal;
	}

	public void calculateMinusMidVal() {
		minusMidlVal = (double) insgesamtMinusVal / spielerVal;
	}

	public void getTurnierVals(Turnier tun) {
		clearStat();
		
		spielerVal = tun.getTurnierlisteSpieler().size();

		for (Spieler sp : tun.getTurnierlisteSpieler()) {
			soliVal = soliVal + sp.getSoli();
			insgesamtPlusVal = insgesamtPlusVal + sp.getGesamtP();
			insgesamtMinusVal = insgesamtMinusVal + sp.getGesamtM();
		}
	}

	// Statistiken berechnen gesamt

	public void calStats(Turnier tun) {
		getTurnierVals(tun);
		calculateMidVal();
		calculatePlusMidVal();
		calculateMinusMidVal();
		
	}

}
